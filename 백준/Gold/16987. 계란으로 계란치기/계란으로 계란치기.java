import java.util.*;
import java.io.*;

public class Main {

    static class Egg {
        int hp;
        int w;

        public Egg(int hp, int w){
            this.hp = hp;
            this.w = w;
        }

        @Override
        public String toString() {
            return "체력:"+ this.hp + "\t 무게: " + this.w;
        }
    }
    static int N;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Egg [] eggs = new Egg[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hp = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(hp, weight);
        }

        recur(0, eggs, 0);
        System.out.println(ans);
    }

    public static void recur (int depth, Egg [] eggs, int cnt){
        ans = Math.max(ans,cnt);
        if(depth == N) {
            return;
        }
        // 이미 깨진 계란이면 다음 계란으로 넘어간다.
        if(eggs[depth].hp <= 0) {
            recur(depth+1, eggs, cnt);
            return;
        }
        for(int i = 0; i < N; i++){
            if(i == depth) continue;
            if(eggs[i].hp <= 0) continue;

            int new_cnt = cnt;
            eggs[i].hp -= eggs[depth].w;
            eggs[depth].hp -= eggs[i].w;

            if(eggs[i].hp <= 0) new_cnt++;
            if(eggs[depth].hp <= 0) new_cnt++;

            recur(depth+1, eggs, new_cnt);
            eggs[i].hp += eggs[depth].w;
            eggs[depth].hp += eggs[i].w;
        }
    }
}