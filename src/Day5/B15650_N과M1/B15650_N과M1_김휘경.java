package Day5.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B15650_N과M1_김휘경 {

    static int[] arr;
    static int n; // 문자열 개수
    static int r; // 선택 개수
    static int[] select; // 선택저장변수
    static boolean[] isSelected; // 마킹배열


    public static void combination(int idx, int size){ // 조합

        // 종료 조건
        if(size == r){
            for(int i = 0; i < size; i++) {
                System.out.print(arr[select[i]] + " ");
            }
            System.out.println();
            return;
        }


        // 재귀 확장
        for(int i = idx; i < n; i++){
            if(!isSelected[i]){
                isSelected[i] = true;
                select[size] = i;
                combination(i, size+1);
                isSelected[i] = false;

            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]); // 1~n
        r = Integer.parseInt(input[1]); // 뽑을 개수

        // 초기화
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }

        // 초기화
        select = new int[r];
        isSelected = new boolean[n];

        // 조합 실행
        combination(0, 0);



    }
}