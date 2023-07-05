package Day3.B2750_버블정렬;
import java.util.Scanner;

/**
 * �ۼ���: ������
 * ����:N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�
 * �Է�: ù° �ٿ� ���� ���� N(1 �� N �� 1,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ���� �־�����.
 *  	�� ���� ������ 1,000���� �۰ų� ���� �����̴�. ���� �ߺ����� �ʴ´�.
 * ���: ù° �ٺ��� N���� �ٿ� ������������ ������ ����� �� �ٿ� �ϳ��� ����Ѵ�.
 * */



public class B2750_버블정렬_김혜인 {

	public static void swap(int []arr, int i, int j) {
		//�ؿ��� ��ſ� ���ϰ� ������
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		
	}
	public static void main(String[] args) throws NumberFormatException {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr =  new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

		for(int i = 0 ; i<arr.length-1 ; i++) {
			int last = 0;
			for(int j = 0; j<arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					int tempValue = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tempValue;
					last = j-1;
				}
			
			}
		}
		for(int i = 0 ; i<N; i++) {
			System.out.println(arr[i]);
		}
	}

}
