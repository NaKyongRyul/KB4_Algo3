package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9742_순열_정지원 {
	public static int count;
	public static String arr;
	public static int num;
	public static boolean[] isSelected;
	public static char[] select;
	
	public static void permutation(int r) {
		if(r==arr.length()) {
			count++;
			if(count==num) {
				System.out.print(arr + " " + num + " = ");
				for(int i=0;i<arr.length();i++) {
					System.out.print(select[i]);
				}
				System.out.println();
			}
		}
		for(int i=0;i<arr.length();i++) {
			if(isSelected[i]==false) {
				select[r] = arr.charAt(i);
				isSelected[i] = true;
				permutation(r+1);
				isSelected[i] = false;
			}
		}
		
	}
	
	public static boolean havePerm(String s, int n) {
		
		int mul=1;
		for(int i=s.length();i>0;i--) {
			mul*=i;
		}
		if(mul<n) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readStr = br.readLine();
		String answer;
		isSelected = new boolean[10];
		select = new char[10];
		count =0;
		
		while(true) {

			arr = readStr.split(" ")[0];
			num = Integer.parseInt(readStr.split(" ")[1]);
			
			if(!havePerm(arr, num)) {
				System.out.println(arr+ " "+ num +" = No permutation");
			}
			
			else {
				permutation(0);
				count=0;
			}
			
			
			readStr = br.readLine();
			if(readStr==null) {
				break;
			}
		}
	}
}
