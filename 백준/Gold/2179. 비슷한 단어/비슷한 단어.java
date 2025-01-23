import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
    static int N;
    static String [] strings;
    static int max_cnt = 0;
    static String S, T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        strings = new String[N];
        for(int i = 0; i < N; i++){
            strings[i] = br.readLine();
        }
        combination();
        System.out.println(S);
        System.out.println(T);
    }
    public static void combination(){
        for (int i = 0; i < N-1; i++) {
            String A = strings[i];
            for (int j = i+1; j < N; j++) {
                String B = strings[j];
                if(max_cnt > B.length()) continue;
                int now_cnt =same_cnt(A,B);
                if(max_cnt < now_cnt){
                    max_cnt = now_cnt;
                    S = A;
                    T = B;
                }
            }
        }
    }

    public static int same_cnt (String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if(c1 != c2) break;
            cnt++;
        }
        return cnt;
    }
}
