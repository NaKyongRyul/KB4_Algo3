package Day1.B10806_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10806_개수세기_곽승규 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		// 입력 처리 //
				BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //엔터로 구분해서 받는 것
				
				int N = Integer.parseInt(bf.readLine());
						
				StringTokenizer token = new StringTokenizer(bf.readLine()," "); //default 공백임, 입력을 띄어쓰기로 구분할 때
				
				int [] arr = new int [N];
				
				for (int i = 0; i<N; i++) {
					arr[i] = Integer.parseInt(token.nextToken());
				}
				//////////////////////////////////////////////
				
				int find = Integer.parseInt(bf.readLine());
				int ans = 0;
				
				for(int i = 0; i < N; i++) {
					if ( find == arr[i] ) ans++; 
				}
				
				System.out.println(ans);

	}

}
