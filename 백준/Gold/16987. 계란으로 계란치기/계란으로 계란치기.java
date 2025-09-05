import java.util.*;
import java.io.*;

// 백준 16987 계란으로 계란치기
// 계란의 개수가 최대 8개밖에 되지 않으므로 그냥 무식하게 완탐 돌리면 풀릴 것 같다.
public class Main {
    static class Egg {
        int d;
        int w;

        public Egg (int d, int w) {
            this.d = d;
            this.w = w;
        }

        @Override
        public String toString(){
            return String.format("duration: %d, weight: %d", this.d, this.w);
        }
    }

    static int N;
    static Egg [] eggs;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg [N];
        for (int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int duration = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(duration, weight);
        }
        recur(0, 0);
        System.out.println(answer);
    }
    // BACK-TRACKING
    public static void recur (int index , int cnt) {
        answer = Math.max(answer, cnt);
        // 손에 쥐려는 게 깨져있다.
        if(index == N) return;
        if(eggs[index].d <= 0) {
            recur(index+1, cnt);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(index == i) continue; // 같은 거 깰 때 넘어가기
            if(eggs[i].d <= 0) continue; // 깨려는 대상이 이미 깨져 있으면 넘어가기

            int new_cnt = cnt;
            eggs[index].d -= eggs[i].w;
            eggs[i].d -= eggs[index].w;

            if(eggs[index].d <= 0) new_cnt++;
            if(eggs[i].d <= 0) new_cnt++;
            recur(index+1, new_cnt);

            eggs[index].d += eggs[i].w;
            eggs[i].d += eggs[index].w;
        }
    }
}