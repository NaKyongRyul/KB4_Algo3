package Day6.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1068_트리_전종한 {

	static int N;
	static ArrayList <Integer> [] arrList;
	static int [] parent ;
	static int delNode;
	static int cnt;
	static int rootNode;
	
	public static void removeNode(int nowNode) {   // now : 부모  ->  next : 자식
		// 방문한 노드와 인접한 모든 노드 가져옴
		for(int nextNode : arrList[nowNode]) {
			if(delNode == nextNode) {
				arrList[nowNode].remove(Integer.valueOf(delNode));
				return;
			}
            removeNode(nextNode);
		}
	}
	
	public static void countLeaf(int nowNode) {
		if(arrList[nowNode].size() == 0) {
			cnt ++;
		}
		// 방문한 노드와 인접한 모든 노드 가져옴
		for(int nextNode : arrList[nowNode]) {
				countLeaf(nextNode);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arrList = new ArrayList[N];
		parent = new int [N];
		for(int i=0; i<N; i++) {
			arrList[i] = new ArrayList <>();
		}
		String [] strs = bf.readLine().split(" ");
		for(int i=0; i<N; i++) parent[i] = Integer.parseInt(strs[i]);
		for(int i=0; i<N; i++) {
			if(parent[i] == -1) {
				rootNode = i;
				continue;
			}
			arrList[parent[i]].add(i);
		}
		
		delNode = Integer.parseInt(bf.readLine());
		
		if(delNode == rootNode) System.out.println(0);
		else {
			removeNode(rootNode);
			
			cnt = 0;
			
			countLeaf(rootNode);
			
			System.out.println(cnt);			
		}
	}
}
