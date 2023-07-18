package Day6.B11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11725_트리의부모찾기_전민형 {
	
	static boolean isSelected [];	//단방향으로 지나갔으면 true 저장
	static int [] mad;				//부모의 노드 번호
	
	static void tree(ArrayList<Integer> list[], int now) {
		
		isSelected[now]=true;
		
		for(int next : list[now]) {
			if(isSelected[next]) {
				mad[now]=next;
				continue;
			}
			
			tree(list, next);
			
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		String [] com;
		int one,two;
		
		int num = Integer.parseInt(str);
		ArrayList <Integer> [] list = new ArrayList[num+1];
		isSelected = new boolean[num+1];
		mad = new int [num+1];
		
		for(int i = 0; i<=num; i++) {
			list[i] = new ArrayList <Integer>();
		}
		
		for(int i = 1; i<num; i++) {
			str = reader.readLine();
			com	= str.split(" ");
			one = Integer.parseInt(com[0]);
			two = Integer.parseInt(com[1]);
			
			list[one].add(two);
			list[two].add(one);
			
		}
		
		
		tree(list, 1);
		
		for(int i = 2; i<mad.length; i++) {
		System.out.println(mad[i]);
		
		}
		
	}

}
