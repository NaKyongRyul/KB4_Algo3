package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_스택수열_임재현 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int t = 1; // 1부터 t까지 스택에 삽입된 상태
        Stack<Integer> st = new Stack<Integer>();
        StringBuilder res = new StringBuilder();
        res.append("+");
        st.push(1);

        for (int _i = 0; _i < N; _i++) {
            int target = Integer.parseInt(bf.readLine());
            if (st.size() == 0) {
                st.push(++t);
                res = res.append("+");
            }
            if (target > st.peek()) {
                while (target > st.peek()) {
                    st.push(++t);
                    res = res.append("+");
                }
            }
            if (target == st.peek()) {
                res = res.append("-");
                st.pop();
                continue;
            }
            if (target < t) {
                System.out.println("NO");
                return;
            }
        }

        int resLen = res.length();
        for (int i = 0; i < resLen; i++) {
            System.out.println(res.charAt(i));
        }
    }
}
