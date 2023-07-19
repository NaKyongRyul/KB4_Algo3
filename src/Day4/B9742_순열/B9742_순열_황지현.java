
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B9742_순열_황지현 {
	static int N;
	static int R;
	static int cnt=0;
	static String [] arr;
	static int []select;
	static boolean [] isSelected;
	static ArrayList <StringBuilder>ans=new ArrayList <>();
	
	public static void permutation(int r) {
		if(r==R) {
			StringBuilder sb = new StringBuilder();
			for (int i=0;i<arr.length;i++) {
				sb.append(arr[select[i]]);
			}
		ans.add(sb);
		return;
		}
		
		//재귀 확장
		for(int i=0;i<arr.length;i++) {
			//선택했다면 pass
			if (isSelected[i]==true)continue;
			
			isSelected[i]=true;
			select[r]=i;
			permutation(r+1);
			
			//방문 기록 지우기
			isSelected[i]=false;
		}
			
		
		}

	
		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String line=br.readLine();
		while(line!=null) {
			
			StringBuilder sb =new StringBuilder();
			String [] origin=line.split(" ");
			arr=origin[0].split("");
			N=Integer.parseInt(origin[1]);
			R=arr.length;
			select=new int [R];
			isSelected=new boolean [arr.length];

			permutation(0);
			System.out.println(ans);
			sb.append(origin[0]).append(" ");
			sb.append(N);
			sb.append(" = ");
			
			if (ans.size()>=N) {
				sb.append(ans.get(N-1));
				System.out.print(sb.toString());
			}
			else {
				sb.append("No permutation");
				System.out.print(sb.toString());
			}
			
			ans.clear();
			line=br.readLine();
			
		}
		
		
//		
	}
	}