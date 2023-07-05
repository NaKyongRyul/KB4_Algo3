package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B9742_순열_곽승규 {
	static String [] arr; 
	static String [] selection;
	static boolean isVisited[]; //마킹배열
	static int N; // 찾아야 할 순서
	static int count = 0;
	
	static void permutation(int r) {
		if (r == arr.length) {
			count++;
			if (count == N) {
				for(int i = 0; i < arr.length; i++) {
					arr[i] = selection[i];
				}
				//System.out.println(Arrays.toString(arr));
			}
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(isVisited[i]) continue;
			isVisited[i] = true;
			selection[r] = arr[i];
			permutation(r+1);
			isVisited[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while((line=bf.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			String tmp = st.nextToken();
			arr = tmp.split("");
			selection = new String[arr.length];
			isVisited = new boolean [arr.length];
			N = Integer.parseInt(st.nextToken());
			count = 0;

			permutation(0);
			
			//System.out.println("count: " + count);
			System.out.print(tmp + " " + N + " = ");
			if (count >= N) {
				for(int i = 0; i < arr.length; i++) {
					System.out.print(arr[i]);
				}
				System.out.println();
			}
			else {
				System.out.println("No permutation");
			}
			
			
		}

	}

}
