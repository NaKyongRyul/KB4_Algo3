package Day9.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_회의실배정_나웅기 {
	static int n;
	static int [][] meeting;
	static int result;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		
		meeting = new int [n][2];
		
		for (int i = 0; i<n; i++) {
			st = new StringTokenizer(reader.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting, (a,b) -> ((a[1] != b[1]) ? a[1] - b[1] : a[0] - b[0]) );
//		System.out.println(Arrays.deepToString(meeting));
		int now = meeting[0][1];
		result = 1;
		for (int i = 1; i<n; i++) {
			if (now <= meeting[i][0]) {
				now = meeting[i][1];
				result++;				
			}
		}
		System.out.println(result);
		
		
	}
}
