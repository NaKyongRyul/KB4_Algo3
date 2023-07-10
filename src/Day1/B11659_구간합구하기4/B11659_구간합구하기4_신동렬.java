package Day1.B11659_구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11659 {
    public static void main(String[] args) throws IOException {
//        //입력받기- BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//system.in: 외부입력
        String str = reader.readLine();// 다음줄을 하나의 문자열로 읽어와서 str에 저장
        String[] strs = str.split(" "); //인자안에다가 쪼개는 기준을 넣어줌. 문자열인 str을 스페이스를 기준으로 쪼개서 스트링 배열에 넣어줌
        //ex Stirng s= "2023-07-03"; S.split('-'); =>  ['2023','07','03']
        int a = Integer.parseInt(strs[0]);// a=5
        int b = Integer.parseInt(strs[1]);//b=3

        str = reader.readLine();//5 4 3 2 1
        String[] strs2 = str.split(" ");//['5','4','3','2','1']
        int[] arr = new int[a];//[0,0,0,0,0]
        int [] result=new int[b];

        for (int i = 0; i < strs2.length; i++) {
            arr[i] = Integer.parseInt(strs2[i]);//[5,4,3,2,1]
        }


        for (int j=0; j<b; j++){
            str = reader.readLine();
            String[] strs3 = str.split(" ");

            int c = Integer.parseInt(strs3[0]);
            int d = Integer.parseInt(strs3[1]);
            for (int i=c-1; i<d;i++){
                result[j]+=arr[i];
            }

        }
        for (int i=0; i<b; i++)    {
            System.out.println(result[i]);
        }}}
