import java.util.*;

public class SymbolTable {
    static ArrayList<stNode> tokenSet = new ArrayList<>(); //for a single line
    static class stNode {
        String ClassPart = "";
        String ValuePart = "";
        static stNode temp;

        stNode(String _classPart, String _valuePart) {
            this.ClassPart = _classPart;
            this.ValuePart = _valuePart;
        }

        static stNode newNode (String _classPart, String _valuePart) {
            temp = new stNode(_classPart, _valuePart);
            return temp;
        }
    }

    /*
     * hash table is one to one mapped class part->value part
     */
    static Hashtable<String, String> completeSymbolTable = new Hashtable<>(); //for the whole file
    static ClassPart cp = new ClassPart();

    /*
     * function finds key for the key-value pair in hash table
     */

    static String findKey (String valuePart) {
        String key= null;
        for(Map.Entry<String, String> entry: completeSymbolTable.entrySet()){
            if(valuePart.equals(entry.getValue())){
                key = (String) entry.getKey();
                break; //breaking because its one to one map
            }
        }
        return key;
    }


    static int id = 1, num = 1, flt = 1, kw = 1, func = 1, str = 1, cc;

    /*
     * function gets class part and value part as input
     * checks if the symbol table already has tha value part
     * if yes we find its key and add it to token set and return
     * if no we add it to symbol table and add its identifier (key) (class part)
     * enforces one-to-one mapping of hash table
     */

    public static void checkAndInsert(String classPart, String valuePart) {

        if (classPart == "operator") {
            if (completeSymbolTable.contains(valuePart)) { //check if its already inserted
                tokenSet.add(SymbolTable.stNode.newNode(findKey(valuePart), valuePart));
                return;
            }
            classPart = (String) cp.ht1.get(valuePart);

        }
        else if (classPart == "punctuation") {
            if (completeSymbolTable.contains(valuePart)) { //check if its already inserted
                tokenSet.add(SymbolTable.stNode.newNode(findKey(valuePart), valuePart));
                return;
            }
            classPart = (String) cp.ht1.get(valuePart);

        }
        // functions -> isordered
        else if (classPart == "func") {
            if (completeSymbolTable.contains(valuePart)) { //check if its already inserted
                tokenSet.add(SymbolTable.stNode.newNode(findKey(valuePart), valuePart));
                return;
            }
            classPart += func;
            func++;
        }
        // String -> isordered
        else if (classPart == "str") {
            if (completeSymbolTable.contains(valuePart)) { //check if its already inserted
                tokenSet.add(SymbolTable.stNode.newNode(findKey(valuePart), valuePart));
                return;
            }
            classPart += str;
            str++;
        }
        // floats -> is ordered
        else if (classPart == "flt") {
            if (completeSymbolTable.contains(valuePart)) { //check if its already inserted
                tokenSet.add(SymbolTable.stNode.newNode(findKey(valuePart), valuePart));
                return;
            }
            classPart += flt; // concatenation
            flt++;
        } // ints -> is ordered
        else if (classPart == "num") {
            if (completeSymbolTable.contains(valuePart)) { //check if its already inserted
                tokenSet.add(SymbolTable.stNode.newNode(findKey(valuePart), valuePart));
                return;
            }
            classPart += num;
            num++;
        } // identifiers -> is ordered
        else if (classPart == "id") {
            if (completeSymbolTable.contains(valuePart)) { //check if its already inserted
                tokenSet.add(SymbolTable.stNode.newNode(findKey(valuePart), valuePart));
                return;
            }
            classPart += id;
            id++;
        } // keywords -> ordered
        else if (classPart == "keyword") {
            if (completeSymbolTable.contains(valuePart)) { //check if its already inserted
                tokenSet.add(SymbolTable.stNode.newNode(findKey(valuePart), valuePart));
                return;
            }
            classPart += kw;
            kw++;
        } else if (classPart == "char") {
            if (completeSymbolTable.contains(valuePart)) { //check if its already inserted
                tokenSet.add(SymbolTable.stNode.newNode(findKey(valuePart), valuePart));
                return;
            }
            classPart += cc;
            cc++;
        }

        for (int i = 0; i < tokenSet.size(); i++) {
            if (tokenSet.get(i).ClassPart == classPart) { //check if its already inserted
                return;
            }
        }
        tokenSet.add(SymbolTable.stNode.newNode(classPart, valuePart));
        completeSymbolTable.put(classPart, valuePart);

    }

    /*
    public static void main(String[] args) {
        ArrayList<String> tokenlList = new ArrayList<>();
        tokenlList.add("void");
        tokenlList.add("func");
        tokenlList.add("printIt");
        tokenlList.add("(");
        tokenlList.add("str");
        tokenlList.add("name");
        tokenlList.add(")");
        tokenlList.add("{");

        checkAndInsert("id", "void");
        checkAndInsert("keyword", "func");
        checkAndInsert("id", "printIt");
        checkAndInsert("punctuation", "(");
        checkAndInsert("keyword", "str"); 
        checkAndInsert("id", "name");
        checkAndInsert("punctuation", ")");
        checkAndInsert("punctuation", "{");

        System.out.println(tokenSet);
    }
    */
}

