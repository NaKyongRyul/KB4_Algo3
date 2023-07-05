package Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_길민지 {
	static char[] arr; // 알파벳 배열
	static int L, C; 
	static boolean isSelected[];
	
	static void findPW(int r, int start) {
		if (r==L) {
			StringBuilder sb = new StringBuilder();
			int v=0, c=0; //모음, 자음 개수
			for(int i=0; i<C; i++) {
				if (isSelected[i]==true) {
					if (arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u') v++;
					else c++;
					sb.append(arr[i]);
				}
			}
			if (v>=1 && c>=2) System.out.println(sb);
			return;
		}
		
		for(int i=start;i<C; i++) {
			if (isSelected[i]==true) continue;
			isSelected[i] = true;
			findPW(r+1, i);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		isSelected = new boolean[C];
		
		// 알파벳 입력
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		// 알파벳 정렬
		Arrays.sort(arr); 
		
		findPW(0, 0);
	}

}

