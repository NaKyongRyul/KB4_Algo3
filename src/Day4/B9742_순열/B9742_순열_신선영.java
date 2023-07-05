package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9742_순열_신선영 {
    static String[] arr;
    static int cnt = 0;     // 순열 하나가 완성될 때마다 cnt ++
    static int R;   // 순열의 개수
    static int[] selected;
    static boolean[] isSelected;
    static void perm(int r, int N) {
        if (r == R) {
            cnt++;  // 순열 하나 완성
            if (cnt == N) {     // 목표 수에 다다르면 답 출력
                for (int i = 0; i < R; i++) System.out.print(arr[selected[i]]);
                System.out.println();
                return;
            }
        }

        // 중복을 포함하지 않는 수열 구현
        for (int i = 0; i < arr.length; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            selected[r] = i;
            perm(r + 1, N);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while ((input = br.readLine()) != null && input.length() != 0) {
            StringBuilder stringBuilder = new StringBuilder();  // 답 string 매번 생성
            cnt = 0;    // 새로운 테케에 cnt 리셋 안하면 오류
            String[] split = input.split(" ");
            arr = split[0].split("");   // 순열 만들 배열

            // 답 출력 형식 맞추기
            for (String a : arr) {
                stringBuilder.append(a);
            }
            stringBuilder.append(" ");
            stringBuilder.append(split[1]);
            stringBuilder.append(" = ");

            int N = Integer.parseInt(split[1]); // n번째 순열 찾기
            R = arr.length;     // 전체 값 사용

            selected = new int[arr.length];
            isSelected = new boolean[arr.length];

            // 만들 수 있는 전체 순열의 개수
            int fac = 1;
            for (int i = 1; i <= R; i++) {
                fac *= i;
            }

            System.out.print(stringBuilder);

            // 만들 수 있는 전체 순열의 개수가 문제가 요구하는 숫자보다 작을 경우 함수 실행 X
            if (N <= fac) {
                perm(0, N);
            }
            else {
                System.out.println("No permutation");
            }
        }
        br.close();
    }
}
