package Day1.B2018_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018_수들의합_김혜인 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		
		int N  = Integer.parseInt(bf.readLine());
		int sum = 1;
		int i = 1;  //시작
		int j= 1;    //끝값
		int count = 1;
		
		while(j<N) {
			if(sum<N) {
				j++;
				sum += j;
			}else if(sum>N) {
				sum -= i;
				i++;
			}else {
				count ++ ;
				j++;
				sum += j;
			}
		}
		
		System.out.println(count);
	}
		
	}
