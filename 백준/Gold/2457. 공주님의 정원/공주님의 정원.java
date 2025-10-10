import java.util.*;
import java.io.*;

// 2457 공주님의 정원
public class Main {
    static class Flower {
        int start;
        int end;

        public Flower (int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString(){
            return String.format("start: %d, end: %d", start, end);
        }
    }
    static int N;
    static Flower [] flowers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        flowers = new Flower[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            flowers[i] = new Flower((sm*100)+sd, em*100+ed);
        }
        Arrays.sort(flowers, (o1,o2) -> {
            if(o1.start == o2.start) return o2.end - o1.end;
            return o1.start - o2.start;
        });

        int startDay = 301; // 필수적으로 포함해야하는 개화 시작일
        int endDay = 1201;  // 필수적으로 포함해야하는 개화 종료일 + 1
        int idx = 0;        // 지금 보고 있는 꽃의 idx -> Iterator
        int max = 0;        // 필수 개화시작일을 담고 있는 값들 중 가장 늦게 지는 꽃의 낙화일
        int answer = 0;

        while(startDay < endDay){
            boolean isFind = false;
            for(int i = idx; i < flowers.length; i++){
                if(flowers[i].start > startDay) break;
                else if(flowers[i].end > max) {
                    isFind = true;
                    idx = i+1;
                    max = flowers[i].end;
                }
            }
            if(!isFind) break;
            startDay = max;
            answer++;
        }
        if (startDay < endDay)
            System.out.println(0);
        else {
            System.out.println(answer);
        }
    }
}