package Day7.B1991_트리순회;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1991_트리순회_곽승규 {
	static char [][] ary;
	
	static void preorder(char n) {
		int idx = n - 'A';
		
		if (n == '.') {
			return;
		}
		System.out.print(n);
		preorder(ary[idx][0]);
		preorder(ary[idx][1]);
	}
	
	static void inorder(char n) {
		int idx = n - 'A';
		
		if (n == '.') {
			return;
		}
		inorder(ary[idx][0]);
		System.out.print(n);
		inorder(ary[idx][1]);
	}
	
	static void postorder(char n) {
		int idx = n - 'A';
		
		if (n == '.') {
			return;
		}
		postorder(ary[idx][0]);
		postorder(ary[idx][1]);
		System.out.print(n);
	}
	
	static void BFS(char root) {
		Queue<Character> que = new ArrayDeque<>();
		que.add(root);
		
		//큐가 비어있을때 까지 반복
		while (!que.isEmpty()) {
			char nowNode = que.poll();
			
			if(nowNode == '.') continue;
			System.out.print(nowNode); // 현재노드 출력
			int idx = nowNode - 'A';
			for (char nextNode : ary[idx]) {
				que.add(nextNode);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader  bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		
		ary = new char[N][2];
		
		
		// int a ='A' - 'A' =>  0 나옴
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			char parent = st.nextToken().charAt(0);
			int idx = parent - 'A';
			char child1 = st.nextToken().charAt(0);
			char child2 = st.nextToken().charAt(0);
			
			ary[idx][0] = child1;
			ary[idx][1] = child2;
		}
		
//		System.out.println(Arrays.deepToString(ary));
		
		preorder('A');
		System.out.println();
		inorder('A');
		System.out.println();
		postorder('A');
		
		System.out.println();
		System.out.println();
		BFS('A');
	}

}
