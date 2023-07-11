package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_막대기_이도원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            s.push(Integer.parseInt(br.readLine()));
        }

        int max = 0;
        int answer = 0;
        while(!s.empty()){
            int num = s.pop();
            if (num > max){
                max = num;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
