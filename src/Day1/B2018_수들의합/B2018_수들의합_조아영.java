package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합_조아영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int answer = 0;
		
		int  start = 1;	 //시작 숫자
		int end = 1;		//마지막 숫자
		int sum = 1; 	// start+end

		while(start<=end) {
			if(sum == n) {
				answer++;
			}
			
			if(sum < n) {
				end ++;
				sum += end;				
			}else if(sum >= n) {
				sum -= start;
				start++;
			}			
		}
		
		System.out.println(answer);

	}

}
