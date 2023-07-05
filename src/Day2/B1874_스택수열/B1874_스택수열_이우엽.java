//package Day2.B1874_스택수열;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Stack;
//
//public class B1874_스택수열_이우엽 {
//	static int[] untilN;
//	static int[] seqs;
//
//	
//	public static boolean compareNum(int num, int top) {
//		if(num < top) {
//			return false;
//		}
//		// num이 top보다 크면 pop
//		return true;
//	}
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(bf.readLine());
//		
//		untilN = new int[N];
//		seqs = new int[N];
//		
//		// 빈 스택
//		Stack<Integer> stack = new Stack<>();
//	
//		
//		// 입력된 다음과 같은 수열이 나와야한다, 4 3 6 8 7 5 2 1
//		for(int i = 0, len = seqs.length; i < len; i++) {
//			seqs[i] = Integer.parseInt(bf.readLine());
//		}
//		
//		int idx = 0; // 1, 2, 3, 4, 5, 6, 7, 8
//		for(int i = 0, len = seqs.length; i < len; i++) {
//			int current = seqs[i]; // 4
//			if(stack.isEmpty() || current > stack.peek()) {
//				for(int j = idx; j < current; j++) {
//					stack.push(idx);
//				}
//			} else {
//				stack.push(num);
//			}
//		}
//	}
//
//}
