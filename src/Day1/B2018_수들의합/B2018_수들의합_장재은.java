package Day1.B2018_수들의합;
import java.util.Scanner;

public class B2018_수들의합_장재은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 1)
			System.out.println(1);
		else {
			int arr [] = new int [n];
			for(int i=1; i<n+1; i++) {
				arr[i-1] = i;
			}
			
			int cnt = 1;
			int s = 0;
			int e = 0;
			int sum = 1;
			
			for(int i=0; i<n; i++) {
				if(sum < n) {
					e++;
					sum += arr[e];
				} else if(sum > n) {
					sum -= arr[s];
					s++;
				} else {
					cnt += 1;
					sum -= arr[s];
					s++;
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}