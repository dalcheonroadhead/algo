import java.util.*;
import java.io.*;

public class Main {
    static int n, m, r;
    static int [][] map;
    static int [][] dir = new int [][]{{0,1}, {1,0}, {0, -1}, {-1,0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int [n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < r; i ++){
            rotate();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rotate() {
        int depth = Math.min(n, m)/2;

        for(int i = 0; i < depth; i++){
            int start = map[i][i];

            // 우 -> 좌 이동 (상단)
            for(int j = i + 1; j < m - i; j++){
                map[i][j-1] = map[i][j];
            }
            // 밑에서 위 (오른쪽 선)
            for(int j = i + 1; j < n-i; j++){
                map[j-1][m-i-1] = map[j][m-i-1];
            }
            // 좌 -> 우 (하단)
            for(int j = m-i-1; j > i; j--){
                map[n-i-1][j] = map[n-i-1][j-1];
            }
            // 위에서 밑 (왼쪽 선) 우상단의 최초의 값은 이미 갱신되었음으로 계산에서 빼준다.
            for(int j = n-i-1; j > i+1; j --){
                map[j][i] = map[j-1][i];
            }

            map[i+1][i] = start;
        }
    }
}