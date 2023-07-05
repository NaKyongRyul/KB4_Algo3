package Day2.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2493_탑_김원우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int []> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.valueOf(st.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek()[0] > input) {
                    System.out.print(stack.peek()[1] + " ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.print(0 + " ");
            }
            stack.push(new int[] {input, i+1});

        }

    }
}
