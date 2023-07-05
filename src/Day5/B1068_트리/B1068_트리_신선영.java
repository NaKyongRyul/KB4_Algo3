package day5;

import java.util.ArrayList;
import java.util.Scanner;

public class B1068_트리_신선영 {
    static int[] tree;
    static ArrayList<Integer> deleted;

    static void delete(int d) { // 지울 노드의 시작 번호
        deleted.add(d);

        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == d) {
                delete(i);
            }
        }
    }

    static void check(int a) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 노드의 개수
        tree = new int[N];
        deleted = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
        }

        int D = sc.nextInt();

        // 시작 노드 아래로 지워지는 값 모두 저장
        delete(D);

        // 남은 노드 중에서 리프 노드만 세기 (자식이 없어야 함)
        int ans = 0;
        for (int i = 0; i < N; i++) {
            boolean tf = true;
            if (!deleted.contains(i)) {
                for (int j = 0; j < N; j++) {
                    if (!deleted.contains(j) && tree[j] == i) {
                        tf = false;
                    }
                }
                if (tf) {
                    ans++;
                }
            }

        }

        System.out.println(ans);
    }
}
