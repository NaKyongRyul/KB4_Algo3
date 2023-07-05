package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1874_스택수열_박창현 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int[] raw = new int[N];
        Stack<Integer> calc = new Stack<>();

        for (int i = 0; i < N; i++) {
            raw[i] = (Integer.parseInt(br.readLine()));
        }
        int[] copy;
        copy = Arrays.copyOf(raw, N);
        Arrays.sort(copy);

        Queue<Integer> sorted = new ArrayDeque<>();
        for (int i : copy) {
            sorted.add(i);
        }
        int i = 0;

        try {
            while (!sorted.isEmpty() || !calc.isEmpty()) {
                if (!calc.isEmpty() && raw[i] == calc.peek()) {
                    calc.pop();
                    sb.append("-");
                    i++;
                } else {
                    calc.push(sorted.poll());
                    sb.append("+");

                }
            }
            for (char c : sb.toString().toCharArray()) {
                System.out.println(c);
            }
        } catch (NullPointerException e) {
            System.out.println("NO");
        }
    }
}
