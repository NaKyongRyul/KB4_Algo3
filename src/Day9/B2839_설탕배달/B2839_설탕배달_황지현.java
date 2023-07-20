
import java.util.Scanner;

public class B2839_설탕배달_황지현 {
	static int N;
	static int ans=0;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		while(N>0) {
			if(N%5==0) {
				ans+=N/5;
				N=N/5;
				break;
			}
			N-=3;
			ans+=1;
			
			
		}
		if(N<0) {
			ans=-1;
		}
		System.out.println(ans);
	}
}

