package Day6.B2839_¼³ÅÁ¹è´Þ;

import java.util.Scanner;

public class B2893_¼³ÅÁ¹è´Þ_±èÇýÀÎ {

	public static void main(String[] args) {
		//ÀÎ¼ö¹Þ±â
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // ¹è´ÞÇÏ´Â ¹«°Ô KG
		int cnt = 0;
		
		//N	3	4	5	6	7		8	9	10	11	12		13	14	15	16	17
		//ºÀ	1	0	1	2	1		2	3	2	3	4		3	4	3	4	3
		//5 0	0	1	1	1		1	0	2	1	0		2	1	3	2	1	
		//3 1	x	x	2	x		1	3	0	2	0		1	3	0	2	4
		//³ª 3	4	0	1	2		3	4	0	1	2		3	4	0	1	2


		if (n == 4 || n == 7) {
			System.out.println(-1);
			
		}else if(n % 5 ==0) {
			cnt += n/5;
			System.out.println(cnt);
			
		}else if (n % 5 == 1 || n % 5 == 3) {
			cnt += (n/5)+1;
			System.out.println(cnt);
		}else if (n % 5 == 2 || n % 5 == 4) {
			
			cnt += (n/5)+2;
			System.out.println(cnt);
	
	}
}
}
