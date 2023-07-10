package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합_강윤서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int count = 1; // 가지수
		int sum = 1; // 현재 합
		int start = 1; // 시작
		int end = 1; // 끝
		
		while(end != n) {
			if(sum == n) {
				count++;
				// 끝 포인터 이동(이동 후 값 증가)
				end++;
				sum += end;
			} else if (sum > n) {
				// 시작 포인터 이동(값 감소 후 이동)
				sum -= start;
				start++;
			} else {
				// 끝 포인터 이동(이동 후 값 증가)
				end++;
				sum += end;
			}
		}
		System.out.println(count);
	}
}
