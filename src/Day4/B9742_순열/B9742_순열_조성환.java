package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9742_순열_조성환 {
	static int R;
	static char[] arr;
	static char[] selection;
	static boolean [] isSelected;
	static int total ; 
	static int num; 
	
	static void permutation(int r) {
		if (r == R) {
			total++; 
			if(total == num) {
				StringBuilder sb = new StringBuilder();
				for (char ch : selection) {					
					sb.append(ch);
				}
				System.out.println(sb);
			}
			return;
		}
		
		for (int i = 0 ; i < arr.length ; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			selection[r] = arr[i];
			permutation(r+1);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input ;
        
        while((input = bf.readLine()) != null) {
        	StringTokenizer st = new StringTokenizer(input);
        	String str = st.nextToken();
        	
        	num = Integer.parseInt(st.nextToken());
        	total = 0;
        	R = str.length();
        	selection = new char [R];
        	isSelected = new boolean [R];
        	arr = new char [R];
        	
        	System.out.print(str + " " + num + " = ");
        	for (int i = 0 ; i < R ; i++) {	
        		arr[i] = str.charAt(i);
        	}
        	permutation(0);
        	
        	if (total < num) {
        		System.out.println("No permutation");
        	}
        }
	}
}
