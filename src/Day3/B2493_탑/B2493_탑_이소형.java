package Day3.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2493_탑_이소형 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] strings = reader.readLine().split(" ");

        StringBuilder builder = new StringBuilder();
        Stack<Integer[]> stack = new Stack<>();
        int cur;
        for (int i = 0; i < n; i++) {
            cur = Integer.parseInt(strings[i]);
            while (!stack.isEmpty() && stack.peek()[1] < cur) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                builder.append("0 ");
            } else {
                builder.append(stack.peek()[0]);
                builder.append(" ");
            }
            Integer[] temp = new Integer[2];
            temp[0] = i + 1;
            temp[1] = cur;
            stack.push(temp);
        }

        System.out.println(builder);
    }
}

/*
6 9 5 7 4
1 2 3 4 5

9 7 4
2 4

0 0 2 2
 */