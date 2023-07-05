package Day5.B1068_트리;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1068_트리_Sol {

	static ArrayList <Integer> [] tree;
	static int N;
	static int K;
	static int root;
	static int cnt = 0;
	
	public static void DFS(int nowNode) {
        if(nowNode == K) return; // 루트노드가 K인 경우
		if(tree[nowNode].size() == 0) cnt++;
		for(int nextNode : tree[nowNode]) 
			DFS(nextNode);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(io.readLine());
		tree = new ArrayList [N];
		for(int i=0; i<N; i++) tree[i] = new ArrayList<>();
		StringTokenizer token = new StringTokenizer(io.readLine() , " ");
		
		for(int i=1; i<N; i++) {
			int parent = Integer.parseInt(token.nextToken());
			if(parent==-1) root = i; 
			else tree[parent].add(i);
		}

		K = Integer.parseInt(io.readLine());
		
		for(int i=0; i<N; i++) {
			tree[i].remove(Integer.valueOf(K));
		}
		DFS(root);
		System.out.println(cnt);
	}
}
