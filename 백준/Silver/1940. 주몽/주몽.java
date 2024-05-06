import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 1940번 주몽
 * */


public class Main {

    static int N, M;
    static int [] arr;
    static int [] target = new int [2];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 값 받기
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combination(0,0);
        System.out.println(cnt);
    }

    public static void combination (int depth, int start) {
        if(depth == 2){

            int ans = 0;
            for (int i = 0; i < target.length; i++) {
                ans +=target[i];
            }
            if(ans == M) {
                cnt ++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
           target[depth] = arr[i];
           combination(depth+1, i+1);
        }
    }
}