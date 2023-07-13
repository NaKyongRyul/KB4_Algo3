package Day4.B2750_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_병합정렬_신동렬 {

        static int N;

        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(bf.readLine());
            int arr[]= new int[N];
            for(int i =0; i<N; i++){
                arr[i]=Integer.parseInt(bf.readLine());

            }
            mergeSort(arr,0,N-1);
            for(int i=0; i<N; i++){
                System.out.println(arr[i]);}
        }

        private static void mergeSort(int[] arr, int l, int r) {
            int m;
            if(l<r) {
                m=(l+r)/2;
                mergeSort(arr,l,m);
                mergeSort(arr,m+1,r);
                merge(arr,l,m,r);
            }
        }

        private static void merge(int[] arr, int l, int m, int r) {
            int i, j, k;
            int b[]=new int[N];

            for(i=l;i<=r; i++){
                b[i]=arr[i];
            }
            i=l;j=m+1; k=l;

            while(i<=m && j<=r){
                if(b[i]<=b[j])
                {arr[k++]=b[i++];
                }else arr[k++]=b[j++];
            }

            if(i>m)
                while (j<=r)arr[k++]=b[j++];
            else
                while (i<=m)arr[k++]=b[i++];

        }
    }


