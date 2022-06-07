import java.util.ArrayList;
// import java.util.regex.Pattern;
// import java.util.regex.Matcher;
import java.util.regex.*;

public class Regex {
    // Character Constant regex
    public static boolean isCharacterConstant(String IC) {
        // tells matcher class to match identifier against this RE
        // Pattern p = Pattern.compile("^[\\]|[\b\t\n\f\r\'\"]$"); // throws error
        //Pattern p = Pattern.compile("^[\\\b\t\n\f\r\'\"]$"); // \ - false
        Pattern p = Pattern.compile("^[\b\t\n\f\r\'\"]$");
        // matches against RE
        java.util.regex.Matcher m = p.matcher(IC);
        // m.matches return true if matched
        return (m.matches());

    }

    // Identifier regex
    public static boolean isIdentifier(String Identifier) {
        // tells matcher class to match identifier against this RE
        Pattern p = Pattern.compile("^[_$][A-Za-z_][A-Za-z0-9_]|[A-Za-z_][A-Za-z0-9_]*$");
        // matches against RE
        java.util.regex.Matcher m = p.matcher(Identifier);
        // m.matches return true if matched
        return (m.matches());
    }

    // Interger regex
    public static boolean isIntegerConstant(String intC) {
        // tells matcher class to match identifier against this RE
        Pattern p = Pattern.compile("^[0-9]+|[+-][0-9]+$");
        // matches against RE
        java.util.regex.Matcher m = p.matcher(intC);
        // m.matches return true if matched
        return (m.matches());
    }

    // Float regex
    public static boolean isFloat(String fl) {
        // tells matcher class to match identifier against this RE
        Pattern p = Pattern.compile("^[0-9]*[`][0-9]+|[+-][0-9]+[`][0-9]+$");
        // matches against RE
        java.util.regex.Matcher m = p.matcher(fl);
        // m.matches return true if matched
        return (m.matches());
    }

    // Keyword regex
    static boolean isKeyword(String toCheck) {
        // defined keywords
        ArrayList<String> keywords = new ArrayList<>();
        keywords.add("main");
        keywords.add("import");
        // Data types
        keywords.add("int");
        keywords.add("float");
        keywords.add("bool");
        keywords.add("array");
        // keywords.add("Date");
        keywords.add("str"); // changed
        keywords.add("const"); // a final var ; not changing var
        keywords.add("char");
        keywords.add("void");
        keywords.add("break");
        keywords.add("continue");
        // switch
        keywords.add("switch");
        keywords.add("case");
        keywords.add("default");
        // if else
        keywords.add("if");
        keywords.add("else");
        // loops
        keywords.add("for");
        keywords.add("while");
        keywords.add("returns");
        // Error handling
        // keywords.add("assert");
        // keywords.add("catch");
        // keywords.add("finally");
        // keywords.add("throw");
        // keywords.add("throws");
        // keywords.add("try");
        // keywords.add("ID");
        keywords.add("print"); // changed
        keywords.add("input"); // changed
        // oops
        keywords.add("instanceof");
        keywords.add("Class");
        keywords.add("abstract");
        keywords.add("inherits"); // extends changed
        keywords.add("implements");
        keywords.add("interface");
        keywords.add("super");
        keywords.add("this");
        // keywords.add("native");
        keywords.add("new");
        // func dec and calling
        keywords.add("func"); // for declaration of function changed
        keywords.add("call"); // for calling a function changed
        // modifiers
        keywords.add("static");
        keywords.add("public");
        keywords.add("private");
        keywords.add("protected");
        //bool
        keywords.add("true");
        keywords.add("false");

        for (int i = 0; i < keywords.size(); i++) {
            if (keywords.get(i).equals(toCheck)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPunctuation(char toCheck) {
        // defined punctuations
        ArrayList<String> punc = new ArrayList<>();
        punc.add(","); // comma
        punc.add(".");
        punc.add(";");
        punc.add("+"); // concatenation
        // punc.add("'"); // single quotation
        // punc.add("\""); // double quotation
        // Round brackets
        punc.add("(");
        punc.add(")");
        // Square brackets
        punc.add("[");
        punc.add("]");
        // Curly brackets
        punc.add("{");
        punc.add("}");

        for (int i = 0; i < punc.size(); i++) {
            if (punc.get(i).equals(Character.toString(toCheck))) {
                return true;
            }
        }
        return false;
    }

    // Single operator regex
    public static boolean isSingleOperator(char toCheck) {
        // defined operators
        ArrayList<String> singleOperator = new ArrayList<>();
        // Arithmetic operators
        singleOperator.add("+");
        singleOperator.add("-");
        singleOperator.add("*");
        singleOperator.add("/");
        singleOperator.add("^");
        singleOperator.add("%");
        // Assignment operators
        singleOperator.add("=");
        singleOperator.add(">"); // greater than
        singleOperator.add("<"); // less than
        // Bitwise operators
        singleOperator.add("&"); // AND-b op
        singleOperator.add("|"); // OR-b-op
        singleOperator.add("#"); // XOR-b
        singleOperator.add("~"); // NOT-b

        for (int i = 0; i < singleOperator.size(); i++) {
            if (singleOperator.get(i).equals(Character.toString(toCheck))) {
                return true;
            }
        }
        return false;
    }

    // Double operators regex
    public static boolean isDoubleOperator(String toCheck) {
        // defined operators
        ArrayList<String> doubleOperator = new ArrayList<>();
        // increment and decrement
        doubleOperator.add("++");
        doubleOperator.add("--");
        // Assignment operators
        doubleOperator.add("+=");
        doubleOperator.add("-=");
        doubleOperator.add("*=");
        doubleOperator.add("/=");
        doubleOperator.add("%=");
        doubleOperator.add("!=");
        doubleOperator.add("==");
        doubleOperator.add("<=");
        doubleOperator.add(">=");
        // Logical operators
        doubleOperator.add("||"); // OR-l-op
        doubleOperator.add("&&"); // AND-l-op
        doubleOperator.add("!!"); // NOT-l-op
        // Shift operators
        doubleOperator.add("<<"); // double shift left
        doubleOperator.add(">>"); // double shift right

        for (int i = 0; i < doubleOperator.size(); i++) {
            if (doubleOperator.get(i).equals(toCheck)) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(isCharacterConstant("'"));
        String x = "\'";
        System.out.println(x.length());
    }
}
