package Day4.B9742_순열;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9742_순열_Sol {

	static char [] arr;
	static int N;
	static int k;
	static int cnt;
	static char [] select;
	static boolean [] isSelected;
	
	static void permutation(int r) {
		if(r==N) {
			if(++cnt == k) {
				System.out.print(String.valueOf(arr) + " " + k + " = ");
				for(int i=0; i<N; i++) System.out.print(select[i]);
				System.out.println();
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			select[r] = arr[i];
			permutation(r+1);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = bf.readLine();
			if(str == null) break;
			StringTokenizer token = new StringTokenizer(str, " ");
			arr = token.nextToken().toCharArray();
			k = Integer.parseInt(token.nextToken());
			N = arr.length;
			cnt = 0;
			select = new char [N];
			isSelected = new boolean [N];
		
			permutation(0);
			
			if(k>cnt) {
				System.out.print(String.valueOf(arr) + " " + k + " = ");
				System.out.println("No permutation");
			}
		}
	}
}
