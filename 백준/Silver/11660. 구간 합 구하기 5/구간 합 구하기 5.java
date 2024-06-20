import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] sum = new int [N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                // 1) 좌, 상 테두리 부분 계산 -> 1차원 배열 누적 합
                if(i == 1) {
                    sum[i][j] = sum[i][j-1] + Integer.parseInt(st.nextToken());
                }
                else if(j == 1) {
                   sum[i][j] = sum[i-1][j] + Integer.parseInt(st.nextToken());
                }
                // 2) 좌상단부터 현 위치 까지의 사각형 누적합 계산
                else {
                    sum[i][j] = sum[i][j-1] + sum[i-1][j]  - sum[i-1][j-1] + Integer.parseInt(st.nextToken());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            sb.append((sum[ex][ey] - sum[ex][sy-1] - sum[sx-1][ey] + sum[sx-1][sy-1])).append("\n");
        }
        System.out.println(sb);
    }
}