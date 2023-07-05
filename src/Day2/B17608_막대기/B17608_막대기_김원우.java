package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_김원우 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(Integer.valueOf(br.readLine()));
        }

        int top = stack.pop();
        int cnt = 1;
        for (int i = 0; i < n-1; i++) {
            int tmp = stack.pop();
            if (top < tmp) {
                cnt++;
                top = tmp;
            }
        }
        System.out.println(cnt);

    }
}
