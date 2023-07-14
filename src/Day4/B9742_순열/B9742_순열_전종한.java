package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9742_순열_전종한 {
	static char [] arr;
	static int [] select;
	static int R;
	static int seq;
	static boolean [] isSelected;
	static StringBuilder sb;

	public static void find_permutation(int r) {
		if(r == arr.length) {
			seq ++;
			if(seq == R) {
				for(int i=0; i<select.length; i++) sb.append(" = " + arr[select[i]]);
			}
			return ;
		}

		for(int i=0; i<arr.length; i++) {
			if(isSelected[i]) continue;

			select[r] = i;
			isSelected[i] = true;
			find_permutation(r+1);
			isSelected[i] = false;

		}
	}
    
    public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str = br.readLine()) != null) {
			String [] strs = str.split(" ");
			sb = new StringBuilder();
			arr = strs[0].toCharArray();
			select = new int [arr.length];
			R = Integer.parseInt(strs[1]);
			seq = 0;
			isSelected = new boolean[arr.length];

			for(int i=0;i<arr.length;i++) sb.append(arr[i]);
			sb.append(" " + R);
			find_permutation(0);
			if(seq < R) {
				sb.append(" = No permutation");
				System.out.println(sb);
			}else {
				System.out.println(sb);
			}
		}
	}
}
