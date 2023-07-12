package Day3.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2493_탑_전종한 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		String [] strs = bf.readLine().split(" ");

		Stack <Integer> stack = new Stack<>();
		Stack <Integer> values = new Stack<>();
		Stack <Integer> idxs = new Stack<>();
		int [] arr = new int [N];

		stack.push(100_000_001);
		for(String str : strs) stack.push(Integer.parseInt(str));

		for(int j=0; j<N+1; j++) {
			int pop_value = stack.pop();
			if(values.isEmpty()) {
				values.push(pop_value);
				idxs.push(j);
				continue;
			}
			int size = values.size();
			for(int k=0; k<size+1; k++) {
				if(values.isEmpty()) {
					values.push(pop_value);
					idxs.push(j);
				}
				else if(values.peek() < pop_value) {
					values.pop();
					int idx = idxs.pop();
					arr[idx] = j;
				}else if(values.peek() > pop_value) {
					values.push(pop_value);
					idxs.push(j);
					break;
				}		
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(N-arr[N-1]);
		for(int i=arr.length-2; i>=0; i-- ) {
			sb.append(" ");
			sb.append(N-arr[i]);
		}
		System.out.println(sb);


	}
}
