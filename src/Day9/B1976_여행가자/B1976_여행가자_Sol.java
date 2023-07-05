package Day9.B1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1976_여행가자_Sol {
	static int N;
	static int M; 
	static int arr [][];
	static int [] parent;
	
    // x의 부모를 찾는 연산
    public static int find(int x) {
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
 
    // x와 y의 부모가 같은지 확인
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return true;
        return false;
    }
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		parent = new int [N];
		Arrays.setAll(parent, (i) -> (i) );
		
		System.out.println(Arrays.toString(parent));
		
		
		StringTokenizer token;
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(bf.readLine() , " ");
			for(int j=0; j<N; j++) {
				if(token.nextToken().equals("1")) {
					union(i,j);
				}
			}
		}
		
		token = new StringTokenizer(bf.readLine() , " ");
		int root = find(Integer.parseInt(token.nextToken()) - 1);
		
		for(int i=1; i<M; i++) {
			if(find(Integer.parseInt(token.nextToken()) - 1) != root) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
