package Day4.B9742_순열;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9742_순열_김혜인{
	 static String[] arr;
	    static int cnt = 0;
	    static int R;
	    static int[] selected;
	    static boolean[] isSelected;
	    
	    
	    
	    static void permutation(int r, int N) {
	        if (r == R) {
	            cnt++; //순열 하나씩 count
	            if (cnt == N) { 
	                for (int i = 0; i < R; i++) System.out.print(arr[selected[i]]);
	                System.out.println();
	                return;
	            }
	            
	        }
	        
	        //중복 포함x
	        for (int i = 0; i < arr.length; i++) {
	            if (isSelected[i]) continue;
	            isSelected[i] = true;
	            selected[r] = i;
	            permutation(r + 1, N);
	            isSelected[i] = false;
	        }
	    }



	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String input = "";
	        
	        //입력받기
	        while ((input = br.readLine()) != null && input.length() != 0) {
	            StringBuilder stringBuilder = new StringBuilder();  /// 답
	            
	            cnt = 0; //새로운 값 다시 들어갈시 0으로 다시 리셋 필요
	            String[] split = input.split(" ");
	            arr = split[0].split("");  //순열 만드는 배열 
	            
	            
	            //반복
	            for (String a : arr) {  
	                stringBuilder.append(a);
	            }
	            
	            //답
	            stringBuilder.append(" ");
	            stringBuilder.append(split[1]);
	            stringBuilder.append(" = ");
	            
	            
	            R = arr.length;
	            int N = Integer.parseInt(split[1]);  //순열찾기
	            selected = new int[arr.length];	//변수
	            isSelected = new boolean[arr.length];

	            
	            //전체 순열의 개수
	            int factor = 1;
	            for (int i=1; i<=arr.length; i++) {
	            	factor *=i ;            
	        	 
	            }
	            
	            System.out.print(stringBuilder);
	   
	          
	            if(N <=factor) {
	            	 permutation(0,N);  //순열함수 시행
	            }else {
	            	System.out.println("No permutation");  // 순열 개수가 요구하는 것보다 작으면 수행하지 않음
	            }
	            
	            
	        }
	        br.close();
	    }
	    
}