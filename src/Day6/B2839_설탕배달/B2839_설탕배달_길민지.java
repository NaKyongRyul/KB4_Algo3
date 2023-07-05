package Day6.B2839_설탕배달;

// 1번
import java.util.Scanner;

public class B2839_설탕배달_길민지 {
	static int N; 
	static int cnt, remain;
	
	static void findCntMin() {
		while(remain!=0) {
			if (remain%5==0) { 
				cnt+=remain/5;
				break;
			}
			else if (remain>=3) {
				remain-=3;
				cnt++;
			}
			else {
				cnt = -1;
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		N = sc.nextInt(); 
		
		// 최소 개수 찾기
		remain = N;
		findCntMin();
		
		// 출력
		System.out.println(cnt);
		sc.close();
	}
}


// 2번
/*
import java.util.Scanner;

public class B2839_설탕배달_길민지 {
	static int N; 
	static int cnt, remain;
	
	static void findCntMin() {
		int max = N/5; // 쓸 수 있는 5kg 봉지의 최댓값
		for (int i = max; i>=0; i--) {
			remain = N;
			remain -= 5*i;
			cnt += i;
			cnt += remain/3;
			remain -= (remain/3)*3;
			if (remain==0) break;
			cnt = 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		N = sc.nextInt(); 
		
		// 최소 개수 찾기
		findCntMin();
		
		// 출력
		if (remain == 0) System.out.println(cnt);
		else System.out.println(-1);
		sc.close();
	}

}
*/

