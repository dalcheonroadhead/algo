import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N, C; // 각각 집의 개수,공유기 개수
    static int [] homes; // 집의 좌표들

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        homes = new int [N];
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);
        System.out.println(binary_search());
    }

    public static int binary_search(){
        int start = 0;
        int end = 1000000001;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if(f(mid)) start = mid + 1;
            else end = mid - 1;
        }
        return start - 1;
    }
    
    public static boolean f(int d) {
        int router_cnt = C - 1;
        int prev_router_loc = homes[0];
        for (int i = 1; i < N; i++) {
            if(homes[i] - prev_router_loc < d) continue;
            prev_router_loc = homes[i];
            router_cnt--;

            if(router_cnt == 0) {
                return true;
            }
        }
        return false;
    }
}