import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

    static int [] volume = new int [3];
    static HashSet<Bottle3> set = new HashSet<>();
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        back_tracking(2, 0, new int []{0,0,volume[2]});
        back_tracking(2, 1, new int []{0,0,volume[2]});
        Collections.sort(ans);
        for (int answer : ans) {
            System.out.print(answer + " ");
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        volume[0] = Integer.parseInt(st.nextToken());
        volume[1] = Integer.parseInt(st.nextToken());
        volume[2] = Integer.parseInt(st.nextToken());
    }

    public static void back_tracking(int from, int to, int [] arr) {
        // 계산 조건
        int origin_from = arr[from];
        arr[from] = (volume[to] - arr[to]) - arr[from] >= 0 ? 0 : arr[from] - (volume[to] - arr[to]);
        arr[to] = (volume[to] - arr[to]) - origin_from >= 0 ? arr[to] + origin_from : volume[to];
        Bottle3 now = new Bottle3(arr[0], arr[1], arr[2]);
        if(set.contains(now)) return;
        else {
            if(arr[0] == 0)ans.add(arr[2]);
            set.add(now);
        }


        for(int i = 0; i < 3; i++){
            if(arr[i] > 0) {
                for (int j = 0; j < 3; j++) {
                    if(i != j && (i != from && j != to)){
                        back_tracking(i, j, new int []{arr[0], arr[1], arr[2]});
                    }
                }
            }
        }
    }
}

class Bottle3 {
    int A;
    int B;
    int C;

    public Bottle3 (int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
    @Override
    public boolean equals (Object obj) {
        if(obj.getClass()!= Bottle3.class) return false;

        return ((Bottle3) obj).A == this.A
                && ((Bottle3) obj).B == this.B
                && ((Bottle3) obj).C == this.C;
    }

    @Override
    public int hashCode() {
        return this.A + this.B + this.C;
    }
}