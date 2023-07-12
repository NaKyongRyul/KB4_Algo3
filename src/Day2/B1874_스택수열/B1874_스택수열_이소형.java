package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_스택수열_이소형 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int cur, num = 1;
        for (int i = 0; i < n; i++) {
            cur = Integer.parseInt(reader.readLine());
            if (!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
                builder.append("-\n");
                continue;
            }
            while (num != cur && num <= n) {
                stack.push(num++);
                builder.append("+\n");
            }
            builder.append("+\n");
            builder.append("-\n");
            num++;
        }

        if (stack.isEmpty()) {
            System.out.println(builder);
        } else {
            System.out.println("NO");
        }
    }
}
