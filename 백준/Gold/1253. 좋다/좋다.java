import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int E = 0; E < N; E++) {
            int target = arr[E];
            int L = 0; int R = arr.length-1;
            while (L < R) {
                if(L == E) { L++; continue;}
                if(R == E) { R--; continue;}

                int now = arr[L] + arr[R];
                if(now == target) { ans++; break;}
                else if (now < target) L++;
                else R--;
            }
        }
        System.out.println(ans);
    }
}