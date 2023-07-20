package Day9.B1931_회의실배정;

import java.io.*;
import java.util.*;

public class B1931_회의실배정_김철 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            arr[i][0] = start;
            arr[i][1] = end;
        }
        
        // 종료시각 먼저 정렬, 다음 시작시각
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] s1, int[] s2){
                return s1[1] != s2[1] ? s1[1] - s2[1] : s1[0] - s2[0];
            }
        });

        int count = 1;
        int endTemp = arr[0][1];
        
        for(int i=1; i<N; i++){
            if(arr[i][0] >= endTemp){
                endTemp = arr[i][1];
                count += 1;
            }
        }
        
        bw.write(count+"");
        bw.close();
    }
}
