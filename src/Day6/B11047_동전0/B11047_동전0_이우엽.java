package Day6.B11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 11047번, 동전0
 * 입력:
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 * 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. 
 * (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 * 
 * 출력:
 * 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
 */
public class B11047_동전0_이우엽 {
	public static void greedy(int[] coinType, int K) {
		int cnt = 0;
		int sum = 0;
		// 인덱스 뒤에서부터 시작, 가장 단위가 큰 동전 종류부터
		int i = coinType.length-1;
		while(K != 0) {
			int cur = coinType[i];
			// 현재 동전이 K보다 크면 continue
			if(cur > K) {
				i--;
				continue;
			}
			// 현재 동전이 K보다 작으면
			sum += cur;
			cnt += K / cur;
			K = K - (K/cur)*cur;
			i--;
		}
		System.out.println(cnt);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		// 동전 종류 N개 입력받기 
		int[] coinType = new int[N];
		for(int i = 0; i < N; i++) {
			coinType[i] = Integer.parseInt(br.readLine());
		}
		
		greedy(coinType, K);
	}

}
