package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합_김태선 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int start = 0, end = 0; //투포인터 설정
		int sum = 0, cnt = 0; //sum : 합, cnt : 갯수(정답)
		
		while(start <= N) {
			while(++end <= N) { //end 증가
				sum += end; //부분합을 증가
				if(sum >= N) {
					if(sum == N) cnt++;
					break;
				}
			}
			while(++start <= N) { //start 증가
				sum -= start; //부분합을 감소
				if(sum <= N) {
					if(sum == N) cnt++;
					break;
				}
			}
		}System.out.println(cnt);
	}

}
