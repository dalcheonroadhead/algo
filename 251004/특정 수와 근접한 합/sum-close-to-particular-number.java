import java.util.*;

public class Main {
    static int n, s;
    static int [] arr;
    static int answer  = -99999;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        combination(0,0,new int[2]);
        System.out.println(Math.abs(s-answer));
    }

    public static void combination(int start, int depth, int [] member) {
        if(depth == 2) {
            int sum = 0; 
            for(int i = 0 ; i < n ; i++){
                if(i == member[0] || i == member[1]) continue;
                sum += arr[i];
            }
            if(Math.abs(sum - s) < Math.abs(answer - s)) answer = sum;
            return;
        }

        for(int i = start; i < n; i++){
            member[depth] = i;
            combination(i+1, depth+1, member);
        }
    }
}