package Day2;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListTest {

	public static void main(String[] args) {
		
		// ArrayList = 배열 기반 리스트
		ArrayList <Integer> arrList = new ArrayList<>();
		
		// LinkedList = 연결 리스트 (노드포인터)
		LinkedList <Integer> linkList = new LinkedList<>();
		
		// size 메소드 = 크기 확인
//		System.out.println(arrList.size());
//		
//		arrList.add(100);
//		arrList.add(200);
//		arrList.add(300);
//		System.out.println(arrList);
//		arrList.add(1 , 1000 );
//		System.out.println(arrList);
		
		
		/// add 시간복잡도 비교 ///
		
		// ArrayList - add 메소드 시간 측정
		long start , end;
		int N = 50000;
		start = System.currentTimeMillis();
		for(int i=0; i<N; i++)
			arrList.add(0 , 10);
		end = System.currentTimeMillis();
		System.out.println("ArrayList add 메소드 실행시간 (ms) : " + (end - start));
		
		// LinkedList - add 메소드 시간 측정
		start = System.currentTimeMillis();
		for(int i=0; i<N; i++)
			linkList.add(0 , 10);
		end = System.currentTimeMillis();
		System.out.println("LinkedList add 메소드 실행시간 (ms) : " + (end - start));
		
		
		System.out.println();

		// get 메소드 = 조회 //
		
		// ArrayList - get 메소드 시간 측정
		start = System.currentTimeMillis();
		for(int i=0; i<N; i++)
			arrList.get(arrList.size()/2);
		end = System.currentTimeMillis();
		System.out.println("ArrayList get 메소드 실행시간 (ms) : " + (end - start));
		
		// LinkedList - get 메소드 시간 측정
		start = System.currentTimeMillis();
		for(int i=0; i<N; i++)
			linkList.get(arrList.size()/2);
		end = System.currentTimeMillis();
		System.out.println("LinkedList add 메소드 실행시간 (ms) : " + (end - start));
		
		System.out.println();
		
		// 삭제 = remove 메소드 //
		
		// ArrayList remove 메소드 시간 측정
		start = System.currentTimeMillis();
		for(int i=0; i<N; i++)
			arrList.remove(0);
		end = System.currentTimeMillis();
		System.out.println("ArrayList remove 메소드 실행시간 (ms) : " + (end - start));
		
		// LinkedList - remove 메소드 시간 측정
		start = System.currentTimeMillis();
		for(int i=0; i<N; i++)
			linkList.remove(0);
		end = System.currentTimeMillis();
		System.out.println("LinkedList remove 메소드 실행시간 (ms) : " + (end - start));
		
	}
	
}
