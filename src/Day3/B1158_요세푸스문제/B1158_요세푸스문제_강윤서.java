package Day3.B1158_요세푸스문제;

import java.util.ArrayList;
import java.util.Scanner;

public class B1158_요세푸스문제_강윤서 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		// 사람 추가
		ArrayList <Integer> list = new ArrayList<>(); // 사람
		for (int i=0; i<n; i++) {
			list.add(i+1);
		}
		
		// 사람 제거
		StringBuilder sb = new StringBuilder(); // 결과
		int index = 0; // 초기 인덱스
		
		sb.append("<");
		while (list.size()>1) {
			// 제거할 인덱스
			index = (index+k-1)%list.size();

			// 사람 제거
			sb.append(list.get(index)+", ");
			list.remove(index);
		}		
		// 마지막 원소
		sb.append(list.get(0)+">");
		
		// 결과 출력
		System.out.println(sb);
	}
}
