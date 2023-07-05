package Day6.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1931_회의실배정_곽승규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int [][]ary = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			ary[i][0] = Integer.parseInt(st.nextToken());
			ary[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 종료 시각 기준으로 오름차순 정렬
		Arrays.sort(ary, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if (o1[1] == o2[1]) 
				{
					return o1[0] - o2[0];
				}
				return o1[1]- o2[1];
			}
			
		});
		
		int count = 0;
		int end = -1;
		
		for (int a[] : ary) {
			if (a[0] >= end) {
				end = a[1];
				count++;
			}
		}
		System.out.println(count);
		
	}

}
