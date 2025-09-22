import java.util.Scanner;
public class Main {
    static int n;
    static int [] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, calculate(i));
        }
        System.out.println(ans);
    }

    public static int calculate (int start){

        int sum = 0;

        int [] order = new int [n+1];
        int idx = start + 1;
        int cnt = 1;
        while(cnt < n){
            idx = (idx == n)? 0 : idx;
            order[idx++] = cnt++;
        }


        for(int i = 0; i < n; i++){
            sum += order[i]*arr[i];
        }

        return sum;
    }
}