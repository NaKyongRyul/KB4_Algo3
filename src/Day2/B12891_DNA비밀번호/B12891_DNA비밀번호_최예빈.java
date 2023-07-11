package com.itskb.codingtest.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_최예빈 {

    static int S, P;
    static char[] dna;
    static int[] acgt, used;
    static int dnaLen, low, high, remain, count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());

        acgt = new int[4];
        for (int i = 0; i < 4; i++) {
            acgt[i] = Integer.parseInt(st.nextToken());
        }

        used = acgt.clone();
        dnaLen = dna.length;
        low = 0;
        high = P - 1;

        for (int i = low; i < high; i++) {
            switch (dna[i]) {
                case 'A':
                    used[0]--;
                    break;
                case 'C':
                    used[1]--;
                    break;
                case 'G':
                    used[2]--;
                    break;
                default:
                    used[3]--;
                    break;
            }
        }

        while (high < dnaLen) {
            switch (dna[high]) {
                case 'A':
                    used[0]--;
                    break;
                case 'C':
                    used[1]--;
                    break;
                case 'G':
                    used[2]--;
                    break;
                case 'T':
                    used[3]--;
                    break;
            }

            boolean allUnder0 = true;

            for (int i = 0; i < 4; i++) {
                if (used[i] > 0) {
                    allUnder0 = false;
                    break;
                }
            }

            if (allUnder0) count++;

            switch (dna[low++]) {
                case 'A':
                    used[0]++;
                    break;
                case 'C':
                    used[1]++;
                    break;
                case 'G':
                    used[2]++;
                    break;
                case 'T':
                    used[3]++;
                    break;
            }

            high++;
        }

        System.out.println(count);
    }
}
