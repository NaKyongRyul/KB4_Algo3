package Day9.B1325_효율적인해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1325_효율적인해킹_김헤인 {
	static int n, m; // n=컴퓨터 개수, m=관계의 수 
	static int count;  //개수
	static int max;  //arr에 들어오는 값과 비교할 max
	static int[] arr; //해킹할수있는 숫자 받는 배열
	static boolean[] isvisited;
	public static List<Integer>[] list;

	public static void searchBFS(int start) { //시간줄이기 위해 bfs
		boolean[] isvisited = new boolean[n+1];
		Queue<Integer> que = new LinkedList<>();
		isvisited[start] = true;
		que.add(start);
		
		
		while (!que.isEmpty()) { //큐에 아무것도 없ㅇ르때까지 반복
			int nowNode = que.poll();  //삽입
			for (int nextNode : list[nowNode]) {
				if (isvisited[nextNode] == true)
					continue;
					arr[nextNode]++;  //해킹할수있는 숫자 증가시켜줌
					isvisited[nextNode] = true;
					que.add(nextNode);
			}
		}
	}

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());  //입력
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		
		
		//인접 리스트 만들기
		for(int i =0; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		//리스트에 신뢰되는 컴퓨터 넣기
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());  //입력 받기
			int b = Integer.parseInt(st.nextToken());  //입력 받기
			list[a].add(b);							   //인접 리스트에 신뢰 컴퓨터 번호 넣기
		//list[b].add(a);	
		}
		

		arr = new int[n+1];
		//1번 컴퓨터부터 찾기
		for(int i=1; i<n+1; i++) {
			isvisited = new boolean [n+1];
			searchBFS(i);
		}
		
		
		//max값 찾기
		ArrayList<Integer> answer = new ArrayList<>();
		int max = 0;
		for(int i =0; i<n+1; i++) {
			if(max < arr[i]) {
				max = arr[i];
				answer.clear();
				answer.add(i);
			}else if(arr[i]==max) {
				answer.add(i);
			}
		}
			//출력
		   for(int a:answer){
	            System.out.print(a+" ");
	        }
	}

}
