import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int [] arr;

    static int N, M;

    static int sum = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        Combination(1, 1);

        System.out.println(max);
    }

    public  static void Combination(int start, int deepth) {

        if(deepth > 3) {
           if(sum <= M){
               max = Math.max(max, sum );
           }
            return;
        }



        for (int i = start; i <= N ; i++) {
            sum += arr[i];

            Combination(i+1, deepth+1);
            sum -= arr[i];
        }
    }
}