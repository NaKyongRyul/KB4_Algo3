package Day9.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976_여행가자_박상희 {
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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
		
		for (int n = 1; n < N + 1; n++) {
			token = new StringTokenizer(bf.readLine(), " ");

			for (int c = 1; c < N + 1; c++) {
				int city = Integer.parseInt(token.nextToken());
				
				if (city == 1) {
					union(n, c);
				}
			}
		}
		
		token = new StringTokenizer(bf.readLine(), " ");
		
		boolean flag = true;
		int destination[] = new int[M];
		for (int m = 0; m < M; m++) {
			destination[m] = Integer.parseInt(token.nextToken());
			
			if (m > 0) {
				if (find(destination[m]) == find(destination[m - 1])) {
					continue;
				}
				else {
					flag = false;
					break;
				}
			}
		}
		
		if (flag) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}
