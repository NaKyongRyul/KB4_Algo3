package Day2.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_나머지이용S {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<>();
		StringBuffer str = new StringBuffer();
		str.append('<');
		for(int i =1; i<N+1; i++) arr.add(i);
		
		int idx = 0;
		while(arr.size()!=0) {
			System.out.println(idx);
			idx = (idx+K-1)%arr.size();
			if(arr.size()==1) str.append(arr.remove(idx) + ">");
			else str.append(arr.remove(idx) +", ");
		}
		System.out.println(str.toString());
	}
}
