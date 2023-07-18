package Day7.B1991_트리순회;

import java.util.ArrayList;
import java.util.Scanner;

public class B1991_트리순회_정지원 {
static ArrayList<Integer>[] tree;
	
	static void preorder(int nowNode) {
		if(nowNode==-1)return;
		System.out.print((char) ('A'+nowNode));
		for(int i=0;i<tree[nowNode].size();i++) {
			preorder(tree[nowNode].get(i));
		}
	}
	
	static void inorder(int nowNode) {
		if(nowNode==-1)return;
		if(tree[nowNode].size()>0) {
			inorder(tree[nowNode].get(0));
		}
		System.out.print((char)('A'+nowNode));
		if(tree[nowNode].size()>1) {
			inorder(tree[nowNode].get(1));
		}
	}
	
	static void postorder(int nowNode) {
		if(nowNode==-1)return;
		for(int i=0;i<tree[nowNode].size();i++) {
			postorder(tree[nowNode].get(i));
		}
		System.out.print((char)('A'+nowNode));
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		char p, c1, c2;
		
		tree = new ArrayList[n];
		
		for(int i=0;i<n;i++) {
			tree[i] = new ArrayList<>();
		}
		
		
		for(int i=0;i<n;i++) {
			p = sc.next().charAt(0);
			c1 = sc.next().charAt(0);
			c2 = sc.next().charAt(0);
			
			if(c1!='.') tree[p-'A'].add(c1-'A');
			else tree[p-'A'].add(-1);
			if(c2!='.') tree[p-'A'].add(c2-'A');
			else tree[p-'A'].add(-1);
			
		}
		
		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
		System.out.println();
		
	}
}
