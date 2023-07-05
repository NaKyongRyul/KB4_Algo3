package Day1.B10806_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 정수의 개수 N(1 ≤ N ≤ 100)이 주어진다. 둘째 줄에는 정수가 공백으로 구분되어져있다. 셋째 줄에는 찾으려고 하는 정수 v가 주어진다. 입력으로 주어지는 정수와 v는 -100보다 크거나 같으며, 100보다 작거나 같다.
 * 
 * 첫째 줄에 입력으로 주어진 N개의 정수 중에 v가 몇 개인지 출력한다.
 * 
 * */

//아까 못풀어서 강사님 강의 들으면서 따라 쓴 코드입니다.
public class B10806_개수세기_이채림{

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 입력 처리 //
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int[] arr = new int [N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());//문자열인 token을 정수로 변환
		}
		
		int v = Integer.parseInt(bf.readLine());
		
		int cnt = 0;
		
		for(int i : arr) {
			if(v == i) cnt++;
		}
		
		System.out.println(cnt);
		
	}

}
