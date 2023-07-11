package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ17608_막대기_조승빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int longestStick = stack.pop();
        int viewCnt = 1;

        while(!stack.empty()) {
            int stick = stack.pop();
            if (stick > longestStick) {
                viewCnt++;
                longestStick = stick;
            }
        }

        System.out.println(viewCnt);
    }
}
