import java.io.*;
import java.util.*;


public class Main {
    static char [] num;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        input();
        dfs(num, 0);
        System.out.printf("%d %d", min, max);
    }

    public static void dfs(char [] now, int cnt) {
        for (char c : now) {
            if ((c - '0') % 2 != 0)
                cnt++;
        }

        if(now.length == 1){
            max = Math.max(cnt, max);
            min = Math.min(cnt, min);
        }else if (now.length == 2){
            int newNum = (now[0]-'0') + (now[1] -'0');
            char [] next = String.valueOf(newNum).toCharArray();
            dfs(next, cnt);
        }else {
            for(int i = 0; i < now.length-1; i++){
                for (int j = i+1; j < now.length; j++) {
                    if(j+1 == now.length) continue;
                    int a = Integer.parseInt(String.valueOf(now).substring(0, i+1));
                    int b = Integer.parseInt(String.valueOf(now).substring(i+1,j+1));
                    int c = Integer.parseInt(String.valueOf(now).substring(j+1,now.length));
                    char [] next = String.valueOf((a+b+c)).toCharArray();
                    dfs(next, cnt);
                }
            }
        }
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = br.readLine().toCharArray();
    }
}