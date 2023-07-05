package Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class B1759_암호만들기_서은효 {
	
	static String [] arr;
	static int L;
	static int C;
	static boolean [] isSelected;
	static int [] selection;
	static String [] mojang;
	static String str;
	
	
	static void combination(int num, int start ) {
		 int moeum = 0; 
		 int jaeum = 0;
		if(num == L) {
			mojang = new String[L];
			for(int i =0; i<L; i++) {
				mojang[i] =  arr[selection[i]];
			}
			
			for(String n : mojang) {
				
				if(n.charAt(0) == 'a'|| n.charAt(0)== 'e'||n.charAt(0)=='i'||n.charAt(0)=='o'||n.charAt(0)=='u' ) {
					moeum++;
					
				}else jaeum++;	
			}
			
			if(moeum >= 1 && jaeum>= 2 ) {
				for(String n : mojang)
					System.out.print(n);
				System.out.println();
			}

			return;
		}
		
		
		for(int i =start; i<C; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			selection[num] = i;
			combination(num+1,i);
			isSelected[i] = false;
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		L = Integer.parseInt(token.nextToken()); // 4
		C = Integer.parseInt(token.nextToken()); // 6
		arr = new String[C];
		token = new StringTokenizer(bf.readLine());
		
		isSelected = new boolean [C];
		selection = new int[C];
		
		for(int i =0; i<C ;i++) arr[i] = token.nextToken();
		
		Arrays.sort(arr);
		combination(0, 0);

		
	}

}
