import java.util.Scanner;
public class B11047_동전0_황지현 {
	static int N;
	static int K;
	static int [] arr;
	static int ans=0;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		while(K!=0) {
			for(int i=N-1;i>=0;i--) {
				if(K>=arr[i]) {
					int tmp=K/arr[i];
					ans+=tmp;
					K-=arr[i]*tmp;
					if(K==0) {
						break;
					}
				}
				else {
					continue;
				}
			}
		}
		
		System.out.println(ans);
	}
}
