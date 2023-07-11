package Day2.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B12891_DNA비밀번호_김휘경 {
    static int[] count = new int[4]; // 입력받은 최소 갯수
    static int[] countArr = new int[4];
    static int end = 0;
    static int answer = 0; // 만들 수 있는 문자열 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int s = Integer.parseInt(st.nextToken()); // s길이
        int p = Integer.parseInt(st.nextToken()); // 비밀번호 문자열 길이


        char[] ss = br.readLine().toCharArray(); // 주어진 문자열
        String[] count2 = br.readLine().split(" ");

        for (int i = 0; i < 4; i++) {
            count[i] = Integer.parseInt(count2[i]); // target count
        }

        Character[] checkArr = new Character[] {'A', 'C', 'G', 'T'};

        /**
         * index 0 ~ index p인 문자열 확인 - 원본 문자열
         */
        for (int i = 0; i < p; i++) {
            for(int j = 0; j < 4; j++){
                if(ss[i] == checkArr[j]){
                    countArr[j] += 1;
                }
            }
        }

        if (check()) { // 0~p 확인
            answer += 1;
        }



        /**
         * index start ~ index start + p 까지 확인(슬라이딩 윈도우 반복)
         */
        for (int start = 0; start < s-p; start++) {
            end = start + p;

            // 시작문자 제외
            for(int j = 0; j < 4; j++){
                if(ss[start] == checkArr[j]){
                    countArr[j] -= 1;
                }
            }

            // 뒤에 문자 추가
            for(int j = 0; j < 4; j++){
                if(ss[end] == checkArr[j]){
                    countArr[j] += 1;
                }
            }

            if (check()) { // start~end 확인
                answer += 1;
            }

        }

        System.out.println(answer);


    }

    public static boolean check(){ // 비밀번호 유효성 확인
        for(int i = 0; i < 4; i++){
            if(count[i] > countArr[i]){
                return false;
            }
        }
        return true;
    }
}
