import java.util.*;
import java.io.*;

public class Main {
    // 포지션 별로 멤버 넣기 (멤버가 해당 포지션에서 능력치가 0이면 원래 재귀로 복귀 - 백 트래킹)
    // 다 넣으면 계산해서 최대값 갱신

    static int [][] map; // 행 = 선수, 열 = 포지션
    static int [] position;
    static boolean [] check;
    static int max;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int t = 0; t < TC; t++){
            max = 0;
            map = new int[11][11];
            position = new int [11];
            check = new boolean [11];
            for(int i = 0; i < 11; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 11; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            permu(0);
            System.out.println(max);
        }
    }

    public static void permu (int depth) {
        if(depth == 11) {
            int sum = 0;
            for(int i = 0; i < 11; i++){
                sum += position[i];
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 11; i++){
            if(check[i]) continue;
            if(map[depth][i] == 0) continue;
            check[i] = true;
            position[depth] = map[depth][i];
            permu(depth+1);
            check[i] = false;
        }
    }
}