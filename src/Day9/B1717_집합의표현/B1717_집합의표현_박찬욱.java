package Day9.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_박찬욱 {

	static int n,m; // n : 집합{0}~{n}, m : 입력으로 주어지는 연산의 개수
	static int [] parent;
	
	// 0 a b : a가 포함되어 있는 집합과 b가 포함되어 있는 집합을 합친다
	// 1 a b : 두 원소가 같은 집합에 포함되어 있는지를 확인
	// 출력 : 1 a b를 했을 때 참이면 "yes"를 거짓이면 "no"를 출력한다.
	
	// x의 부모를 찾는 연산
	public static int find (int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
	
	// y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
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
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		
		parent = new int [n + 1];
		for(int i = 0; i < n + 1; i++) parent[i] = i;
		
		for(int i = 0; i < m; i++) {
			token = new StringTokenizer(bf.readLine());
			int plays = Integer.parseInt(token.nextToken());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			
			if(plays == 0) { // a가 포함되어 있는 집합과 b가 포함되어 있는 집합을 합친다
				union(a, b);
			} else { // 두 원소가 같은 집합에 포함되어 있는지를 확인
				if(find(a) == find(b)) System.out.println("yes");
				else System.out.println("no");
			}
		}
		
	}
}
