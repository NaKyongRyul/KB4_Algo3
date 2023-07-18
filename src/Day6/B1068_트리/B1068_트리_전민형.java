package Day6.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1068_트리_전민형 {


	    static int num;
	    static ArrayList <Integer> [] tree;
	    static int [] mad;
	    static int how = 0;
	    static int cut;
	    static int root;
	
	static void find (int idx) {
		
		if(idx == cut) {
			return;
		}
		
		if(tree[idx].size()==0) {
			how++;
			return;
		}else {

			for(int next : tree[idx]) {
				find(next);
			}
		}

	}

	    
	public static void main(String[] args) throws IOException {

		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		String [] com;
		
		num = Integer.parseInt(str);
		
		tree = new ArrayList[num];
		mad = new int [num];
		str = reader.readLine();
		com = str.split(" ");
		
		
		for(int i = 0; i<num; i++) {
			tree[i] = new ArrayList<>();		//리스트 배열 선언
			mad[i] = Integer.parseInt(com[i]);		//부모노드 저장
		}
		
		str = reader.readLine();
		cut = Integer.parseInt(str); 				//없앨 노드
		
		
		for(int i = 0; i<num; i++) {
			if(mad[i]==-1) {root = i;
			continue;
			}
			tree[mad[i]].add(i);
		}
		
		for(int i = 0; i<num; i++) {
			for(int j = 0; j<tree[i].size(); j++) {
				if(tree[i].get(j)==cut) {
					tree[i].remove(j);
					break;
				}
			}
		}
		
		find(root);
		System.out.println(how);
		
		
	}

}
