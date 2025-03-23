import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int max = Math.max(a,b);
        int min = Math.min(a,b);
        System.out.println(max==min? 0 : max-min - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = min+1; i < max; i++) {
            sb.append(i);
            if(i != max-1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}