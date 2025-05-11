import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int [] calendar;
    
    public static void main(String[] args) throws Exception {
        init();
        System.out.println(calculate());
    }

    public static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        calendar = new int [366];
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j = start; j <= end; j++){
                calendar[j]++;
            }
        }
    }

    public static int calculate() {
        int ans = 0;
        for(int i = 1; i < 366; i++){
            if(calendar[i] > 0) {

                int maxHeight = 0;
                int j = i;

                while( j <366 && calendar[j] > 0) {
                    maxHeight = Math.max(maxHeight, calendar[j]);
                    j++;
                }
                ans += (j - i) * maxHeight;
                i = j;
            }
        }
        return ans;
    }
}