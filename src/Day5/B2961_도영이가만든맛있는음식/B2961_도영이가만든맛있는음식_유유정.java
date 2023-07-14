package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2961_도영이가만든맛있는음식_유유정 {
	
	static char [] arr;
	static int [] S;
	static int [] B;
	static int N;
	static int s;
	static int b;
	static boolean [] isSelected;
	static int answer = 1000000000;
	static int diff =0;
	static void subset(int n){
		if(n == N) {
			s = 1;
			b = 0;
			for(int i=0;i<N;i++) {
				if(isSelected[i]) {
					s = s*S[i];
					b = b+B[i];
					}	
			}
			if(s == 1 && b == 0)
				return;
			else{
				diff = Math.abs(s-b);
				answer = answer < diff ? answer : diff;

				return;
			}
			
		}
		isSelected [n] = false;
		subset(n+1);
		//선택하는 경우
		isSelected [n] = true;
		subset(n+1);
		//선택안하는 경우

		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		N = Integer.parseInt(str);
		S = new int [N];
		B = new int [N];
		isSelected= new boolean [N];
		for(int i =0; i<N ; i++){
			str = bf.readLine();
			String [] strs = str.split(" ");
			S [i] = Integer.parseInt(strs[0]);
			B [i] = Integer.parseInt(strs[1]);
		}
		
		subset(0);
		System.out.println(answer);
	}

}
