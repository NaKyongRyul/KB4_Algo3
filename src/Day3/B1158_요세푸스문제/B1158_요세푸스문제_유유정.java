package Day3.B1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B1158_요세푸스문제_유유정 {

	public static void main(String[] args) throws IOException {
		Stack <Integer> stack = new Stack<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		Queue <Integer> queue = new LinkedList<>();

		String st = bf.readLine();
		String []str = st.split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int [] arr = new int [N];
		for(int i=1;i<N+1; i++)
			stack.add(i);
		int index = K-1;
		int count =0;
		while(!stack.isEmpty()) {
			while(index >= stack.size()) {
				index= index - stack.size();
			}
			int x =stack.remove(index);
			arr[count] = x;
			index += K-1;
			count++;
			
		}
		System.out.print("<");
		for(int i=0;i< arr.length-1;i++)
			System.out.print(arr[i] +", ");
		System.out.print(arr[arr.length-1]);
		System.out.print(">");

	}

}
