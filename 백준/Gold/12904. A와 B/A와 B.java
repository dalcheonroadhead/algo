import java.util.*;
import java.io.*;

// 12904 A와B
public class Main {
    static boolean isValid = false;
    static StringBuilder origin = new StringBuilder();
    static StringBuilder target = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        origin.append(br.readLine());
        target.append(br.readLine());

        LOOP:
        while (true){
            switch (greedy(target)){
                case 0: {
                    System.out.println(0);
                    break LOOP;
                }
                case 1: {
                    System.out.println(1);
                    break LOOP;
                }
            }
        }
    }

    public static int greedy(StringBuilder target) {
        if(target.charAt(target.length()-1) == 'B') {
            target.deleteCharAt(target.length()-1);
            target.reverse();
        }else {
            target.deleteCharAt(target.length()-1);
        }
        if(target.toString().contentEquals(origin)) return 1;
        if(target.length() < origin.length()) return 0;
        else return 9999;
    }
}