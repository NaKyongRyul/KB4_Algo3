package Day8.B13023_ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B13023_ABCDE_전민형 {
	
	static int deep;
	static int ans = 0;
	static boolean isVisited [];
	static ArrayList <Integer> [] fr;
	
	public static void friends(int idx) {
		if(ans == 1)return;
		
		isVisited[idx]=true;
		deep++;
		if(deep == 5) {
			ans = 1;
			return;
		}
		
		for(int next : fr[idx]) {
			if(isVisited[next]==false) {
			friends(next);
			}
		}
		deep--;
		isVisited[idx]=false;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		String com [] = str.split(" ");
		
		int num = Integer.parseInt(com[0]);
		int line = Integer.parseInt(com[1]);
		isVisited = new boolean [num];
		
		fr = new ArrayList[num];
		
		for(int i = 0; i<num; i++) {
			fr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<line; i++) {
			str = reader.readLine();
			com = str.split(" ");
			fr[Integer.parseInt(com[0])].add(Integer.parseInt(com[1]));
			fr[Integer.parseInt(com[1])].add(Integer.parseInt(com[0]));
		}
		
		for(int i = 0; i<num; i++) {
			deep = 0;
			friends(i);
			if(ans == 1) break;
		}
		
		System.out.println(ans);
	}

}
