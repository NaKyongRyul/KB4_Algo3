package Day6.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전0_서지수 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int arr[]=new int [N];
		int coin[]=new int [N]; //동전개수
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			if(K==0) break;
			
			for(int i=N-1;i>=0;i--) {
				if(K-arr[i]>=0) {
					coin[i]++;
					K=K-arr[i];
					break;
				}
			}
		}
		for(int i=0;i<N;i++) {
			cnt+=coin[i];
		}
		System.out.println(cnt);
	}
}
