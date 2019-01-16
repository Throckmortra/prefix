import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get(args[0]))) {
            stream.forEach(c -> System.out.println(evaluate(c)));
        } catch(IOException e) {
            System.err.println("big oops: " + e.toString());
        }
    }

    public static int evaluate(String line){
        line = line.replaceAll("\\s", "");
        Stack<Integer> expressionStack = new Stack<>();
        for (int i = line.length() - 1; i >= 0; i--) {
            if (isOperand(line.charAt(i)))
                expressionStack.push(line.charAt(i) - 48);
            else {
                int o1 = expressionStack.peek();
                expressionStack.pop();
                int o2 = expressionStack.peek();
                expressionStack.pop();

                switch (line.charAt(i)) {
                    case '+':
                        expressionStack.push(o1 + o2);
                        break;
                    case '*':
                        expressionStack.push(o1 * o2);
                        break;
                    case '/':
                        expressionStack.push(o1 / o2);
                        break;
                }
            }
        }
        return expressionStack.peek();
    }

    public static Boolean isOperand(char c) {
        return c >= 48 && c <= 57;
    }
}
