import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int [][] arr;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int [N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        permu(0, new int [N]);
        System.out.println(ans);
    }
    // order == (index = 치는 계란, value = 맞는 계란)
    private static void permu (int depth, int [] order){
        if(depth == N) {
            ans = Math.max(ans, calculate(order));
            return;
        }

        for(int i = 0 ; i < N; i++){
            if(depth == i) continue;
            order[depth] = i;
            permu(depth +1, order);
        }
    }

    private static int calculate (int [] order) {
        int cnt = 0;
        int [][] egg = new int [arr.length][2];

        for(int i = 0; i < arr.length; i++){
            egg[i][0] = arr[i][0];
            egg[i][1] = arr[i][1];
        }

        for(int i = 0; i < order.length; i++){
            int hitting = i;
            int hitted = order[i];
            if(egg[hitting][0] <= 0 || egg[hitted][0] <= 0) continue;

            egg[hitting][0] -= egg[hitted][1];
            egg[hitted][0] -= egg[hitting][1];

            if(egg[hitting][0] <= 0) {
                cnt++;
            }
            if(egg[hitted][0] <= 0) {
                cnt++;
            }
        }
        return cnt;
    }
}