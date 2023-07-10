package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659_구간합구하기4_유유정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String [] strs = str.split(" ");
		int N = Integer.parseInt(strs[0]);
		int [] sum = new int [N];
		int M = Integer.parseInt(strs[1]);
		str = br.readLine();
		strs = str.split(" ");
		sum[0] = Integer.parseInt(strs[0]);
		for(int i =1 ; i< N ; i++) {
			sum[i] = sum[i-1]+Integer.parseInt(strs[i]);
		}
		for(int k=0;k<M; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int answer = 0;
			if(i==1)
				answer= sum[j-1];
			else
				answer = sum[j-1]-sum [i-2];
			System.out.println(answer);
		}
			
	}

}
