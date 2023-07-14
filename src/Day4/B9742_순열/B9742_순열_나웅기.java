package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9742_순열_나웅기 {
	static char [] arr;
	static int N;
	static int [] selected;
	static boolean [] visited;
	static int cnt;
	static int [] result;
	static boolean isP;
	// 11
	static void permutation(int r, String s) {

		if (r == N) {
			cnt++;
			if (cnt == Integer.parseInt(s)) {

				for (int i = 0; i<selected.length; i++) {
					result[i] = selected[i];
				}
				isP = true;
				
				
			}
		}
		
		for (int i = 0; i<N; i++) {
			if (visited[i] == true) continue;
			selected[r] = i;
			visited[i] = true;
			permutation(r+1, s);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while ((input = reader.readLine()) != null) {
			String [] str = input.split(" ");
			arr = str[0].toCharArray();
			visited = new boolean [arr.length];
			N = arr.length;
			selected = new int [arr.length];
			cnt = 0;
			isP = false;
			result = new int [arr.length];
			permutation(0, str[1]);
			System.out.print(input + " = ");
			if (isP) {				
				for (int i = 0; i<selected.length; i++) {
					System.out.print(arr[selected[i]]);
				}
				System.out.println();
			} else {
				System.out.println("No permutation");
			}
			
		}
	}
}
