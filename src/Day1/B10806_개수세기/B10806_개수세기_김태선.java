package Day1.B10806_개수세기;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10806_개수세기_김태선 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		
		int [] arr = new int [N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		int v = Integer.parseInt(br.readLine());
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			if(v == arr[i]) ans++;
		}
		
		System.out.println(ans);
	}

}
