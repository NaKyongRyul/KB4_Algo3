package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_전상희 {
	
	static int[] num = new int[4]; // 문자열에 포함되어야 할 최소 개수
	static int[] count = new int[4]; // 현재 포함된 문자의 개수
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		int S = Integer.parseInt(token.nextToken());
		int P = Integer.parseInt(token.nextToken());
				
		String str = bf.readLine();
		char[] arr = str.toCharArray();
		
		token = new StringTokenizer(bf.readLine());
		
		for(int i=0; i<4; i++) {
			num[i] = Integer.parseInt(token.nextToken());
		}
		
		for(int i=0; i<P; i++) {
			inputNum(arr[i]);
		}
		
		check();
		
		for(int i=P; i<S; i++) {
			deleteNum(arr[i-P]);
			inputNum(arr[i]);
			check();
		}
		System.out.println(ans);
		
	}
	
	public static void inputNum(char c) {
		if(c == 'A') count[0]++;
		if(c == 'C') count[1]++;
		if(c == 'G') count[2]++;
		if(c == 'T') count[3]++;
	}
	
	public static void deleteNum(char c) {
		if(c == 'A') count[0]--;
		if(c == 'C') count[1]--;
		if(c == 'G') count[2]--;
		if(c == 'T') count[3]--;
	}
	
	public static void check() {
		int cnt = 0;
		
		for(int i=0; i<4; i++) {
			if(count[i] >= num[i])
				cnt++;
		}		
		if(cnt==4) ans++;
	}
}


