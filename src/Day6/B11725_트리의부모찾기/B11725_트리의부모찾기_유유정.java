package Day6.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B11725_트리의부모찾기_유유정 {
	
	static ArrayList <Integer> [] tree;
	static boolean [] isVisted;
	static int []whoparents;
	static int count =0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		List <Integer> list = new ArrayList<>();
		String str;
		String [] strs ;
		int u,v;
		tree = new ArrayList [N+1];
		whoparents = new int[tree.length];
		isVisted = new boolean [tree.length];
		for(int i=0;i<tree.length;i++){
			tree[i]= new ArrayList <>();	
		}
		
		for(int i=0;i<N-1;i++) {
			str= bf.readLine();
			strs = str.split(" ");
			u = Integer.parseInt(strs[0]);
			v = Integer.parseInt(strs[1]);
			tree[u].add(v);
			tree[v].add(u);
			
		}
		parents(1);
		for(int i =2;i<whoparents.length;i++)
			System.out.println(whoparents[i]);
	}
	private static void parents(int index) {
		if(count ==tree.length)
			return;
			isVisted[index]=true;
			
			while(!tree[index].isEmpty()) {
				int idx = 0;
				int n = tree[index].get(idx);
				if(!isVisted[n]) {
					isVisted[n] = true;
					count++;
					whoparents[n]=index;
					
					parents(n);
					
				}
				tree[index].remove(idx);
			}

	}

}
