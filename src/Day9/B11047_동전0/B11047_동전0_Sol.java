package Day9.B11047_동전0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B11047_동전0_Sol {

	public static void main(String[] args) throws IOException {

		BufferedReader io = new BufferedReader((new InputStreamReader(System.in)));
		
		StringTokenizer token = new StringTokenizer(io.readLine() , " ");
		
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		
		int [] arr = new int [N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(io.readLine());
		
		
		int cnt = 0;
		int remain = K;
		
		for(int i= N-1; i>=0; i--) {
			
			cnt += remain/arr[i];
			remain = remain%arr[i];
			
//			while(remain >= arr[i]) {
//				remain -= arr[i];
//				cnt++;
//			}
			
		}
		System.out.println(cnt);
	}
}