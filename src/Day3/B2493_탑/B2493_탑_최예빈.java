package Day3.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑_최예빈 {

    static int N;
    static int[] tower;
    static Stack<Integer> stack = new Stack<>(); // index of tower

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        tower = new int[N];
        for (int i = 0; i < N; i++) tower[i] = Integer.parseInt(st.nextToken());


        StringBuilder sb = new StringBuilder("0");
        stack.push(0);

        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && tower[stack.peek()] < tower[i]) stack.pop();
            if (stack.isEmpty()) sb.append(" ").append(0);
            else sb.append(" ").append(stack.peek() + 1);
            stack.push(i);
        }


        System.out.println(sb);
    }
}
