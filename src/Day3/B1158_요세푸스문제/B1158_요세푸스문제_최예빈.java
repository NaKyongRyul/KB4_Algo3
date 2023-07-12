package com.itskb.codingtest.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1158_요세푸스문제_최예빈 {

    static int N, K;
    static int index, arrSize;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            arr.add(i + 1);
        }

        index = 0;
        arrSize = N;

        StringBuilder sb = new StringBuilder("<");
        while (arrSize > 0) {
            index += K - 1;
            if (index >= arrSize) index %= arrSize;
            sb.append(arr.remove(index)).append(",").append(" ");
            arrSize--;
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(">");

        System.out.println(sb);
    }
}
