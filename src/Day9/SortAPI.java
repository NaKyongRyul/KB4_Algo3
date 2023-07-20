package Day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortAPI {

	public static void main(String[] args) {
		
		
	// 1. Arrays.sort() = 배열 오름차순 정렬
	int [] arr = {4,2,3,4,1,7,6};
	Arrays.sort(arr);
	System.out.println(Arrays.toString(arr));
		
	
	// 2. Collections.sort() = 리스트 오름차순 정렬
	ArrayList <Integer> arr_lst = new ArrayList<>(Arrays.asList(-5,2,4,7,1,2,3));
	Collections.sort(arr_lst);
	System.out.println(arr_lst); 
	
	
	// 3. 내림차순 정렬 = sort() 메소드에 Collections.reverseOrder() 인자로
	Integer [] arr2 = {4,2,3,4,1,7,6};
	Arrays.sort(arr2 , Collections.reverseOrder());
	System.out.println(Arrays.toString(arr2));
	
	Collections.sort(arr_lst , Collections.reverseOrder());
	System.out.println(arr_lst); 
	
	
	// 4. Comparator 오버라이딩 이용 구현 => compare 함수로 원하는 기준 정렬
	Collections.sort( arr_lst  , new Comparator <Integer> () {		
		@Override
		public int compare(Integer a , Integer b) {
		return Math.abs(b) - Math.abs(a);
	} });
	
	System.out.println(arr_lst); 
	
	
	// 5. lambda 문법 이용 (추천!)
	ArrayList <String> str_lst = new ArrayList(Arrays.asList("banana" , "apple" , "pineapple" , "Hi"));
	System.out.println(str_lst);
	Collections.sort(str_lst , (s1 , s2) -> s1.length() - s2.length()  );
	System.out.println(str_lst);
	
	
	// 6. 배열이 2차원 이상인 경우
	int [][] arr2d = { {4,1} , {2,7} , {2,3} , {1,1} , {1,0} , {4,8}};
	
	
	// 첫번째 값으로 정렬
	Arrays.sort(arr2d ,  (a,b) -> (a[0] - b[0])   );
	System.out.println(Arrays.deepToString(arr2d));
	
	
	// 첫번째 값으로 정렬하되 같으면 두번째 값으로 정렬 (Comparator 이용)
	Arrays.sort(arr2d , new Comparator<int []>() {
	@Override
	public int compare(int [] a , int [] b) {
		if(a[0] != b[0]) return a[0] - b[0];
		else return a[1] - b[1];
	}});
	
	// 첫번째 값으로 정렬하되 같으면 두번째 값으로 정렬 (lambda 식 이용)
	Arrays.sort(arr2d ,  (a,b) -> ((a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]) );
	
	System.out.println(Arrays.deepToString(arr2d));
	
	}
}
