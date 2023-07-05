package Day6.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_회의실배정_윤소민 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int N = Integer.parseInt(bf.readLine());
		int [][]time = new int [N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
			
		}

		
		Arrays.sort(time, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		Arrays.sort(time, (o1, o2) -> o1[0] == o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
		
        int now = 0;
		int cnt=0;

		for(int j=0;j<N;j++) {
			if(now<=time[j][0]) {
				now = time[j][1];
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
