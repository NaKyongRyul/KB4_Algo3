package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_이소형 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(reader.readLine()));
        }

        int max = stack.pop(), cur;
        int cnt = 1;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur > max) {
                max = cur;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
