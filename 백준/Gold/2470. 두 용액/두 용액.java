import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    /*
    *
    * */

    public static void main(String[] args) throws IOException {
        int N;
        int [] arr;
        int [] ans = new int [2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int L = 0; int R = N-1; int min = Integer.MAX_VALUE;
        while (L < R){
            int sum = arr[L] + arr[R];
            if(Math.abs(sum) < Math.abs(min)) {
                min = sum;
                ans[0] = arr[L];
                ans[1] = arr[R];
            }

            if(sum < 0) L++;
            else R--;
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}