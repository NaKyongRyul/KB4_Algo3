package Day3.B17298_오큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298_오큰수_최예빈 {

    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());


        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();

        answer[N - 1] = -1;
        stack.push(A[N - 1]);

        if (N < 2) {
            System.out.println(-1);
            return;
        }

        for (int i = N - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= A[i]) stack.pop();
            if (stack.isEmpty()) answer[i] = -1;
            else answer[i] = stack.peek();
            stack.push(A[i]);
        }


        StringBuilder sb = new StringBuilder();
        for (int n: answer) sb.append(n).append(" ");
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }
}
