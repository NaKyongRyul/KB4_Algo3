package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9742_순열_유유정 {
	static int N;
	static int R;
	static int [] selected ;
	static String [] arr;
	static boolean [] isSelected ;
	static String answer;
	static int count;
	public static void permutation(int r,int n) {
		if(r == R) {
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<R;i++) {
				sb.append(arr[selected[i]]);
			}
			count++;
			if(count == n) {
				answer = sb.toString();
				
			}
				
			return;
		}
		for(int i=0;i<N;i++) {
			if(isSelected[i]==true)
				continue;
			
			else {
				selected[r]=i;
				isSelected[i]= true;
				permutation(r+1,n);
				isSelected[i] = false;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		while(s!=null) {
			
			
			String [] strs = s.split(" ");
			arr= new String [N];
			arr = strs[0].split("");

			int n = Integer.parseInt(strs[1]);
			N = arr.length;
			R = N;
			isSelected = new boolean [N];
			selected= new int [N];
			permutation(0,n);
			if(count < n) 
				answer = "No permutation";

			System.out.print(s+" = "+answer);
			System.out.println();
			count =0;
			s = bf.readLine();
		}

	}

}
