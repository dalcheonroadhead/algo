import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>((o1,o2) -> o2 - o1);
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        ArrayDeque<Integer> forZero = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            int now = Integer.parseInt(br.readLine());
            if(now > 0) plus.add(now);
            if(now < 0) minus.add(now);
            if(now == 0) forZero.add(now);
        }
        int acc = 0;
        while(!plus.isEmpty()){
            if(plus.size() == 1){
                acc += plus.poll();
            }else {
                int o1 = plus.poll();
                int o2 = plus.poll();
                acc += Math.max(o1+o2, o1*o2);
            }
        }

        while (!minus.isEmpty()){
            if(minus.size() == 1) {
                forZero.add(minus.poll());
            }else {
                int o1 = minus.poll();
                int o2 = minus.poll();
                acc += o1*o2;
            }
        }

        while (!forZero.isEmpty()){
            if(forZero.size() == 1){
                acc += forZero.poll();
            }else {
                int o1 = forZero.poll();
                int o2 = forZero.poll();
                acc += Math.max(o1+o2, o1*o2);
            }
        }
        System.out.println(acc);
    }
}