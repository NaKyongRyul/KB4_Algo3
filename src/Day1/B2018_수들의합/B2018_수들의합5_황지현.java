import java.util.Scanner;

public class B2018_수들의합5_황지현 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int cnt=0;
		int []arr= new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=i;
			
		}
		for(int i=1;i<=n;i++) {
			int sum=0;
			for (int j=i;j<=n;j++) {
				sum+=arr[j];
				if(sum>n) {
					break;
				}
				else if(sum==n) {
					cnt+=1;
					break;
				}
			}
		}
		System.out.println(cnt);
		sc.close();
		}
}
