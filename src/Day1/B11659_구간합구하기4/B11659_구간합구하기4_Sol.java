package Day1.B11659_구간합구하기4;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11659_구간합구하기4_Sol {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// N , M 
		String [] strs = bf.readLine().split(" ");
		int N = Integer.parseInt(strs[0]); 
		int M = Integer.parseInt(strs[1]);
		
		// 누적합 배열 선언
		int [] S = new int [N + 1];
		S[0] =  0;
		
		// 누적합 배열 구하기
		// S[i] = S[i-1] + arr[i]
		strs = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {	
			S[i + 1] = Integer.parseInt(strs[i]) + S[i];
		}
		
		StringBuilder builder = new StringBuilder();
		
		// 합해야 하는 구간 입력 받아서 합 출력
		for (int i = 0; i < M; i++) {
			strs = bf.readLine().split(" ");
			int start = Integer.parseInt(strs[0]);
			int end = Integer.parseInt(strs[1]);
			builder.append( String.valueOf(S[end] - S[start - 1]) + '\n');
		}
		
		System.out.println(builder.toString());
	}
}

