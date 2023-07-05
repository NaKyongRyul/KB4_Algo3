package Day1.B11659_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11659_구간합구하기_길민지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] arr = new int [N];
		StringTokenizer st2 = new StringTokenizer(bf.readLine());
		for (int i = 0; i<N; i++) {
			// 배열 그대로
//			arr[i] = Integer.parseInt(st2.nextToken());
			
			// 구간합
			if (i==0) arr[i] = Integer.parseInt(st2.nextToken());
			else arr[i] = arr[i-1] + Integer.parseInt(st2.nextToken());
		}
		
		for (int k = 0; k<M; k++) {
			StringTokenizer st3 = new StringTokenizer(bf.readLine());
			int i = Integer.parseInt(st3.nextToken());
			int j = Integer.parseInt(st3.nextToken());
			
			
			// 1번 - 구간합
			System.out.println((i>=2)?arr[j-1]-arr[i-2]:arr[j-1]);
			
			// 2번 - for문 sum (시간초과)
			// int [] splitArr = Arrays.copyOfRange(arr, i-1, j);
			
			/* int sum = 0;
			for(int q = 0, len = splitArr.length; q<len; q++) {
				sum+=splitArr[q];
			} 
			System.out.println(sum);
			*/
			
			// 3번 - stream 사용 (시간초과)
			// System.out.println(Arrays.stream(splitArr).sum());
		}
	}
}
