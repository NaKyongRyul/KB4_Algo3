package Day8.B1697_숨바꼭질;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class B1697_숨바꼭질_Sol {

	static int N;
	static int K;
	static int maxValue = 100001;
	static int ans = 0;
	static int [] time;
	
	public static boolean checkValid(int n) {
		if(n<0 || n>=maxValue) return false;
		return true;
	}
	
	public static void searchBFS() {
		
		Queue <Integer> que = new ArrayDeque<>();
		time = new int [maxValue];		// 0 ~ maxValue 까지 배열 생성 (최단거리 기록) 
		
		que.add(N);
		time[N] = 0;
		
		while(!que.isEmpty()) {
	
			int now = que.poll();
			if(now == K) return;		// 종료
			
			// X+1 로 이동
			if(checkValid(now+1) && time[now+1] == 0) {
				que.add(now+1);
				time[now+1] = time[now] + 1;
			}
			
			// x-1 로 이동
			if(checkValid(now-1) && time[now-1] == 0) {
				que.add(now-1);
				time[now-1] = time[now] + 1;
			}
			
			// X*2 로 이동
			if(checkValid(2*now) && time[2*now] == 0) {
				que.add(2*now);
				time[2*now] = time[now] + 1;
			}
		}
		return;
	}
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		searchBFS();
		if(N==K) System.out.println(0);
		else System.out.println(time[K]);
	}
}


