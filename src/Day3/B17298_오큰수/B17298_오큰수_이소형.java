package Day3.B17298_오큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17298_오큰수_이소형 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] strings = reader.readLine().split(" ");
        int[] nums = new int[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strings[i]);
            result[i] = -1;
        }

        int cur, idx;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            cur = nums[i];
            while (cur > nums[stack.peek()]) {
                idx = stack.pop();
                result[idx] = cur;
                if (stack.isEmpty()) break;
            }
            stack.push(i);
        }

        StringBuilder builder = new StringBuilder();
        for (int e :
                result) {
            builder.append(e);
            builder.append(" ");
        }
        System.out.println(builder);
    }
}
