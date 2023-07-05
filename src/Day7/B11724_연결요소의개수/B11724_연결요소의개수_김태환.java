package Day7.B11724_연결요소의개수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11724_연결요소의개수_김태환 {
		static int N;
		static int M;
		static ArrayList<Integer>[] arr;
		static boolean [] visited;
		static int answer=0;
		static void dfs(int cur) {
	        visited[cur] = true;

	        for (int i : arr[cur]) {
	            if (visited[i]) continue;

	            dfs(i);
	        }
		}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr= new ArrayList[N+1];
		visited=new boolean[N+1];
		for(int i=0;i<=N;i++) {
			arr[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			int tmp1=sc.nextInt();
			int tmp2=sc.nextInt();
			
			arr[tmp1].add(tmp2);
			arr[tmp2].add(tmp1);
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(arr[i]);
		}
		
		for(int i=1;i<=N;i++) {
			if(visited[i]) continue;
			dfs(i);
			answer++;
		}


		System.out.println(answer);
		
	}
}
