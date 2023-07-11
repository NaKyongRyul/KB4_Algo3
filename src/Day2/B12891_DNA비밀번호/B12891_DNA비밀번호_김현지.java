package Day2.B12891_DNA비밀번호;

// 시간 초과
import java.util.Arrays;
import java.util.Scanner;

public class B12891_DNA비밀번호_김현지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int P = sc.nextInt();
		
		String dnaStr = sc.next();
		char[] dnaChrArr = dnaStr.toCharArray();
		
		int minA = sc.nextInt();
		int minC = sc.nextInt();
		int minG = sc.nextInt();
		int minT = sc.nextInt();
		
		int numA = 0;
		int numC = 0;
		int numG = 0;
		int numT = 0;
		
		int cnt = 0;
//		System.out.println("dnaChrArr"+Arrays.toString(dnaChrArr));
		// 초기화
		for (int j=0; j < P; j++) {
			if (dnaChrArr[j] == 'A') {
				numA += 1;
			} else if (dnaChrArr[j] == 'C') {
				numC += 1;
			} else if (dnaChrArr[j] == 'G') {
				numG += 1;
			} else if (dnaChrArr[j] == 'T') {
				numT += 1;
			}				
		}
//		System.out.println("A: "+numA+", C: "+numC+", G: "+numG+", T: "+numT);
		if (numA >= minA && numC >= minC && numG >= minG && numT >= minT) {
			cnt += 1;
		}
		
		for (int i=1; i < S-P+1; i++) {
//			System.out.println("dnaChrArr"+Arrays.toString(Arrays.copyOfRange(dnaChrArr, i, i+P)));
			// 부분 배열의 첫 번째 요소
			if (dnaChrArr[i-1] == 'A') {
				numA -= 1;
			} else if (dnaChrArr[i-1] == 'C') {
				numC -= 1;
			} else if (dnaChrArr[i-1] == 'G') {
				numG -= 1;
				switch (c) {
					case 'A':
						myArr[0]--;
						if (myArr[0] == checkArr[0])
							check--;
						break;
					case 'C':
						myArr[1]--;
						if (myArr[1] == checkArr[1])
							check--;
						break;
					case 'G':
						myArr[2]--;
						if (myArr[2] == checkArr[2])
							check--;
						break;

					case 'T':
						myArr[3]--;
						if (myArr[3] == checkArr[3])
							check--;
						break;
				}			} else if (dnaChrArr[i-1] == 'T') {
				numT -= 1;
			}
			// 부분 배열의 마지막 요소
			if (dnaChrArr[i+P-1] == 'A') {
				numA += 1;
			} else if (dnaChrArr[i+P-1] == 'C') {
				numC += 1;
			} else if (dnaChrArr[i+P-1] == 'G') {
				numG += 1;
			} else if (dnaChrArr[i+P-1] == 'T') {
				numT += 1;
			}
//			System.out.println("A: "+numA+", C: "+numC+", G: "+numG+", T: "+numT);
			
			
			
			if (numA >= minA && numC >= minC && numG >= minG && numT >= minT) {
				cnt += 1;
			}
		}
		System.out.println(cnt);
		
		
 
	}

}
