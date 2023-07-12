package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_스택수열_조승빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int target = 0;

        while (N-- > 0) {

            int value = Integer.parseInt(br.readLine());

            if (value > target) {
                for (int i = target + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                target = value; // 4
            }

            if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }

}
