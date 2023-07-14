package Day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650_N과M_송봉섭 {
    static int[] arr;
    static int N;
    static int M;

    static int [] select; // 선택 저장 변수 (출력용)

    static boolean[] isSelected; // 마킹배열

    public static void combination(int idx, int size) {
        //종료조건
        if (size == M) {
            for(int i=0; i<M; i++) System.out.print(arr[select[i]]+" ");
            System.out.println();
            return;
        }
        //재귀확장
        for (int i = idx; i < N; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            select[size] = i;
            combination(i,size + 1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        String[] strings = line.split(" ");
        N = Integer.parseInt(strings[0]);
        M = Integer.parseInt(strings[1]);
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        //System.out.println(Arrays.toString(arr));

        select = new int[M];
        isSelected = new boolean[N];

        combination(0,0);




    }



}
