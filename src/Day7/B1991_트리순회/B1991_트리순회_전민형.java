package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1991_트리순회_전민형 {

	static int num;
	static ArrayList <Integer> [] tree;
	static int [] mad = new int [3];
	
	static void frontroop (int idx) {
		if(idx<0) return;
		
		System.out.print((char)(idx+65));
		
		for(int next : tree[idx]) {
			frontroop(next);
		}
	}

	static void midroop (int idx) {
		if(idx<0) return;

		midroop(tree[idx].get(0));
		System.out.print((char)(idx+65));
		midroop(tree[idx].get(1));
		
	}

	static void backroop (int idx) {
		if(idx<0) return;

		for(int next : tree[idx]) {
			backroop(next);
		}
		System.out.print((char)(idx+65));
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		String [] com = new String [3];
		
		num = Integer.parseInt(str);
		tree = new ArrayList[num];
		
		for(int i = 0; i<num; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<num; i++) {
			str = reader.readLine();
			com = str.split(" ");
			
			for(int j = 0; j<3; j++) {
				mad[j] = (com[j].charAt(0))-65;
				
			}
			tree[mad[0]].add(mad[1]);
			tree[mad[0]].add(mad[2]);
			
			
		}
		
		frontroop(0);
		System.out.println();
		midroop(0);
		System.out.println();
		backroop(0);
		
	}

}
