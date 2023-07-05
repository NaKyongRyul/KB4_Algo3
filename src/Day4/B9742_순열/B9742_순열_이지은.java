package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9742_순열_이지은 {
	static char [] arr;
	static int R, n;
	static int [] selection;
	static boolean [] isSelected;
	static int cnt;
	static String[] str2;
	static int sum;
	
	static void permutation(int r) {
		//해당하는 순열이 없는 경우
		if(sum<n) {
			System.out.print(str2[0] +" "+ n+" = No permutation");
			return;
		}
		
		//종료조건 
		if(r == R) {
			if(cnt == n) {
				System.out.print(str2[0] +" "+ n+" = ");
				for(int i=0; i<R; i++) System.out.print(arr[selection[i]]);
			}
			cnt++;
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			selection[r] = i;
			permutation(r+1);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = "";
		
			while((str = br.readLine()) != null) {
				str2 =str.split(" ");
				arr = new char[str2[0].length()];
				n = Integer.parseInt(str2[1]);
			
				arr = str2[0].toCharArray();
				
				R = arr.length;
				selection = new int[R];
				isSelected = new boolean[R];
	
				sum = 1;
				cnt = 1;
				//순열의 갯수 계산 
				for(int i=2; i<=R; i++) {
					sum *= i;
				}
				
				permutation(0);
				System.out.println();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
