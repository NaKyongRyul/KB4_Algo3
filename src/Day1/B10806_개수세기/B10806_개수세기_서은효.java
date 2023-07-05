package Day1.B10806_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10806_개수세기_서은효 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		
		int num =Integer.parseInt(bf.readLine()) ;
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int [] arr = new int[num];
		
		for(int i =0 ; i<num ;i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		int v =Integer.parseInt(bf.readLine()) ;
		
		
		int cnt = 0;
		
		for(int i =0; i<arr.length ; i++) {
			if(arr[i] == v) 
				cnt++;
			
		}
		System.out.println(cnt);
		
		
	}
}
