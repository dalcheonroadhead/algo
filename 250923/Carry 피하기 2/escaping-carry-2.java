import java.util.*;
public class Main {
    static int n;
    static int [] arr;
    static int max = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        combination(0,0,new int [3]);
        System.out.println(max);
    }

    public static void combination (int start, int depth, int [] boat) {
        if(depth == 3) {
            int sum = boat[0] + boat[1];
            if(isCarry(boat[0], boat[1])) return;    
            if(isCarry(sum, boat[2])) return;
            sum += boat[2];
            max = Math.max(max, sum);
            return;
        }

        for (int i = start; i < n; i++){
            boat[depth] = arr[i];
            combination(i+1, depth+1, boat);
        }
    }

    public static boolean isCarry(int one, int another){
        char [] o = String.valueOf(one).toCharArray();
        char [] a = String.valueOf(another).toCharArray();
        int o_i = o.length - 1;
        int a_i = a.length - 1;
        while(o_i >= 0 && a_i >= 0){
            if((o[o_i]-'0') + (a[a_i] - '0') >= 10) return true;
            o_i--;
            a_i--;    
        }
        return false;
    }
}