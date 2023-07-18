import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1991_트리순회_황지현 {
	static ArrayList<Integer> [] tree;
	static int ch=65;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		int N=Integer.parseInt(br.readLine());
		
		tree= new ArrayList[N];
		for(int i=0;i<N;i++) {
			tree[i]=new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			//charAt(0)- 문자의 0번째 글자
			int node=st.nextToken().charAt(0)-ch;
			int left=st.nextToken().charAt(0)-ch;
			int right=st.nextToken().charAt(0)-ch;
			
			tree[node].add(left);
			tree[node].add(right);
			
		}
//		System.out.println(Arrays.deepToString(tree));
		
		//실행
		preOrder(0);
		System.out.println("");
		InOrder(0);
		System.out.println("");
		PostOrder(0);
	}
public static void preOrder(int node) {
	if(node==-19) return;
	System.out.print((char)(node+ch));
	if(tree[node].get(0)!=-19)preOrder(tree[node].get(0));
	if(tree[node].get(1)!=-19)preOrder(tree[node].get(1));
}
public static void InOrder(int node) {
	if(node==-19) return;
	
	if(tree[node].get(0)!=-19)InOrder(tree[node].get(0));
	System.out.print((char)(node+ch));
	if(tree[node].get(1)!=-19)InOrder(tree[node].get(1));
}
public static void PostOrder(int node) {
	if(node==-19) return;
	if(tree[node].get(0)!=-19)PostOrder(tree[node].get(0));
	if(tree[node].get(1)!=-19)PostOrder(tree[node].get(1));
	System.out.print((char)(node+ch));
}
}
