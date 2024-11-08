import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        if(pq.size() == 1) {
            System.out.println(0);
            return;
        }
        int prev = pq.poll()+ pq.poll();
        pq.offer(prev);
        int acc = prev;
        while (pq.size() >= 2){
            int A = pq.poll();
            int B = pq.poll();
            int plus = A + B;
            acc += plus;
            pq.offer(plus);
        }
        System.out.println(acc);
    }
}