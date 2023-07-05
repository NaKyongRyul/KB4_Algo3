package Day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// Comparator 클래스 상속
class testComparator implements Comparator <String>{
	@Override
	public int compare(String a , String b) {
		return a.charAt(0) - b.charAt(0);
	}
}

public class SortTest {

	public static void main(String[] args) {
		
		/// 1. Arrays.sort() 메소드 이용 ///
		int [] arr = {4,2,3,9,1,7};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		// 내림차순 정렬 -> Collections.reverseOrder() (Primitive 타입은 X  int => Integer 사용)
		Integer [] arr2 = {4,2,3,9,1,7};
		Arrays.sort(arr2 , Collections.reverseOrder());
		System.out.println(Arrays.toString(arr2));
		System.out.println();
		
		/// 2. Collections.sort() 메소드 이용 ///
		
		ArrayList <Integer> arr_lst = new ArrayList(Arrays.asList(4,2,3,9,1,7)); // Arrays.asList => 촉화
		System.out.println(arr_lst);
		Collections.sort(arr_lst);
		System.out.println(arr_lst);
		
		// 내림차순 // 
		Collections.sort(arr_lst , Collections.reverseOrder());
		System.out.println(arr_lst);
		
		
		/// 3. Comparator 클래스 이용 ///
		ArrayList <String> str_lst = new ArrayList(Arrays.asList("java","c", "python","app","linux"));
		System.out.println(str_lst);
		
		Collections.sort(str_lst , new testComparator());
		System.out.println(str_lst);
		
		Collections.sort(str_lst , new Comparator <String>() {
			@Override
			public int compare(String a , String b) {
				return b.length() - a.length();
			}
		});
		System.out.println(str_lst);
		
		
		/// 4. Lambda 이용 ///
		ArrayList <Integer> arr_lst2 = new ArrayList(Arrays.asList(2,-4,-9,0,3,-1,7));
		Collections.sort(arr_lst2 , (a,b) -> Math.abs(a)- Math.abs(b));
		System.out.println(arr_lst2);
		
		
	}
	
}
