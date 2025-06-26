import java.util.*;
import java.io.*;

public class Main {

    static boolean [] check;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder ans = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] ch = br.readLine().toCharArray();
        check = new boolean[ch.length];
        recur(ch, 0, ch.length-1);
        System.out.println(ans);
    }

    public static void recur(char [] ch, int left, int right){
        if(left > right) return;

        // calculate
        int pos = left;
        char now = ch[left];

        for(int i = left; i <= right; i++){
            if(now > ch[i]){
                pos = i;
                now = ch[i];
            }
        }
        check[pos] = true;
        for(int i = 0; i < ch.length; i++){
            if(check[i]) sb.append(ch[i]);
        }
        ans.append(sb.toString()).append("\n");
        sb.setLength(0);

        // next recursive
        recur(ch, pos+1, right);
        recur(ch, left, pos-1);
        
    }
}