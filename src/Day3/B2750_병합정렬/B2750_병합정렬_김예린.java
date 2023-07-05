package Day3.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2750_병합정렬_김예린 {
    //public static int[] arr, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        int [] tmp = new int[N];
        // 입력값 받기
        for (int i=0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            int inp = Integer.parseInt(st.nextToken());
            arr[i] = inp;
        }

        // 병합 정렬 실행
        mergetSort(arr , tmp , 0 , arr.length-1);

        for (int i=0; i<N; i++){
            System.out.println(arr[i]);
        }
    }
    public static void mergetSort(int [] arr, int [] tmp,  int s, int e){    // 시작점, 종료점

        if (s >= e){
            return;
        }
        // 중간점
        int m = (s + e) / 2;

        // 재귀
        mergetSort(arr , tmp , s , e);               // 시작점에서 중간점
        mergetSort(arr , tmp , m+1 , e);          // 중간점에서 종료점

        int left = s;                   // 왼쪽 구간은 시작점에서 시작
        int right = m+1;                // 오른쪽 구간은 중간+1에서 시작
        int idx = s;

        while (left <= m || right <= e){
            if (left > m){
                tmp[idx++] = arr[right++];
            }
            else if (right > e) {
                tmp[idx++] = arr[left++];
            }
            else if (arr[left] > arr[right]) {
                tmp[idx++] = arr[right++];
            }
            else  if (arr[left] < arr[right]){
                tmp[idx++] = arr[left++];
            }
        }
        for (int i = s; i <= e; i++){   // 시작점부터 종료점까지
            arr[i] = tmp[i];            // tmp 배열에 저장
        }


    }
}
