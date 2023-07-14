package Day5.B2961_도영이가만든맛있는음식;

import java.util.*;
import java.io.*;

class Info{
    int sour;
    int bitter;

    public Info(int sour, int bitter){
        this.sour = sour;
        this.bitter = bitter;
    }
}

public class B2961_도영이가만든맛있는음식_이도원 {
    static List<Integer> tmp = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void combination(Info[] arr, int n, int r, int idx, int cnt){
        if (cnt == r){
            int sourScore = 1;
            int bitterScore = 0;
            for (int num : tmp){
                sourScore *= arr[num].sour;
                bitterScore += arr[num].bitter;
            }
            int diff = Math.abs(sourScore - bitterScore);
            answer = Math.min(answer,  diff);
        }

        for (int i = idx; i < n; i++){
            tmp.add(i);
            combination(arr, n, r, i + 1, cnt + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Info[] arr = new Info[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Info(s, b);
        }

        for (int i = 1; i <= n; i++){
            combination(arr, n, i, 0, 0);
        }

        System.out.println(answer);
    }
}
