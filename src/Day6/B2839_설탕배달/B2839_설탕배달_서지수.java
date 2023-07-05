package Day6.B2839_설탕배달;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2839_설탕배달_서지수 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int num = N;
		
		while(num>=0) {
			if(num%5==0) {
				cnt+=num/5;
				break;
			}
			else {
				num-=3;
				cnt++;
			}
		}
		
		if(num<0) {
			cnt=-1;
		}

		System.out.println(cnt);

	}
}

