package Day2.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑_신선영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> idx = new Stack<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                stack.push(n);
                idx.push(i);
                System.out.print(0 + " ");
            }

            else {
                while (!stack.isEmpty()) {
                    // 스택의 가장 위 값과 계속 비교
                    if (stack.peek() < n) {
                        stack.pop();
                        idx.pop();
                    } else {
                        System.out.print(idx.peek() + 1 + " ");
                        break;
                    }
                }
                if (stack.isEmpty()) {
                    if (idx.isEmpty()) {
                        System.out.print(0+ " ");
                    } else {
                        System.out.print(idx.peek() + " ");
                    }

                }

                stack.push(n);
                idx.push(i);
            }
        }
    }

}