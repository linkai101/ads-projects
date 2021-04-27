import java.util.*;

class Palindromes {
  public static boolean isPalindrome(String text) {
    Stack<String> stack = new Stack<String>();
    Queue<String> queue = new LinkedList<>();
    
    for (var letter : text.split("(?!^)")) {
      stack.push(letter);
      queue.add(letter);
    }

    while (!stack.empty()) {
      String stackLetter = stack.pop();
      String queueLetter = queue.remove();
      if (!stackLetter.equals(queueLetter)) return false;
    }

    return true;
  }
} 