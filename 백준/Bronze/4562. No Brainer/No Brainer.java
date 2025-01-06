import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int eats = Integer.parseInt(st.nextToken());
            int require = Integer.parseInt(st.nextToken());

            if(eats >= require) ans.append("MMM BRAINS").append("\n");
            else ans.append("NO BRAINS").append("\n");
        }

        System.out.println(ans);
    }
}