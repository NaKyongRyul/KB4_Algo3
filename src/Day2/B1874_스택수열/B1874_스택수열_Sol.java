package Day2.B1874_스택수열;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class B1874_스택수열_Sol {
public static void main(String[] args) throws FileNotFoundException {
		
		/// 입력 처리 ///
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] arr = new int [N];
        for(int i=0; i<N; i++) arr[i] = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        
        int idx = 1;							/// 몇번까지 push 했는지 기억 
        StringBuffer bf = new StringBuffer();	/// StringBuilder 유사

        // arr 배열 탐색 //
        for(int i=0; i<N; i++) {
           
        	// 현재 탐색 값
        	int now = arr[i];
           
           // 스택이 초기화상태 or now > peek 인 경우 //
           // stack 에 해당값이 들어올때까지 push 해줌
           if(stack.isEmpty() || now > stack.peek()){
        	   // idx 부터 now 까지 push
        	   for(int j=idx; j<=now; j++) {
        		   stack.push(j);
        		   bf.append("+\n");
        		   idx++;
        	   }
        	   stack.pop();
        	   bf.append("-\n");
           }
            
           // now == peek 인 경우 = push //
            else if(now == stack.peek()){
            	stack.pop();
            	bf.append("-\n");
            }
           
           // now < peek 인 경우 = FAIL //
            else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(bf.toString());	// 정답 출력 
       }
}
