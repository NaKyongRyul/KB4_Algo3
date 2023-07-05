package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9742_순열_김태선 {
	
    static int totalCount, num;
    static boolean visit[]; 
    static char[] chars; 
    static String answer;


    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line);
            String str = st.nextToken();
            num = Integer.parseInt(st.nextToken());


            totalCount = 0;
            chars = new char[str.length()];
            visit = new boolean[str.length()];

            dfs(str, 0);

            if(totalCount < num) answer = "No permutation";
            System.out.println(str + " " + num + " = " + answer);
        }
    }

    static void dfs(String str, int cnt){
        if(cnt == str.length()){
            totalCount++;
            if(totalCount == num) answer = new String(chars);

            return;
        }

        for(int i = 0; i < str.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                chars[cnt] = str.charAt(i);
                dfs(str, cnt + 1);
                visit[i] = false;
            }
        }
    }
}