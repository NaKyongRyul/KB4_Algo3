package Day9.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_박상희 {
static int parent[];
	
	// y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } 
            else {
                parent[x] = y;
            }
        }
    }
    
	// x의 부모를 찾는 연산
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		
		parent = new int[N + 1];
		for (int p = 0; p < N + 1; p++) {
			parent[p] = p;
		}
		
		for (int m = 0; m < M; m++) {
			token = new StringTokenizer(bf.readLine(), " ");
			
			int operator = Integer.parseInt(token.nextToken());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
						
			if (operator == 0) {
				union(a, b);
			}
			else if (operator == 1) {
				if (find(a) == find(b)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
	}
}
