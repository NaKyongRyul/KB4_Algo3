package Day8.B9663_NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9663_Nqueen_김혜인 {
	static int n;
	static int [] arr;
	static int count;

	
	//탐색. k부터 n까지 행만 가면 됨.
	public static void search(int k) { //k=queen의개수
		if(k==n) {
			count ++;
			return;
		}
		for(int i=0; i<n; i++) {
			arr[k] = i;
			 if(back(k)){  //재귀
				 search(k+1);
			 }
		}
	}
	
	public static boolean back(int k) {
		for(int i=0; i<k; i++) {  //첫번쨰 depth는0이들어와서 조건이 성립이 안됨 >> 그래서 1부터가 아니라 0으로 해서 1을받음
			if(arr[i] == arr[k]) { //퀸이 같은 인덱스에 있는게 안됨. 그거 확인해줌
				return false;
			}else if( Math.abs(arr[i] - arr[k]) == Math.abs(i-k)){ //대각선 공식
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());  //입력
		arr = new int[n];
		count = 0;
		search(0);
		System.out.println(count);
		
	} //main 절 끝

}
