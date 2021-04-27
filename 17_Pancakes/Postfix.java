import java.util.Stack;

class Postfix {
  public static int eval(String expression) {
    Stack<Integer> stack = new Stack<>();
    for(var token : expression.split(" ")) {
      switch(token) {
        case "*":
          Integer rhs = stack.pop();
          Integer lhs = stack.pop();
          stack.push(lhs * rhs);
          break;
        case "/":
          rhs = stack.pop();
          lhs = stack.pop();
          stack.push(lhs / rhs);
          break;
        case "+":
          rhs = stack.pop();
          lhs = stack.pop();
          stack.push(lhs + rhs);
          break;
        case "-":
          rhs = stack.pop();
          lhs = stack.pop();
          stack.push(lhs - rhs);
          break;
        default:
          stack.push(Integer.parseInt(token));
      }
    }
    return stack.pop();
  }
} 