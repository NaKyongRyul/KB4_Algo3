package Day4.B9742_순열;

import java.util.*;
import java.io.*;

class Solution{
    int permutationNum = 0;
    StringBuilder answer = new StringBuilder();
    List<Character> tmp = new ArrayList<>();
    boolean[] visited;

    public void permutation(char[] chArr, int n, int cnt, int target){
        if (cnt == n){
            permutationNum++;
            if (permutationNum == target){
                for (char ch : tmp){
                    answer.append(ch);
                }
            }
            return;
        }

        for (int i = 0; i < n; i++){
            if (permutationNum == target) return;

            if (!visited[i]){
                tmp.add(chArr[i]);
                visited[i] = true;
                permutation(chArr, n, cnt + 1, target);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public String solve(char[] chArr, int n){
        visited = new boolean[chArr.length];

        StringBuilder sb = new StringBuilder();
        for (char ch : chArr){
            sb.append(ch);
        }
        sb.append(" ");
        sb.append(n);
        sb.append(" = ");

        permutation(chArr, chArr.length, 0, n);

        if (answer.length() > 0) sb.append(answer);
        else sb.append("No permutation");

        return sb.toString();
    }
}

public class B9742_순열_이도원 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String input = br.readLine();
            if (input == null) break;

            StringTokenizer st = new StringTokenizer(input);
            String str = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            char[] chArr = str.toCharArray();

            Solution sol = new Solution();
            System.out.println(sol.solve(chArr, n));
        }
    }
}
