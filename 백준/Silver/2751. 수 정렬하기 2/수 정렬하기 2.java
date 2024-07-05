import java.io.*;


public class Main {
    static int N;
    static int [] arr;
    static int [] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int [N];
        temp = new int [N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        merge_sort(0, N-1);

       StringBuilder sb = new StringBuilder();
       for (int temp : arr){
           sb.append(temp).append("\n");
       }
        System.out.println(sb);
    }

    public static void merge_sort(int start, int end){
        // 0. 기저 조건
        if(end - start == 0) return;
        // 1. 계산
        int mid = (start+end)/2;
        // 분할 정복
        merge_sort(start, mid);
        merge_sort(mid+1, end);
        // 현재까지의 정렬 상태를 temp 값에 담기
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        // 3가지 포인터를 이용한 병합 정렬
        int O = start;
        int i = start;
        int j = mid+1;

        // 포인터로 넣기
        while (i <= mid && j <= end){
            if(temp[i] < temp[j]){
                arr[O] = temp[i];
                i++;
            }else{
                arr[O] = temp[j];
                j++;
            }
            O++;
        }

        if(i <= mid){
            for (int k = i; k <= mid; k++) {
                arr[O++] = temp[k];
            }
        }
        if(j <= end) {
            for (int k = j; k <= end; k++) {
                arr[O++] = temp[k];
            }
        }
    }
}