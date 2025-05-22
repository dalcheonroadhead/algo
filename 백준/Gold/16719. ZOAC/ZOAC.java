import java.util.*;
import java.io.*;

public class Main {
    static String str;
    static boolean [] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        isVisited = new boolean[str.length()];
        zoac(0, str.length()-1);
    }

    public static void zoac(int left, int right) {
        // base-case
        if(left > right) return;
        
        int idx = left;
        for(int i = left; i <= right; i++){
            if(isVisited[i]) continue;
            if(str.charAt(i) < str.charAt(idx)) idx = i;
        }
        isVisited[idx] = true;

        for(int i = 0; i < str.length(); i++){
            if(isVisited[i]) System.out.print(str.charAt(i));
        }
        System.out.println();

        zoac(idx+1, right);
        zoac(left, idx-1);
        
    }
}