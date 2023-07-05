package Day9.B1717_집합의_표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_조성환 {
	static int N, M;
	static int A,B,C;
	static int [] parent;
	
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
 
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int [N+1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			switch (A) {
			case 0:
				union(B,C);
				break;
			default:
				if(find(B) == find(C)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
				break;
			}
		}


		 
	}
}
