import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int M;
    static int [] budget;

    public static void main(String[] args) throws IOException {
        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        budget = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            sum += budget[i];
        }
        Arrays.sort(budget);
        M = Integer.parseInt(br.readLine());
        if(sum < M) {
            System.out.println(budget[budget.length-1]);
            return;
        }
        System.out.println(binary_search());
    }

    public static int binary_search() {
        int start = 1;
        int end = budget[budget.length-1];

        while (start <= end){
            int mid = start + (end - start)/2;
            if(f(mid)) start = mid + 1;
            else end = mid -1;
        }
        return start - 1;
    }

    public static boolean f(int mid){
        int sum = 0;
        for (int j : budget) {
            sum += Math.min(j, mid);
        }
        return sum <= M;
    }
}