package Day3.B2750_선택정렬;

import java.io.*;
import java.util.*;

public class B2750_선택정렬_김철{
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=0; i<N-1; i++) {
        	int minIndex = i;
        	for(int j=i+1; j<N; j++) {
        		if(arr[j] < arr[minIndex]) {
        			minIndex = j;
        		}
        	}
        	swap(arr, minIndex, i);
        }
        
        for(int i=0; i<N; i++) {
        	bw.write(arr[i] + "\n");
        }
        bw.close();
    }
    
    static void swap(int[] arr, int i, int j) {
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
}