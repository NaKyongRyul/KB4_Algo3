package Day10.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1717_집합의표현_Sol {
	
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
    	
//    	if (find(x) == find(y)) 
//    		return true;
//    	else 
//    		return false;
    	
        return (find(x) == find(y)) ? true : false;
    }
    
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		String [] strs = bf.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		parent = new int [N+1];
		
		Arrays.setAll(parent, (i) -> i);

		
		for (int i = 0; i < M; i++) {
			strs = bf.readLine().split(" ");
			int command = Integer.parseInt(strs[0]);
			int a = Integer.parseInt(strs[1]);
			int b = Integer.parseInt(strs[2]);
	
			if(command == 0)
				union(a,b);
			else if(command == 1){
				builder.append( isSameParent(a,b)?"YES\n":"NO\n");
			}
		}
		System.out.println(builder.toString());
	}
}
