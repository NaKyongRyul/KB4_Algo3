package Day4.B9742_순열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B9742_순열_김태환 {

	static String [] strarr;
	static int R;
	static int [] selection;
	static boolean [] isSelected;
	static int K;
	static String a;
	static List<String> answer = new ArrayList<String>();
	static List<String> ans = new ArrayList<String>();
	
	static void permutation(int r) {
		if(r==R) {
			for(int i=0; i<R;i++) {
				answer.add(strarr[selection[i]]);}
			ans.add(String.join("", answer));
				return;
			}
			answer.clear();
		
		for(int i=0;i<strarr.length;i++) {
			if(isSelected[i]) continue;
			isSelected[i]=true;
			selection[r]=i;
			permutation(r+1);
			isSelected[i]=false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			while(sc.hasNext()) {
			  String str=sc.next();
			  strarr=str.split("");
			  int K=sc.nextInt();
			  R=strarr.length;
			  selection=new int[R];
			  isSelected=new boolean[strarr.length];
			  permutation(0);
			  try {
			  System.out.println(String.valueOf(str)+" "+K+" = "+ans.get(K-1));
			  }catch(IndexOutOfBoundsException e) {
				  System.out.println("No permutation");
			  }
			  ans.clear();
//			  System.out.println(selection[2]);
			}
			sc.close();
	}
}

