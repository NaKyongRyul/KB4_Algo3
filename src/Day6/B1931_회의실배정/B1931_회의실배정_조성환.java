package Day6.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1931_회의실배정_조성환 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int [][] time = new int [N][2];
		int cnt = 0;
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(bf.readLine()," ");
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
		    @Override
			public int compare(int[] time1, int[] time2) {
		    	 if(time1[1] == time2[1]) {
	                	 return time1[0] - time2[0];
		    	 }else {
		    		 return time1[1] - time2[1]; 
		    	 }
	           }
	        });
		
		int now = 0;
		for (int i = 0 ; i < N ; i++) {
			if(time[i][0] >= now) {
				now = time[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
