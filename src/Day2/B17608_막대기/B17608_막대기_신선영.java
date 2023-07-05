package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17608_막대기_신선영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int ans = 1;

        Stack <Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stack.push(Integer.parseInt(st.nextToken()));
        }

        int top = stack.pop();

        while (!stack.isEmpty()) {
            int n = stack.pop();
            if (n > top) {
                ans++;
                top = n;
            }
        }

        System.out.println(ans);

    }
}
