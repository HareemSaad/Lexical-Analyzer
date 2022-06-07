import java.util.*;

public class ClassPart {
    Hashtable<String, String> ht1;

    public ClassPart() {
        ht1 = new Hashtable<>();
        
        ht1.put("+", "add-op");
        ht1.put("-", "sub-op");
        ht1.put("*", "mul-op");
        ht1.put("/", "div-op");
        ht1.put("^", "pow-op");
        ht1.put("%", "mod-op");
        // logical ops
        ht1.put("&&", "AND-l-op");
        ht1.put("||", "OR-l-op");
        ht1.put("!!", "NOT-l-op");
        // ht1.put("bitwise ops
        ht1.put("&", "AND-b-op");
        ht1.put("|", "OR-b-op");
        ht1.put("#", "XOR-b-op");
        ht1.put("~", "NOT-b-op");
        ht1.put("<<", "left-shift-b-op");
        ht1.put(">>", "right-shift-b-op");
        // ht1.put("relational ops
        ht1.put("=", "eq-op");
        ht1.put("==", "is-eq-op");
        ht1.put("<", "is-lesser-op");
        ht1.put(">", "is-greater-op");
        ht1.put("<=", "is-lessEq-op");
        ht1.put(">=", "is-greaterEq-op");
        ht1.put("!=", "is-notEq-op");
        // assignment ops
        ht1.put("+=", "addEq-op");
        ht1.put("-=", "subEq-op");
        ht1.put("/=", "divEq-op");
        ht1.put("%=", "modEq-op");
        ht1.put("++", "inc-op");
        ht1.put("--", "sec-op");
        // punctuation symbols
        // ht1.put("@", "concat"); // changed from +
        ht1.put("{", "open-curly-bracket");
        ht1.put("}", "close-curly-bracket");
        ht1.put("[", "open-square-bracket");
        ht1.put("]", "close-square-bracket");
        ht1.put("(", "open-round-bracket");
        ht1.put(")", "close-round-bracket");
        ht1.put("'", "quote");
        ht1.put(";", "semicolon");
        ht1.put(",", "comma");
        ht1.put(".", "dot");
    }
}
