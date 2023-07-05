package Day3.B2750_삽입정렬;

import java.util.ArrayList;
import java.util.Scanner;

public class B2750_삽입정렬_김준서 {
    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            ans.add(sc.nextInt());
        }
        for (int i = 1; i < N; i++) {
            int temp=ans.remove(i);
            for (int j = 0; j < i; j++) {
                if (temp<ans.get(j)){
                    ans.add(j , temp);
                    break;
                }
                if (j == i - 1) {
                    ans.add(j+1, temp);
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(ans.get(i));
        }
    }
}
