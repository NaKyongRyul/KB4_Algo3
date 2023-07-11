package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_염혜정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<N; i++){
            stack.push(Integer.parseInt(br.readLine()));
        }

        int cnt = 1;
        int check = stack.pop();
        while(! stack.empty()){
            if(stack.peek()>check){
                cnt++;
                check = stack.peek();
            }
            stack.pop();
        }

        System.out.println(cnt);
    }
}
