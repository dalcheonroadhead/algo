import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<Th> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        // 입력 받기
        int t_cnt;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t_cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < t_cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Th(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        System.out.println(binary_search());
    }

    public static int binary_search() {
        int start = 0;
        int end = 2000000000;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if(isOk(mid)) start = mid + 1;
            else end = mid - 1;
        }
        return start - 1;
    }

    public static boolean isOk(int distance) {
        ArrayList<Integer> knots = new ArrayList<>();
        knots.add(list.get(0).s);
        for (int i = 1; i < list.size(); i++) {
           Th now_Th = list.get(i);
           int now_knot = now_Th.s;
           int prev_knot = knots.get(i-1);

           if(now_knot - prev_knot < distance){
               now_knot = prev_knot + distance;
               if(now_knot > now_Th.e){
//                   System.out.println(now_Th + " " + prev_knot + " " + now_knot);
                   return false;
               }
           }
           knots.add(now_knot);
        }
        return true;
    }
}

class Th implements Comparable<Th> {
    int s;
    int e;

    public Th (int s, int l) {
        this.s = s;
        this.e = s + l;
    }

    @Override
    public int compareTo(Th o) {
        return this.s - o.s;
    }

    @Override
    public String toString() {
        return "s=" + s + " e=" + e;
    }
}