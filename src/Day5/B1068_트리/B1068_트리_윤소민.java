package Day5.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1068_트리_윤소민 {
	
	static int n;
	static int [] arr;
	static ArrayList<Integer> [] node;
	static int rm;
	
	static void remove(int rm) {
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		node= new ArrayList[n];
		for (int i = 0; i < node.length; i++) {
			node[i] = new ArrayList<>();
	        
	      }
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]==-1) continue;
			else node[arr[i]].add(i);
		}
		
		//System.out.println(Arrays.toString(node));
		rm = Integer.parseInt(bf.readLine());
		
		remove(rm);
		//System.out.println(Arrays.toString(node));
		
		int cnt=0;
		
		System.out.println(cnt);
	}

}
