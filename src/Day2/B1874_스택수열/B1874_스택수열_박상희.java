package Day2.B1874_스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class B1874_스택수열_박상희 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		Stack <Integer> stack = new Stack <>();		
		
		int numArr[] = new int[N];
		ArrayList<Integer> resArr = new ArrayList<>();
		ArrayList<String> operator = new ArrayList<>();
		int takeNum = 1;
		
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(bf.readLine());
			numArr[n] = num;
			
			if (takeNum <= num) {
				while (takeNum <= num) {
					stack.add(takeNum);
					operator.add("+");
					takeNum++;
				}
			}
			
			if (takeNum > num) {
				if (!stack.isEmpty()) {
					if (num < stack.peek()) {
						break;
					}
					
					int p = stack.pop();
					resArr.add(p);
					operator.add("-");
					
					while(p != num) {
						if (!stack.isEmpty()) {
							p = stack.pop();
							resArr.add(p);
							operator.add("-");
						}
					}
				}
			}		
		}		
		
		boolean flag = false;
		if (resArr.size() == numArr.length) {
			for (int j = 0; j < N; j++) {
				if (resArr.get(j) == numArr[j]) {
					flag = true;
				}
				else {
					flag = false;
					break;
				}
			}
		}
		else {
			flag = false;
		}
		
		if (flag) {
			for (int k = 0; k < operator.size(); k++) {
				System.out.println(operator.get(k));
			}
		}
		else {
			System.out.println("NO");
		}
	}
}
