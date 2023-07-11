import java.util.Scanner;
import java.util.Stack;

public class B17608_막대기_송봉섭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            stack.push(sc.nextInt());
        }
        int count = 0;
        int top = 0;

        while (!stack.isEmpty()) {
            if (top < stack.peek()) {
                count++;
                top = stack.peek();
            }
            stack.pop();
        }

        System.out.println(count);

    }
}
