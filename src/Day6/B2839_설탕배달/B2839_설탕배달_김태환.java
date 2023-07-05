package Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B2839_설탕배달_김태환 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ArrayList<Integer>  answer = new ArrayList<Integer> ();
		int N=sc.nextInt();
		
		for(int i=0;i<=N/5;i++) {
			for(int j=0;j<=N/3;j++) {
				if(5*i+3*j==N) {
					answer.add(i+j);
				}
			}
		}
		if (answer.size()==0) {
			System.out.println(-1);
		}
		else {
		int min = Collections.min(answer);
			System.out.println(min);}

		
}
}