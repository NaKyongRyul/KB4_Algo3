package Day2.B2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_탑_조성환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> idx = new Stack<>();

		st = new StringTokenizer(bf.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			int building = Integer.parseInt(st.nextToken());
			if (!stack.isEmpty()) {
				while(!stack.isEmpty()) {
					if(stack.peek() < building) {
						stack.pop();
						idx.pop();
					}else{
						System.out.print(idx.peek() + " ");
						break;
					}
				}
				if (stack.isEmpty()) {
                    if (idx.isEmpty()) {
                        System.out.print("0 ");
                    } else {
                        System.out.print(idx.peek() + " ");
                    }

                }
			} else {
				stack.push(building);
				idx.push(i+1);
				System.out.print("0 ");
			}
            stack.push(building);
            idx.push(i+1);
		}

	}

}
