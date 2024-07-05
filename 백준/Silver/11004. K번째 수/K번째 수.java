import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 0. 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;
        int [] arr = new int [N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, N-1, K);
        System.out.println(arr[K]);

    }

    public static void quickSort(int [] arr, int start, int end, int K) {
        if(start < end) {
            int pivot = partition(arr, start, end);

            if(pivot == K) return;
            else if (K < pivot) quickSort(arr, start, pivot-1, K);
            else quickSort(arr,pivot+1, end, K);
        }
    }


    // partition: 정해진 범위 내의 pivot 값이 들어갈 위치를 알려 주는 함수
    //            pivot 값을 기준으로 좌 우로 영역이 갈라짐.
    public static int partition(int[] arr, int start, int end) {
        // 만약 범위가 1이면, 둘 간의 정렬만 하면 됨.
        if(start+1==end){
            if(arr[start] > arr[end]) swap(arr, start, end);
            return end;
        }

        int mid = (start+end)/2; // pivot의 index
        swap(arr,start,mid); //    pivot 값을 왼쪽 끝으로 밀어서, 밑에서 이루어질, pivot의 진짜 위치 찾기 계산을 헷갈리지 않게 만듦
        int pivot = arr[start];

        int i = start+1; int j = end;

        while (i <= j) {
            while (j>= start+1 && pivot < arr[j]){ // 오른쪽 값이 기준 값보다 크면 내버려 두고 다음으로 넘어감
                j--;
            }

            while (i<=end&&pivot>arr[i]) { // 왼쪽 값이 기준 값보다 작을 경우, 그대로 두고 다음으로 넘어간다.
                i++;
            }
            if(i <= j){ // 둘 다 멈춰 있는데, 아직 서로 안 만난 경우, 왼쪽 값은 기준 값보다 크고, 오른쪽 값은 기준 값보다 작은 것임. 따라서 서로 swap
                swap(arr,i++,j--);
            }
        }
        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}