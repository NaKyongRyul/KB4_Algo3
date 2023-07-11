package Day2.B12891_DNA비밀번호;

import java.util.*;
import java.io.*;

class Solution{
    int[] cnt = new int[4];

    public void addCnt(char ch){
        if (ch == 'A') cnt[0]++;
        else if (ch == 'C') cnt[1]++;
        else if (ch == 'G') cnt[2]++;
        else if (ch == 'T') cnt[3]++;
    }

    public void subCnt(char ch){
        if (ch == 'A') cnt[0]--;
        else if (ch == 'C') cnt[1]--;
        else if (ch == 'G') cnt[2]--;
        else if (ch == 'T') cnt[3]--;
    }

    public boolean isPossible(int[] cnt, int[] arr){
        for (int i = 0; i < 4; i++){
            if (cnt[i] < arr[i]) return false;
        }
        return true;
    }

    public int solution(int s, int p, String str, int[] arr){
        int answer = 0;

        for (int i = 0; i < p; i++) {
            addCnt(str.charAt(i));
        }

        if (isPossible(cnt, arr)) answer++;

        int idx = p;
        while(idx < s){
            subCnt(str.charAt(idx - p));
            addCnt(str.charAt(idx));

            if (isPossible(cnt, arr)) answer++;
            idx++;
        }
        return answer;
    }
}
public class B12891_DNA비밀번호_이도원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Solution sol = new Solution();
        System.out.println(sol.solution(s, p, str, arr));
    }
}
