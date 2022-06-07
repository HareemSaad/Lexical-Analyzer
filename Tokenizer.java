import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tokenizer {
    static int lineNo = 1; 
    /*
     * function reads line
     * function calculates line number
     * checks for tokens
     * inserts them into symbol table
     * prints out token list
     * prints out invalid characters
     */
    static void scan(String input) {
        boolean flag = false;
        ArrayList<String> tokenlList = new ArrayList<>();
        int i = 0;
        String token = "";
        while (i < input.length()) {
            flag = false;
            token = "";
            if(input.charAt(i) == '/' && input.charAt(i+1) == '/') {
                while (i < input.length() && input.charAt(i) != '\n') {
                    i++;
                }
                continue;
            } else if(input.charAt(i) == ' '){
                i++;
                continue;
            } else if(input.charAt(i) == '_' || input.charAt(i) == '$' || input.charAt(i) >= 'A' && input.charAt(i) <= 'Z' || input.charAt(i) >= 'a' && input.charAt(i) <= 'z'){
                while (i < input.length() && input.charAt(i) != ' ' && input.charAt(i) != ';' && Regex.isSingleOperator(input.charAt(i)) != true && Regex.isPunctuation(input.charAt(i)) != true) {
                    token += input.charAt(i);
                    i++;
                }
                if(Regex.isKeyword(token)) {
                    SymbolTable.checkAndInsert("keyword", token);
                    flag = true;
                }
                else if(Regex.isIdentifier(token)) {
                    SymbolTable.checkAndInsert("id", token);
                    flag = true;
                }
            } else if(input.charAt(i) == '+' && input.charAt(i+1) >= '0' && input.charAt(i+1) <= '9' || input.charAt(i) == '-' && input.charAt(i+1) >= '0' && input.charAt(i+1) <= '9' || input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                do {
                    token += input.charAt(i);
                    i++;
                } while (i < input.length() && input.charAt(i) != ' ' && input.charAt(i) != ';' && Regex.isSingleOperator(input.charAt(i)) != true && Regex.isPunctuation(input.charAt(i)) != true);
                if(Regex.isIntegerConstant(token)) {
                    SymbolTable.checkAndInsert("num", token);
                    flag = true;
                }
                if(Regex.isFloat(token)) {
                    SymbolTable.checkAndInsert("flt", token);
                    flag = true;
                }
            } else if (input.charAt(i) == '"') {
                do {
                    token += input.charAt(i);
                    i++;
                } while (input.charAt(i) != '"' && i < input.length());
                token += '"';
                SymbolTable.checkAndInsert("str", token);
                flag = true;
                i++;
            } else if(Regex.isSingleOperator(input.charAt(i))) {
                if(i+1 < input.length())
                    token = Character.toString(input.charAt(i)) + Character.toString(input.charAt(i+1)); 
                if(Regex.isDoubleOperator(token)) {
                    i++;
                } else {
                    token = "";
                    token = Character.toString(input.charAt(i));
                }
                SymbolTable.checkAndInsert("operator", token);
                flag = true;
                i++;
            } else if (Regex.isPunctuation(input.charAt(i))) {
                token += input.charAt(i);
                SymbolTable.checkAndInsert("punctuation", token);
                flag = true;
                i++;
            } else if (i+1 < input.length() && input.charAt(i) == '\\') {
                token = Character.toString(input.charAt(i)) + Character.toString(input.charAt(i+1));
                Regex.isCharacterConstant(token);
                SymbolTable.checkAndInsert("char", token);
                flag = true;
                i+=2;
            }
            if (flag) {
                tokenlList.add(token);
            } else {
                if (token != "")
                    System.out.println("invalid token: " + token);
                System.out.println("invalid token: " + input.charAt(i));
                i++;
            }
        }
        System.out.println("Line " + lineNo + " has " + tokenlList.size() + " tokens.");
        System.out.println(tokenlList);
        lineNo++;
    }
    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File("C:\\Users\\Home\\Desktop\\input.txt"); //file input
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) { //scans line by line
            System.out.println();
            scan(sc.nextLine()); //call function

            //print token set
            System.out.print("<");
            for (int i = 0; i < SymbolTable.tokenSet.size(); i++) {
                System.out.print("(" + SymbolTable.tokenSet.get(i).ClassPart + " = " + SymbolTable.tokenSet.get(i).ValuePart + ")");
                if(i != SymbolTable.tokenSet.size()-1) {
                    System.out.print(", ");
                }
            }
            System.out.println(">");
            SymbolTable.tokenSet.clear();
            //System.out.println(sc.nextLine());
        }

        sc.close();
        System.out.println("\n" + SymbolTable.completeSymbolTable); //print symbol table
    }
}