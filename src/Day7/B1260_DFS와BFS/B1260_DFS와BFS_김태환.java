package Day7.B1260_DFS와BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1260_DFS와BFS_김태환 {
	
    static int N;
    static int M;
    static ArrayList<Integer>[] arr;
    static int V;
    static boolean [] visited;
    
    static void dfs(int cur) {
        visited[cur] = true;
        System.out.print(cur + " ");

        for (int i : arr[cur]) {
            if (visited[i]) continue;
            dfs(i);
        }
    }

    static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(cur);
        visited[cur] = true;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            System.out.print(tmp + " ");

            for (int i : arr[tmp]) {
                if (visited[i]) continue;
                visited[i] = true;
                queue.offer(i);
            }
        }
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		V=sc.nextInt();
		arr = new ArrayList[N+1];
        
		visited = new boolean[N+1];

		for(int i=0; i<=N;i++) {
			arr[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();
			
			arr[tmp1].add(tmp2);
			arr[tmp2].add(tmp1);
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(arr[i]);
		}
		dfs(V);
		visited=new boolean[N+1];
		System.out.println();
		bfs(V);
		for(int i=0;i<=N;i++) {
		System.out.println(arr[i]);
		}
	}

}
