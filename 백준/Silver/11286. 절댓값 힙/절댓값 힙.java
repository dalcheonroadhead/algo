import java.io.*;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {    // return 결과가 양수면 자리 바꾸고, 음수면 자리 안 바꿈.
                if(Math.abs(o1) == Math.abs(o2)) return Integer.compare(o1,o2);
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        for (int i = 0; i < N; i++) {

            int order = Integer.parseInt(br.readLine());

            if(order == 0){
                int ans;
                if(pq.isEmpty()){
                    ans = 0;
                }else {
                    ans = pq.poll();
                }
                sb.append(ans).append("\n");
            }else {
                pq.add(order);
            }
        }

        System.out.println(sb);
    }
}