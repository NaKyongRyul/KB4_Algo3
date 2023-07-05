
package Day6.B2839_설탕배달;
import java.util.Scanner;

public class B2839_설탕배달_Sol {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt_3 = -1;
		int cnt_5 = N/5;
		while(cnt_5 >= 0) {
			if((N - 5*cnt_5)%3 == 0) {
				cnt_3 = (N - 5*cnt_5)/3;
				break;
			}
			cnt_5--;
		}
		if(cnt_3 == -1) System.out.println(-1);
		else System.out.println(cnt_5 + cnt_3);
	}
}
