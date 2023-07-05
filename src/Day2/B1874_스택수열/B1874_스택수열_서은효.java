package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class B1874_스택수열_서은효 {
	static int num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Stack<Integer> stack = new Stack<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int [] basicList = new int[n];
		
		//basicList에 넣기 
		for(int i =1; i<=n ;i++) basicList[i-1] = i;
		
		num = 0;
		
		for(int i =0; i<n ; i++) {
			
				int x = Integer.parseInt(bf.readLine());
				if((i == 0)&&(x == basicList[0])) {
					System.out.println("NO");
					break;
				}
				
				for(int j = num; j<n ; j++) {
					
					if(x == basicList[j]) {
						System.out.println("-");
						stack.pop();
						break;
					}else {
						num = j;
						System.out.println("+");
						stack.push(basicList[j]);
						
						

				}

			
		}
}
		


		
		
	}

}
