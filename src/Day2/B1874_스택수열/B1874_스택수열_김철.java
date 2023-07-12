package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B1874_스택수열_김철 {
	static int n;
	static int[] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        
        for(int i=1; i<=n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        sb = new StringBuilder();
        
        if(action()) bw.write(sb+"");
        else bw.write("NO");
        
        bw.close();
	}
	
	static boolean action() {
		Stack<Integer> stack = new Stack<>();
		int pushNum = 1;	// push할 숫자
		for(int i=1; i<=n; i++) {
			int now = arr[i];	// 현재 비교할 수열
			
			if(pushNum <= now) {
				while(pushNum <= now) {
					stack.push(pushNum);
					sb.append("+\n");
					pushNum++;
				}
				stack.pop();
				sb.append("-\n");
			}
			else if(pushNum > now) {
				int popNum = stack.pop();
				if(popNum > now) {
					return false;
				}
				sb.append("-\n");
			}
		}
		return true;
	}

}
