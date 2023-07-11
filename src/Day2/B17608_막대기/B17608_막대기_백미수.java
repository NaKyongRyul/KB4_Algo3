package Day2.B17608_�����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608_�����_��̼� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine()); //������� ����

		int h = 0; //����� ����
		
		Stack<Integer> stack = new Stack<Integer>();//������ �ֱ�
		
		for(int i =0; i<N; i++) {
			h = Integer.parseInt(reader.readLine());
			stack.push(h);
		}
		int first_peek = stack.peek();
		
		int count = 0;
		int second_peek = 0;
		for(int i =N-1; i>=0; i--) {
			if(stack.get(i)>first_peek && stack.get(i)>second_peek) {
				count++;
				second_peek = stack.get(i);
			}
		}
		System.out.println(count+1);
	}
}
