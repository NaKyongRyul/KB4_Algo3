package Day1.B11659_구간합구하기;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11659_구간합구하기_Sol {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(reader.readLine() , " ");
		int N = Integer.parseInt(str.nextToken()); 
		int M = Integer.parseInt(str.nextToken());
		
		int [] arr = new int [N + 1];
		str = new StringTokenizer(reader.readLine() , " ");
		arr[0] =  0;
		
		for (int i = 0; i < N; i++) {	
			arr[i + 1] = Integer.parseInt(str.nextToken()) + arr[i];
		}
		
		for (int i = 0; i < M; i++) {
			str = new StringTokenizer(reader.readLine() , " ");
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			System.out.println(arr[end] - arr[start - 1]);
		}
	}
}

