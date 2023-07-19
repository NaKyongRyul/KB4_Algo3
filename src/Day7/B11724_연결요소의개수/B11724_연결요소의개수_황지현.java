
package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11724_연결요소의개수_황지현 {
	static int N;
	static int M;
	static int cnt=0;
	static ArrayList <Integer>[]arr;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] str=br.readLine().split(" ");
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		visited=new boolean [N+1];
		
		//인접리스트
		arr=new ArrayList[N+1];
		for(int i=0; i<=N;i++) arr[i]=new ArrayList<>();
		
		//간선 입력받기
		for(int i=1;i<=M;i++) {
			String [] str2=br.readLine().split(" ");
			int a=Integer.parseInt(str2[0]);
			int b=Integer.parseInt(str2[1]);
			
			arr[a].add(b);
			arr[b].add(a);
		}
		for(int i=1;i<=N;i++) {
			if(visited[i]==false) {
				DFS(i);
				cnt+=1;
			}
			
		}
		
		System.out.println(cnt);
		
	}
	
	public static void DFS(int node) {
		visited[node]=true;
	
			
		for(int i: arr[node]) {
			if(visited[i]==false && !arr[i].isEmpty()) {
				
				DFS(i);
			}
			
		}
		
	}
=======
package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11724_연결요소의개수_황지현 {
	static int N;
	static int M;
	static int cnt=0;
	static ArrayList <Integer>[]arr;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] str=br.readLine().split(" ");
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		visited=new boolean [N+1];
		
		//인접리스트
		arr=new ArrayList[N+1];
		for(int i=0; i<=N;i++) arr[i]=new ArrayList<>();
		
		//간선 입력받기
		for(int i=1;i<=M;i++) {
			String [] str2=br.readLine().split(" ");
			int a=Integer.parseInt(str2[0]);
			int b=Integer.parseInt(str2[1]);
			
			arr[a].add(b);
			arr[b].add(a);
		}
		for(int i=1;i<=N;i++) {
			if(visited[i]==false) {
				DFS(i);
				cnt+=1;
			}
			
		}
		
		System.out.println(cnt);
		
	}
	
	public static void DFS(int node) {
		visited[node]=true;
	
			
		for(int i: arr[node]) {
			if(visited[i]==false && !arr[i].isEmpty()) {
				
				DFS(i);
			}
			
		}
		
	}
>>>>>>> 3e38ccfa0bb920e926126c441214fe243a7c232e
}