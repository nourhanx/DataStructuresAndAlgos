public class Main {
    public static void main(String[] args) {
//        System.out.println(StringReverser.reverse("abc"));
//        System.out.println(Expression.isBalanced("(bb())"));
        Expression exp = new Expression();
        System.out.println(exp.isBalanced("()"));                 // true
        System.out.println(exp.isBalanced("([])"));               // true
        System.out.println(exp.isBalanced("{[()]}"));             // true
        System.out.println(exp.isBalanced("<{[()()]}>"));         // true
        System.out.println(exp.isBalanced("(({{[[]]}}))"));       // true
        System.out.println(exp.isBalanced("a + (b * c) - {d / e}")); // true (ignores letters)
        System.out.println("---------------------------------------");
        System.out.println(exp.isBalanced("("));            // false
        System.out.println(exp.isBalanced("([)]"));          // false (wrong order)
        System.out.println(exp.isBalanced("{[(])}"));        // false
        System.out.println(exp.isBalanced("(<{[)}>]"));      // false (mismatched)
        System.out.println(exp.isBalanced("(()"));           // false
        System.out.println(exp.isBalanced("())"));           // false
        System.out.println("---------------------------------------");
        System.out.println(exp.isBalanced(""));               // true (empty string is balanced)
        System.out.println(exp.isBalanced("abc"));            // true (no brackets at all)
        System.out.println(exp.isBalanced("><"));             // false (wrong order)
        System.out.println(exp.isBalanced("<<>>"));           // true (nested angle brackets)
        System.out.println(exp.isBalanced("({[<>]})"));       // true (all types properly nested)


    }


}