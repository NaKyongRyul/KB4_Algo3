package Day9.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_회의실배정_Sol {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		int [][] arr = new int [N][2];

		StringTokenizer token;
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(bf.readLine() , " ");
			arr[i][0] = Integer.parseInt(token.nextToken()); 
			arr[i][1] = Integer.parseInt(token.nextToken()); 
		}
		
		System.out.println(Arrays.deepToString(arr));
		
		// 람다식 => Comparator 표현
		Arrays.sort(arr ,  (a,b) -> ( a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]));
		System.out.println(Arrays.deepToString(arr));
		
		int nowTime = 0;
		int cnt = 0;
		
		// 정렬된 회의 N 개 for 문
		for(int i=0 ;i<N; i++) {
			
			// 회의 선택 = 현재시간이 시작시간보다 일러야
			if(nowTime <= arr[i][0] ) {
				nowTime = arr[i][1]; // 끝나는 시간으로 nowTime 을 이동
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}
