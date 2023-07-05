package Day4.B2961_도영이가만든맛있는음식;

import java.util.Scanner;

public class B2961_도영이가만든맛있는음식_김태환 {
		static int [] sin; 
		static int [] sin2; 
		static int [] ssn; 
		static boolean [] isSelected;
		static int N;
		static int sum=1;
		static int j=0;
		static void subset(int num) {
			sin2=new int[N*N];
			// 종료 조건
			if(num==N) {
				for(int i=0;i<N;i++) {
					if(isSelected[i]) {
						sum*=sin[i];
					}
					}
					
						sin2[j]=sum;
						System.out.println(j+" "+sin2[j]);
						j+=1;

					sum=1;
					return;
				}
			for(int i=0;i<(N*N);i++) {
				System.out.println("j"+j);
				System.out.println(sin2[i]);
			}
			// 분할
			
			// 선택 O
			isSelected[num]=false;
			subset(num+1);
			
			// 선택 X
			isSelected[num]=true;
			subset(num+1);
		}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		sin=new int[N];
		ssn=new int[N];
		for(int i=0;i<N;i++) {
			sin[i]=sc.nextInt();
			ssn[i]=sc.nextInt();			
		}
		
		isSelected=new boolean[N];
		subset(0);
		for(int i=0;i<(N*N);i++) {
			System.out.println("i"+i);
			System.out.println(sin2[i]);
		}
		System.out.println("N"+N);
		System.out.println(j);

}
}
