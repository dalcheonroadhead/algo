import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int [] number = new int []{9,8,7,6,5,4,3,2,1,0};
    static ArrayList<Long> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(0, 0);
        Collections.sort(list);
        System.out.println(N >= list.size()? -1 : list.get(N));
    }

    public static void dfs (int index, long acc) {
        if(index >= 10) {
            list.add(acc);
            return;
        }
        dfs(index+1, acc*10 + number[index]);
        dfs(index+1, acc);
    }
}