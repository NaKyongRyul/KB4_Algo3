package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1991_트리순회_김현지 {
	static int N;
	static ArrayList <Integer>[] leftRightTree;
	static boolean [] visited;
	static int nextNode;


	
	public static void beforeSearch(int nowNode) {

		int leftNode;
		int rightNode;
		leftNode = leftRightTree[nowNode].get(0);
		rightNode = leftRightTree[nowNode].get(1);

		// print => 1번째 위치, 노드 방문
		char alpha;
		alpha = (char)(nowNode+65);
		System.out.print(alpha + "");

		// 종료조건 & 확장조건
		if (leftNode != -19) {
			beforeSearch(leftNode);
		}

		if (rightNode != -19) {
			beforeSearch(rightNode);
		}
	}
	
	public static void midSearch(int nowNode) {

		int leftNode;
		int rightNode;
		leftNode = leftRightTree[nowNode].get(0);
		rightNode = leftRightTree[nowNode].get(1);

		
		// 종료조건 & 확장조건
		if (leftNode != -19) {
			midSearch(leftNode);
		}
		// print => 2 번째 위치,  노드 방문
		char alpha;
		alpha = (char)(nowNode+65);
		System.out.print(alpha + "");
		
		if (rightNode != -19) {
			midSearch(rightNode);
		}

	}
	
	public static void afterSearch(int nowNode) {

		int leftNode;
		int rightNode;
		leftNode = leftRightTree[nowNode].get(0);
		rightNode = leftRightTree[nowNode].get(1);

		
		// 종료조건 & 확장조건
		if (leftNode != -19) {
			afterSearch(leftNode);
		}

		if (rightNode != -19) {
			afterSearch(rightNode);
		}

		// print => 2번째 위치. 노드 방문
		char alpha;
		alpha = (char)(nowNode+65);
		System.out.print(alpha + "");
	}


	


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 트리 초기화
		leftRightTree = new ArrayList [N];
		visited = new boolean [N];

		for (int i=0; i<N; i++) {
			leftRightTree[i] = new ArrayList<Integer>();
		}
		
		int parent;
		int leftChild;
		int rightChild;
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// .은 46, A는 65, 46-65 = -19
			parent = (st.nextToken()).charAt(0) - 65;
			leftChild = (st.nextToken()).charAt(0) - 65;
			rightChild = (st.nextToken()).charAt(0) - 65;
//			System.out.println("parent: " + parent + ", leftChild" + leftChild + ", rightChild: " + rightChild);
			

			// 왼쪽 오른쪽 구분 위해
			leftRightTree[parent].add(leftChild);
			leftRightTree[parent].add(rightChild);
			
		}
		

//		// tree에 입력이 제대로 되어있는지 확인
//		for(int i=0; i<N; i++) {
//			System.out.println(leftRightTree[i]);
//		}
		
		beforeSearch(0);
		System.out.println();
		midSearch(0);
		System.out.println();
		afterSearch(0);
		
		

	}

}
