package Day7.B11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11724_연결요소의개수_전민형 {
	
	static ArrayList <Integer> [] con;
	static boolean isVisited [];
	static int cnt=0;
	
	public static int check(int idx) {
		if(isVisited[idx]==true)return 0;
		isVisited[idx]=true;

		for(int next : con[idx]) {
			if(isVisited[next]==true)continue;
			check(next);
		}
		
		return 1;
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		String [] com = str.split(" ");
		
		int num = Integer.parseInt(com[0]);
		int line = Integer.parseInt(com[1]);
		
		con = new ArrayList[num+1];
		isVisited = new boolean[num+1];
		
		for(int i = 0; i<num+1; i++) {
			con[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<line; i++) {
			str = reader.readLine();
			com = str.split(" ");
			
			con[Integer.parseInt(com[0])].add(Integer.parseInt(com[1]));
			con[Integer.parseInt(com[1])].add(Integer.parseInt(com[0]));
		}
		
		for(int i = 1; i<num+1; i++) {
			if(check(i)==1)cnt++;
		}
		
		System.out.println(cnt);
		
	}

}
