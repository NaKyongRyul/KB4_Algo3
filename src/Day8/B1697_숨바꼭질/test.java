package Day8.B1697_숨바꼭질;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test {

	public static int N;
	public static boolean[] noPrime; 
	static int [] odds = {1,2,3,5,7,9};

	// 소수 확인 함수
	static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++)
			if (num % i == 0)
				return false;
		return true;
	}


	// DFS 탐색
	public static void searchDFS(int n , int cnt) {

		if(cnt >= N) {
			System.out.println(n);
			return;
		}

		for(int i : odds) {
			if(isPrime(n*10 + i) == false) continue; 
			searchDFS(n*10 + i , cnt + 1);
		}
	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.next());

		// [2,3,5,7] 에 대해서 확인
		for(int i : new int [] {2,3,5,7}) {
			searchDFS(i , 1);
		}

	}

}

