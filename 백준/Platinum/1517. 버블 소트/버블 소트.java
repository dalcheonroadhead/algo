import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static long cnt = 0;
    static Node [] arr;
    static Node [] tmp;
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Node [N];
        tmp = new Node [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }
        // 2. 계산
        merge_sort(0, N-1);
        System.out.println(cnt);
    }

    public static void merge_sort(int start, int end){
        // 0. 기저 조건
        if(end - start == 0) return;
        // 1. 분할 정복
        int mid = (start + end)/2;
        merge_sort(start, mid);
        merge_sort(mid+1, end);
        // 2. 계산 (투 포인터 활용)
        int s = start;
        int m = mid + 1;
        int k = start;

        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        while (s <= mid && m <= end) {
           if(tmp[s].v <= tmp[m].v){
               arr[k] = tmp[s++];
           }else {
               arr[k] = tmp[m++];
           }
           if(k > arr[k].o_idx) cnt += (k - arr[k].o_idx);
           arr[k].o_idx = k;
           k++;
        }

        if(s<=mid){
            for (int i = s; i <= mid ; i++) {
                arr[k] = tmp[i];
                if(k> arr[k].o_idx) cnt += (k - arr[k].o_idx);
                arr[k].o_idx = k;
                k++;
            }
        }

        if(m<=end){
            for (int i = m; i <= end ; i++) {
                arr[k] = tmp[i];
                if(k> arr[k].o_idx) cnt += (k - arr[k].o_idx);
                arr[k].o_idx = k;
                k++;
            }
        }
    }
}

class Node {
    long o_idx;
    int v;

    public Node (long o_idx, int v){
        this.o_idx = o_idx;
        this.v = v;
    }
}