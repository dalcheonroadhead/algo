import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    /*
    * 2003 - 수들의 합
    * 방법 - 단방향 투 포인터 활용
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] arr = new int [N+1];
        int ans = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0; int R = 0; int sum = 0;
        while (L <= N && R <= N){
            if(sum < M) {
                R++;
                if(R <= N) sum += arr[R];
            }else{
                if(sum == M) ans++;
                L++;
                if(L <= N) sum -= arr[L];
            }
        }
        System.out.println(ans);
    }
}