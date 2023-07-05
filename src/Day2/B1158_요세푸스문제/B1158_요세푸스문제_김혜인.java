package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_김혜인{

	public static void main(String[] args) throws  IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());	

		
		Queue <Integer> que_list = new ArrayDeque<>();  //큐 만들기
		
		for( int i =0 ; i<n; i++) {//  다 넣어줌
			que_list.add(i+1);
		}
		
		System.out.print("<");
	
		
		while(!que_list.isEmpty()) { //큐가반복될때까지 
			for(int j=0; j<m-1; j++){
				que_list.add(que_list.poll()); 
			}
				System.out.print(que_list.poll());
			
				
		if(que_list.size()>0) {
			System.out.print(", ");

			}
	        
	    }System.out.print( ">");
	}
}
