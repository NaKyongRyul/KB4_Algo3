package Exam;

import java.util.Arrays;
import java.util.Scanner;


// 01. 철수 친구는 내 친구 
// 유니온 파인드를 활용해 철수와 친구(연결된) 의 수를 구하는 문제
//
// 문제 조건 중 "철수를 제외하고" 붙어있음 -> 항상 문제 꼼꼼히 읽기 
//
// 1. 입력으로 들어온 친구관계를 이용해 union 연산을 통해 연결
// 2. 철수(1번)와 친구(연결된)인 마을사람을 find 연산을 통해 카운트   



public class 알고리즘1번_Sol {
	
	// 유니온파인드에서 사용할 부모노드를 알려줄 배열
	static int [] parent;
	
    // find 연산 = x 의 루트노트 찾아줌
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
 
    // union 연산 = (x,y) 연결
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// 부모 배열 초기화
		parent = new int [N+1];
		Arrays.setAll(parent, i -> i);
		
		// 친구들끼리 유니온 연산
		for(int i=0; i<M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			union(u,v);
		}
		
		// 철수의 친구 수
		int cnt = 0;
		
		// find 연산으로 1번(철수)과 친구인 마을사람 카운트 
		for(int i=2; i<N+1; i++) {
			if(find(1) == find(i)) cnt++;
		}
		
		// 정답 출력
		System.out.println(cnt);
		
	}

}
