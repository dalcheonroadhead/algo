import java.io.*;
import java.util.*;

public class Main {

    /*
    * b2905 홍준이와 울타리
    * 1. 슬라이딩 윈도우 초기값 세팅 (0~X 사이 최소값을 deque 맨 위로)
    *
    * 2. 슬라이딩 윈도우를 움직이며 신규 값 삽입으로 구간 내 최소값이 갱신되었을 경우,
    *       이전 안 칠 한 곳부터 i-1(직전)위치까지 이전 최소 높이로 칠하기
    *
    * 3. 슬라이딩 윈도우를 움직이며, 최소값이 구간을 벗어나면서 최소값이 갱신되었을 경우,
    *       이전 안 칠 한 곳부터, 구간에 벗어난 해당 값까지 최소 높이로 칠하기
    *
    * 4. 최소높이가 구간을 여러번 움직임에도 갱신되지 않는 경우에 대한 예외처리
    *       (n=12, x=4, 3333 3333 3333) -> 갱신안된 길이/x + 1 = 롤러질 한 횟수
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int [] values = new int [N+1];
        ArrayDeque<Fence> adq = new ArrayDeque<>(); // 슬라이딩 윈도우 -> 현재 롤러가 움직일 구간
        long area = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
            area += values[i];
        }

        // 1. 초기 세팅 -> 슬라이딩 윈도우 구간내 값들 중 유효한 값을 오름차순으로 유지
        //                  (유효한 값 = 구간 내 최소높이가 될 가능성이 있는 값)
        for (int i = 0; i < X; i++) {
            Fence now = new Fence(i, values[i]);
            while (!adq.isEmpty() && adq.peekLast().v > now.v) adq.pollLast();
            adq.add(now);
        }
//        for(Fence temp : adq){
//            System.out.print(temp.v+" ");
//        }
//        System.out.println();

        // 2. 계산
        int recent_height = adq.peek().v;  // 마지막으로 울타리 칠한 후, 갱신한 큐 내 최소높이
        int roller_cnt = 0;     // 롤러질한 횟수
        int idx = 0;            // 마지막으로 울타리 칠한 후, 갱신한 안 칠한 부분의 시작점

        for (int i = X; i <= N; i++) {
//            System.out.printf("계산 전--AREA: %d, ROLLER_CNT: %d recent-height: %d, idx: %d --"
//                + "현재 index: %d\n",area,roller_cnt, recent_height, idx, i);
            Fence now = new Fence(i, values[i]);
            while (!adq.isEmpty() && adq.peekLast().v > now.v) adq.pollLast();
            adq.add(now);

//            for(Fence temp : adq){
//                System.out.print(temp.v+" ");
//            }
//            System.out.println();

            if(!adq.isEmpty() && adq.peek().v != recent_height){
                roller_cnt += (i-1-idx)/X + 1;
                area -= (long) (i - idx) *recent_height;
//                System.out.printf("(2)신규 값 삽입하며 최소값 갱신 -- 빠져 나가는 값: %d \n", (i-idx)*recent_height);
                recent_height = adq.peek().v;
                idx = i;

            }

            if(!adq.isEmpty() && adq.peek().i <= i-X){
                Fence past = adq.poll();
                if(!adq.isEmpty() && adq.peek().v != past.v){
                    roller_cnt += (past.i - idx)/X + 1;
                    area -= (long) (past.i - idx + 1) * recent_height;
//                    System.out.printf("(3)최좌단 삭제하며 최소값 갱신 -- 빠져 나가는 값: %d \n", (past.i - idx + 1)*recent_height);
                    recent_height = adq.peek().v;
                    idx = past.i + 1;
                }
            }
        }
        System.out.println(area);
        System.out.println(roller_cnt);
    }
}

class Fence {
    int i;
    int v;

    public Fence(int i, int v){
        this.i = i;
        this.v = v;
    }
}
