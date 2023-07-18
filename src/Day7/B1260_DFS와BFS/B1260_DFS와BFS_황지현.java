
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

public class B1260_DFS와BFS_황지현 {
	static Queue <Integer> queue;
	static ArrayList <Integer>[]arr;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] str=br.readLine().split(" ");
		int N=Integer.parseInt(str[0]);
		int M=Integer.parseInt(str[1]);
		int V=Integer.parseInt(str[2]);
		queue=new LinkedList<>();
		visited=new boolean [N+1];
		//인접리스트
		arr=new ArrayList[N+1];
		for(int i=1; i<=N;i++) {
			arr[i]=new ArrayList<>();
		}
		
		
		for(int i=0;i<M;i++) {
			String [] str2=br.readLine().split(" ");
			int a=Integer.parseInt(str2[0]);
			int b=Integer.parseInt(str2[1]);
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(arr[i]);
		}
		
		DFS(V);
		visited=new boolean [N+1];
		System.out.println();
		BFS(V);
	}
	public static void DFS(int node) {
		visited[node]=true;
		System.out.print(node+" ");
		for(int i:arr[node]) {
			if(visited[i]==false && !arr[node].isEmpty()) {
				DFS(i);
			}
		}
		
	}
	public static void BFS(int node) {
		visited[node]=true;
		queue.add(node);
//		System.out.print(node+" ");
		while (!queue.isEmpty()) {
			int start=queue.poll();
			System.out.print(start+" ");
			for(int next: arr[start]) {
				if(visited[next]==false && !arr[node].isEmpty()) {
					queue.add(next);
					visited[next]=true;
				}
			}
		}
	}
	
	
}