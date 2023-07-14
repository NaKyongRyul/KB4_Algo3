package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B2961_도영이가만든맛있는음식_나웅기 {
	static int N;
	static ArrayList<ArrayList<Integer>> arr;
	static int minResult;
	
	public static void permutation(int x, int cnt, int s, int b) {
		int compare = Math.abs(s-b);
		if (cnt != 0 && compare < minResult) {
			minResult = compare;
		}
		
		if (x == N) return;
			
		permutation(x+1, cnt+1, s*arr.get(x).get(0), b+arr.get(x).get(1));
		permutation(x+1, cnt, s, b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(reader.readLine());
		arr = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i<N; i++) {
			String [] str = reader.readLine().split(" ");
			arr.add(new ArrayList<Integer>());
			arr.get(i).add(Integer.parseInt(str[0]));
			arr.get(i).add(Integer.parseInt(str[1]));
		}
				
		minResult = 1000000001;
		permutation(0, 0, 1, 0);
		System.out.println(minResult);
		
	}
}
