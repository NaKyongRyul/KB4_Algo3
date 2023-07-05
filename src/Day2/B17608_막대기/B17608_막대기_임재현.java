package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_임재현 {
    public static void main(String[] args) throws IOException {
        int ans = 1, N = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<Integer>();

        N = Integer.parseInt(bf.readLine());
        for (int _i = 0; _i < N; _i++) {
            st.push(Integer.parseInt(bf.readLine()));
        }
        int highest = st.pop();
        while (!st.empty()) {
            int h = st.pop();
            if (h > highest) {
                ans++;
                highest = h;
            }
        }
        System.out.println(ans);
    }
}
