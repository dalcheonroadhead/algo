import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, T, P;
    static ArrayList<Integer> t_shirts = new ArrayList<>();
    static int t_ans, p_share, p_remainder;
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            t_shirts.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        // 2. 계산 하기
        for (Integer tShirt : t_shirts) {
            if(tShirt-1 == -1) continue;
            t_ans += ((tShirt - 1 ) / T) + 1;
        }
        p_share = N/P;
        p_remainder = N%P;
        System.out.println(t_ans);
        System.out.println(p_share + " " + p_remainder);
    }
}