import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    /*
    * 1. ArrayDeque로 슬라이딩 윈도우를 구현
    * 2. 해당 윈도우안의 값은 내림차순으로 정렬, 즉 deque의 front는 최대값을 유지
    * 3. deque의 front가 슬라이딩 윈도우 구간을 벗어나는지 확인 후 조치
    * 4. 신규값과 deque의 rear를 비교
    *   - rear > 신규 : 신규 값 deque에 추가
    *   - rear < 신규 : rear를 poll() (반복)
    * 5. 매 슬라이딩 윈도우 움직임마다, deque의 front를 출력
    * */

    public static void main(String[] args) throws IOException {
        // 변수 목록
        StringBuilder ans = new StringBuilder();
        int N, M;
        int [] ad;
        int MAX_SIGHT;
        ArrayDeque<Num> sight = new ArrayDeque<>();
        // 입력 받기
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ad = new int [N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ad[i] = Integer.parseInt(st.nextToken());
        }
        MAX_SIGHT = Math.min(2*M-1, N);
        // 술라이딩 윈도우 초기 세팅
        for (int i = 0; i < MAX_SIGHT; i++) {
            if(sight.isEmpty()) sight.add(new Num(i, ad[i]));
            else {
                while (!sight.isEmpty()&& sight.peekLast().v < ad[i]){
                    sight.pollLast();
                }
                sight.add(new Num(i, ad[i]));
            }
        }
        ans.append(sight.peek().v).append(" ");
        // 예외 처리
        if(MAX_SIGHT != 2*M-1) {
            System.out.println(ans);
            return;
        }
        // 계산
        for (int i = M; i <= N-M; i++) {
            if(!sight.isEmpty()&&sight.peek().i <= i-(M)) sight.poll();
            while (!sight.isEmpty()&& sight.peekLast().v < ad[i+(M-1)]){
                sight.pollLast();
            }
            sight.add(new Num(i+(M-1),ad[i+(M-1)]));
//            System.out.printf("이번에 넣은 수의 index: %d, 이번에 넣은 수: %d\n",(i+(M-1)),ad[i+(M-1)]);
//            sight.forEach(o -> System.out.printf("%d번째, %d || ",o.i, o.v));
//            System.out.println("\n---------------------------------------");

            ans.append(sight.peek().v).append(" ");
        }


        System.out.println(ans);
    }
}

class Num {
    int i;
    int v;

    public Num(int i, int v){
        this.i = i;
        this.v = v;
    }
}