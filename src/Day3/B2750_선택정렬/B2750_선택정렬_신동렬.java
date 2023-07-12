package Day3.B2750_선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_선택정렬_신동렬 {

        static int N;
        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(bf.readLine());
            int arr[]= new int[N];
            for(int i =0; i<N; i++){
                arr[i]=Integer.parseInt(bf.readLine());

            }
            SelectionSort(arr);
            for(int i=0; i<N; i++){
                System.out.println(arr[i]);}
        }

        private static void SelectionSort(int[] arr) {
            for (int i=0; i<N-1; i++){
                int minidx=i;
                for (int j= i+1; j<N;j++){
                    if (arr[j] <arr[minidx]) minidx=j;
                }
                swap(arr, minidx,i);
            }
        }
        public static void swap (int [] arr,int i, int j){
            int tmp= arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
        }

    }

}
