package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1991_트리순회_나웅기 {
	static ArrayList<Integer> [] arr;
	// 전위 순회
	public static void pre(int x) {
		if (x== -1) {
			 return;
		}
		System.out.print((char) (x + 65));
		pre(arr[x].get(0));
		pre(arr[x].get(1));
		
	}
	// 중위 순회
	public static void in(int x) {
		if (x==-1) {
			return;
		}
		in(arr[x].get(0));
		System.out.print((char) (x+65));
		in(arr[x].get(1));
	}
	// 후위 순회
	public static void post(int x) {
		if (x==-1) {
			return;
		}
		post(arr[x].get(0));
		post(arr[x].get(1));
		System.out.print((char) (x+65));
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		arr = new ArrayList[n];
		for (int i = 0; i<n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i<n; i++) {
			String [] str = reader.readLine().split(" ");
			
			
			int p = str[0].charAt(0) - 65;
			
			int c1 = str[1].charAt(0);
			int c2 = str[2].charAt(0);
			
			if (c1 != '.') {
				arr[p].add(c1-65);
			} else {
				arr[p].add(-1);
			}
			
			if (c2 != '.') {
				arr[p].add(c2-65);
			} else {
				arr[p].add(-1);
			}
			
			
		}

		pre(0);
		System.out.println();
		in(0);
		System.out.println();
		post(0);
	}
}
