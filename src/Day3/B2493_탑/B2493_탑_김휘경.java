package Day3.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;




public class B2493_탑_김휘경 {  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] buildings = new int[n];


        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            buildings[i] = Integer.parseInt(input[i]);
        }


        for (int i = 0; i < n; i++) {
            int now = buildings[i];

            while (!stack.isEmpty() && buildings[stack.peek()] < now) { // 앞으로 넣을 것이 더 큰 경우
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answer[i] = stack.peek() + 1; // 건물 번호
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}

