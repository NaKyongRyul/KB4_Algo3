package Day5.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11725_트리의부모찾기_박예린 {
	static int N;
	static ArrayList<Integer> tree [];
	static boolean [] isVisited;
	static int [] res;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		tree = new ArrayList[N + 1];
		isVisited = new boolean [N+1];
		res = new int [N+1];
		
	    for (int i = 0; i < N + 1; i++) {
    		tree[i] = new ArrayList<>();
        }
	    
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(bf.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
				
			tree[u].add(v);
			tree[v].add(u);
		}
	    for (int i = 0; i < N + 1; i++) {

        }
	    
	    int count = 0;
	    
	    while(count < N + 1) {
		    for (int i = 0; i < N + 1; i++) {
				if(tree[i].size() == 1) {
					res[i] = tree[i].get(0); // leaf node e.g. 2, 7, 5
					isVisited[i] = true;
					tree[tree[i].get(0)].remove(Integer.valueOf(i));
					count++;
				}
	        }
	    }
	    for (int i = 2; i < N + 1; i++) {
		    System.out.println(res[i]);
	    }
	}
}