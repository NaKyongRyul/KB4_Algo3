package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_신동렬 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a= Integer.parseInt(bf.readLine());
        for (int i =0; i<a; i++){
            stack.push(Integer.parseInt(bf.readLine()));

        }
        int result = 1;
        int right = stack.peek();
        while (true) {
            if(stack.isEmpty()) break;
            int tall = stack.pop();
            if (tall > right) {
                right = tall;
                result++;
            }
        } System.out.println(result);
    }
}
