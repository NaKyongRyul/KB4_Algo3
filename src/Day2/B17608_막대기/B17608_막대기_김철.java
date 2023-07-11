package Day2.B17608_막대기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B17608_막대기_김철 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++){
            int stick = Integer.parseInt(br.readLine());
            stack.push(stick);
        }

        int right = stack.pop();
        int answer = 1;    // 맨 오른쪽 한 개는 무조건 보인다
        int temp;   // 보이는 기준 높이를 갱신
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(right < temp) {
                answer++;
                right = temp;
            }
        }

        bw.write(answer+"");
        bw.close();
    }
}
