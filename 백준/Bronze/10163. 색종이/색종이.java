import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder ans = new StringBuilder();
    static int N;
    static int [][] arr = new int [1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int j = x; j < x+w; j++) {
                for (int k = y; k < y+h; k++) {
                    arr[j][k] = i;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 0; j < 1001; j++) {
                for (int k = 0; k < 1001; k++) {
                    if(arr[j][k] == i) cnt++;
                }
            }
            ans.append(cnt).append("\n");
        }
        System.out.println(ans);
    }
}