package Day9.B1717_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현_서지수 {
	static int parent[];
	
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
	public static void main(String[] args) throws Exception {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		parent=new int[n+1];
		
		for(int i=0;i<n+1;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(bf.readLine());
			int num=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			if(num==0) {
				//합집합 U
				union(a, b);
				union(b,a);
			}
			
			else if(num==1) {
				//같은 집합에 포함되는지 ㅠ
				if(find(a)!=find(b)) {
					System.out.println("NO");
				}
				else if(find(a)==find(b)) {
					System.out.println("YES");
				}
			}
		}
	}
}
