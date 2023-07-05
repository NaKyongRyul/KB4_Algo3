package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_조성환 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String str = bf.readLine();
				
		st = new StringTokenizer(bf.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		int [] arr = new int [4] ; 
		
		for (int i = 0; i < P ; i++) {
			switch(str.charAt(i)){
			case 'A': arr[0]++;
				break;
			case 'C': arr[1]++;
				break;
			case 'G': arr[2]++;
				break;
			default: arr[3]++;
				break;
			}
		}
		
		if(arr[0] >= A && arr[1] >= C && arr[2] >= G && arr[3] >= T) {
			ans++;
		}
		
		int start = 0;
		while(start + P < S) {
			
			switch(str.charAt(start)){
			case 'A': arr[0]--;
				break;
			case 'C': arr[1]--;
				break;
			case 'G': arr[2]--;
				break;
			default: arr[3]--;
				break;
			}
			
			switch(str.charAt(start+P)){
			case 'A': arr[0]++;
				break;
			case 'C': arr[1]++;
				break;
			case 'G': arr[2]++;
				break;
			default: arr[3]++;
				break;
			}
			start++;
			if(arr[0] >= A && arr[1] >= C && arr[2] >= G && arr[3] >= T) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}
