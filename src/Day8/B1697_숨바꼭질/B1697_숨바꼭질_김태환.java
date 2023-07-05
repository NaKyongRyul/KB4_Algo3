package Day8.B1697_숨바꼭질;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1697_숨바꼭질_김태환 {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(N);
        arr.add(temp);
		int p = 0;
		while (true) {			
			ArrayList<Integer> answer = arr.get(p);
			ArrayList<Integer> temp2 = new ArrayList<Integer> ();
		for (int i=0;i<answer.size();i++) {
			temp2.add(answer.get(i)-1);
			temp2.add(answer.get(i)+1);
			temp2.add(answer.get(i)*2);
			}
			arr.add(temp2);
//			System.out.println(temp2.size());
			p++;
		for(int i=0;i<temp2.size();i++) {
			if(K==temp2.get(i)) {
				System.out.println(p);
				return;
			}
		}
			
		}
		
	}

}
