import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int G = GCD(A,B);
            int a = A/G;
            int b = B/G;
            System.out.println((G*a*b));
        }
    }

    public static int GCD(int A, int B) {
        int R = A%B;
        while (R != 0){
            A = B;
            B = R;
            R = A%B;
        }
        return B;
    }
}
