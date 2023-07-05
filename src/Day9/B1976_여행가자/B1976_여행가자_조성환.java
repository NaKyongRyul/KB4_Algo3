package Day9.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1976_여행가자_조성환 {
	static int N, M;
	static int [] parent;
	static int [] trip;
	
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
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int [N+1];
		for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
		
		for (int i = 1 ; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1 ; j <= N ; j++) {				
				if (Integer.parseInt(st.nextToken()) == 1) {
					union(i,j);
				}
			}
		}
		trip = new int [M+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0 ; i < M ; i++) {
			trip[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean can = true;
		for (int i = 1 ; i < M ; i++) {
			if(find(trip[i-1]) != find(trip[i])) {
				can = false;
			}
		}
		
		if(can) {
				System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		

		
	}

}
