package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class B9742_순열_김휘경 {

    static char[] arr;
    static int R;
    static int[] select;
    static boolean[] isSelected;
    static String result;
    static int n;
    static int count;

    private static void permutation(String str, int r){
        if(r == str.length()){
            count++; // 순열 수 갱신
            if(count==n) {
                result = new String(arr);
            }
            return;
        }

        for(int i=0; i < str.length(); i++){ // 순열
            if(!isSelected[i]){
                isSelected[i]=true;
                arr[r]=str.charAt(i);
                permutation(str, r+1);
                isSelected[i]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line);
            String s = st.nextToken();
            n = Integer.parseInt(st.nextToken());

            count = 0;
            arr = s.toCharArray();
            R = s.length();

            // 초기화
            select = new int [R];
            isSelected = new boolean [R];


            permutation(s, 0);

            if(count < n){ // 해당 순열이 없는 경우
                result = "No permutation";
            }

            System.out.println(s + " " + n + " = " + result);


        }

    }
}
