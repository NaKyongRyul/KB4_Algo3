package Day4.B2750_퀵정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_퀵정렬_신동렬 {
        static int N;

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(bf.readLine());
            int arr[]= new int[N];
            for(int i =0; i<N; i++){
                arr[i]=Integer.parseInt(bf.readLine());

            }
            quickSort(arr,0,N-1);
            for(int i=0; i<N; i++){
                System.out.println(arr[i]);}
        }
        private static int partition(int arr[], int l, int r){

            int pivot=arr[l];
            int i=l+1;
            int j=r;
            while(true){
                while(j>=l+1 && pivot<arr[j]) j--;
                while(i<=r &&pivot>arr[i]) i++;
                if( i<=j){
                    swap(arr, i, j);
                }else break;
            }

            swap(arr,l,j);
            return j;
        }

        private static void quickSort(int[] arr,int l, int r) {

            if(l<r){
                int pivot =partition(arr,l,r);
                quickSort(arr, l,pivot-1);
                quickSort(arr,pivot+1,r);

            }
        }

        public static void swap (int [] arr,int i, int j){
            int tmp= arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
        }
    }

