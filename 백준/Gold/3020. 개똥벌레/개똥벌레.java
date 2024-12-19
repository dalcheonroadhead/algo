import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, H;
        int [] seok;
        int [] jong;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        seok = new int [H+1];
        jong = new int [H+1];

        for (int i = 0; i < N; i++) {
            if(i%2 == 0) seok[Integer.parseInt(br.readLine())]++;
            else jong[H - Integer.parseInt(br.readLine()) + 1]++;
        }

        for (int i = H-1; i >= 0; i--) {
            seok[i] +=seok[i+1];
        }

        for (int i = 1; i < H+1; i++) {
            jong[i] += jong[i-1];
        }

        int min = N;
        int cnt = 1;
        for (int i = 1; i < H+1; i++) {
            if(min > seok[i] + jong[i]){
                min = seok[i] + jong[i];
                cnt = 1;
            }else if (min == seok[i] + jong[i]){
                cnt++;
            }
        }
        System.out.printf("%d %d", min, cnt);
    }
}
