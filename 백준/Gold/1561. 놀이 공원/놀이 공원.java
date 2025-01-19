import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static long minimum_time, remained_kid;
    static int [] rides;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        rides = new int [M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            rides[i] = Integer.parseInt(st.nextToken());
        }

        if(M >= N) {    // 놀이기구보다 사람수가 적거나 같을 경우, 사람의 순번이 곧 타는 놀이기구
            System.out.println(N);
            return;
        }
        N -= M;
        minimum_time = binary_search();
        remained_kid = N - before_minimum_time_kiddo_cnt(minimum_time);
        System.out.println(last_rides_num(remained_kid));
    }
    // N명의 아이를 모두 태울 수 있는 최소 시간 찾기
    public static long binary_search() {
        long start  = 0;
        long end    = 30 * (long)Integer.MAX_VALUE;
        while (start <= end) {
            long mid = (start + (end - start)/2);
            if(f(mid)) end = mid -1;
            else start = mid + 1;
        }
        return start;
    }
    // N명을 모두 태울 수 있으면 true, 아니면 false;
    public static boolean f(long time) {
        long kids = 0;
        for (int i = 0; i < M; i++) {
            kids += time/rides[i];
        }
        return N <= kids;
    }

    public static long before_minimum_time_kiddo_cnt( long minimum_time){
        long kids = 0;
        for (int i = 0; i < M; i++) {
            kids += (minimum_time-1)/rides[i];
        }
        return kids;
    }

    public static int last_rides_num(long kids_cnt) {
        for (int i = 0; i < M; i++) {
            if(minimum_time%rides[i] == 0) kids_cnt--;
            if(kids_cnt == 0) return i+1;
        }
        return -1;
    }
}
