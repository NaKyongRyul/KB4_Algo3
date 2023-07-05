package Day6.B2110_공유기설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110_공유기설치_김태선 {
	
	public static int [] house;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		house = new int [N];
		
		for(int i =0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		
		Arrays.sort(house);
		
		int low = 1;
		int high = house[N - 1] - house[0] + 1;
		
		while(low < high) {
			
			int mid = (high + low) / 2;
			
			if(install(mid) < C) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		
		System.out.println(low - 1);
	}

	
	public static int install(int distance) {
		
		int cnt = 1;
		int beforeLocation = house[0];
		
		for(int i = 1; i < house.length; i++) {
			int location = house[i];
			
			if(location - beforeLocation >= distance) {
				cnt++;
				beforeLocation = location;
			}
		}
		
		return cnt;
	}
}
