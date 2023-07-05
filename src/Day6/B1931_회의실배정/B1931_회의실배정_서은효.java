package Day6.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1931_회의실배정_서은효 {
	static int [][] arr;
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		
		int N = Integer.parseInt(bf.readLine());
		arr = new int[N][2];
		int ans = 0;
		
		for(int i =0; i<N;i++) {
			token = new StringTokenizer(bf.readLine()," ");
			arr[i][0] = Integer.parseInt(token.nextToken());
			arr[i][1] = Integer.parseInt(token.nextToken());
			}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] i, int[] j) {
				if(i[1] == j[1]) {
					return i[0] - j[0];
				}
				return i[1] - j[1];
			}
		});
		
		
		for(int i =0; i<N; i++) {
			for(int j =0; j<2; j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
		int tmp_time = arr[0][1];
		
		for(int i =1; i<N ; i++) {
			if(tmp_time <= arr[i][0]) {
				tmp_time = arr[i][1];
				ans++;
			
			}
		}
		System.out.println(ans+1);
		
	}	
		
		
		
	}


