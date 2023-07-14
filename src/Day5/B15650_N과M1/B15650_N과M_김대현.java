package Day5.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650_N과M_김대현 {

	static int[] arr;
	static int select[] ;
	static int N;
	static int M;
	static boolean isSelect[];
	
	
	public static void combination(int index, int r) {
		if(r==M)
		{
			for(int i = 0; i<M; i++)
			System.out.print(arr[select[i]] +" ");
		
			System.out.println(" ");
			return;
		}
		
		
		for(int i = index; i<N; i++) {
			
			if(isSelect[i]) continue;
			select[r] = i;
			isSelect[i] = true;
			combination(i,r+1);
			isSelect[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		arr = new int[N];
		for(int i = 0 ;i<N; i++) {
			arr[i] = i+1;
		}
		isSelect = new boolean[N];
		select = new int[M];
		
		combination(0,0);
		
		

	}

}
