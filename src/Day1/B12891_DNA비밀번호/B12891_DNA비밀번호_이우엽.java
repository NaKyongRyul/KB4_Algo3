//package Day1.B12891_DNA비밀번호;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class B12891_DNA비밀번호_이우엽 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
//		int S = Integer.parseInt(token.nextToken());
//		int P = Integer.parseInt(token.nextToken());
//		
//		char[] total = new char[S];
//		total = bf.readLine().toCharArray();
//		System.out.println(Arrays.toString(total));
//		
//		token = new StringTokenizer(bf.readLine(), " ");
//		int aSatisfied = Integer.parseInt(token.nextToken());
//		int cSatisfied = Integer.parseInt(token.nextToken());
//		int gSatisfied = Integer.parseInt(token.nextToken());
//		int tSatisfied = Integer.parseInt(token.nextToken());
//		
//		boolean[] isSatisfied = new boolean[4];
//		
//
//		
//		int result = 0;
//		String password = "";
//		
//		0부터 P-1까지 P개 초기화
//		for(int i = 0; i < P; i++) {
//			password += total[i];
//		}
//		
//		// 조건검사
//		int[] dnaCnt = new int[4];
//		
//		switch(password.charAt(i)) {
//		case 'A':
//			dnaCnt[0]++;
//			break;
//		case 'C':
//			dnaCnt[1]++;
//			break;
//		case 'G':
//			dnaCnt[2]++;
//			break;
//		case 'T':
//			dnaCnt[3]++;
//			break;
//		
//		int end = P;
//		for(int i = 1; i <= end; i++) {
//			if(end > S) {
//				break;
//			}
//			
//			int removeIdx = i;
//			int appendIdx = end; 
//			
//			password.substring(0, removeIdx);
//			password += total[appendIdx];
//			
//			// 각 문자 개수 조건 검사
//			int[] dnaCnt = new int[4];
//			switch(total[i]) {
//			case 'A':
//				dnaCnt[0]++;
//				break;
//			case 'C':
//				dnaCnt[1]++;
//				break;
//			case 'G':
//				dnaCnt[2]++;
//				break;
//			case 'T':
//				dnaCnt[3]++;
//				break;
//		}
//		}
//	
//		if(dnaCnt[0] >= aSatisfied && dnaCnt[1] >= cSatisfied
//				&& dnaCnt[2] >= gSatisfied && dnaCnt[3] >= tSatisfied) {
//			Arrays.fill(isSatisfied, true);
//		}
//		
//		
//		for(int end = P-1; end <= S-1; end++) {
//			
//		}
//
//	}
//
//}
