package Day5.B15650_N과M1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650_N과M1_정지원 {
	
	static int[] arr;
	static int N;
	static int R;
	
	static int[] select;
	static boolean[] isSelected;
	
	public static void combination(int idx, int size) {
		if(size==R) {
			for(int i=0;i<R;i++)System.out.print(select[i] + " ");
			System.out.println();
			return;
		}
		for(int i=idx;i<N;i++) {
			if(isSelected[i])continue;
			isSelected[i] = true;
			select[size] = arr[i];
			combination(i, size+1);
			
			isSelected[i] = false;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		R = Integer.parseInt(str.split(" ")[1]);
		
		arr = new int[N];
		for(int i=1;i<=N;i++) {
			arr[i-1] = i;
		}
		
		select = new int[R];
		isSelected = new boolean[N];
		
		combination(0, 0);
	}
}
