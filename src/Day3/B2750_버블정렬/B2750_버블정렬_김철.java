package Day3.B2750_버블정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2750_버블정렬_김철 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=1; i<N; i++){
            for(int j=1; j<N-i+1; j++){
                if(arr[j] > arr[j+1]) swap(arr, j, j+1);
            }
            
        }
        for(int i=1; i<=N; i++){
            bw.write(arr[i] + "\n");
        }
        
        bw.close();
    }
    
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
