import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int [] arr = new int [N];
        int max = 0;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }


        System.out.println(binary_search(arr, max, sum, M));
    }
    public static int binary_search(int [] arr,int S, int E, int M) {
        int start   = S;
        int end     = E;

        while (start <= end) {
            int mid = (start + end)/2;
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                sum +=arr[i];
                if(sum == mid) {cnt++; sum = 0;}
                else if(sum > mid) {cnt++; sum = arr[i];}
            }
            if(sum != 0) cnt++; // 딱 맞아떨어지지 않았으면, 마지막 강의만 가지고 블루레이 하나 더 써서 강의 찍어야함.
            // 블루레이 자르려는 목표보다 잘게 잘랐다. -> mid의 크기가 충분하지 않다. 크기 올리기
            if(cnt > M) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return  start;
    }
}