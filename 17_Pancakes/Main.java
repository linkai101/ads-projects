import static java.lang.System.out;

class Main {
  public static void main(String[] args) {
    out.println(Palindromes.isPalindrome("racecar"));
    out.println(Palindromes.isPalindrome("asdf"));
    out.println(Palindromes.isPalindrome("123321"));
    out.println(Palindromes.isPalindrome("dammitimmad"));
    out.println();
    out.println(Postfix.eval("1 2 +"));
    out.println(Postfix.eval("15 8 -"));
    out.println(Postfix.eval("2 3 *"));
    out.println(Postfix.eval("4 5 * 3 +"));
    out.println(Postfix.eval("5 1 2 + 4 * + 3 -"));
  }
} 