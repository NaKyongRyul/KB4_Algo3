package Day1.B10806_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10806_개수세기_김혜인 {

		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(bf.readLine()); //형이 달라서 casting 필요
			
			StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
			
			
			int [] arr = new int [N];
			
				for(int i=0; i<N; i++) {
					arr[i] = Integer.parseInt(token.nextToken());  //문자열 > 형
			
				}
				
			int v = Integer.parseInt(bf.readLine());
			
			
			int ans = 0;
			for(int i= 0; i<N; i++) {
				
				if(v == arr[i]) 
					ans++;
			}
			
			System.out.println(ans);
			
			
			
	}

}






