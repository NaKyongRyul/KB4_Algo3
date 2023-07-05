package Day6.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
		
		// 정렬1 : Comparator 이용
		Arrays.sort(arr , new Comparator<int []>() {
			@Override
			public int compare(int [] a , int [] b) {
				return a[1]!=b[1] ? a[1]-b[1] : a[0] - b[0];
			}});
		
		// 정렬 2 : Lambda 이용
		Arrays.sort(arr , (a,b)->(a[1]!=b[1] ? a[1]-b[1]:a[0]-b[0]));
		
		int nowTime = 0;
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(nowTime <= arr[i][0]) {
				nowTime = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
