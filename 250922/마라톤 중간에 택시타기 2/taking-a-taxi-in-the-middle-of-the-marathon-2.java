import java.util.*;

public class Main {

    static int n;
    static int [] x;
    static int [] y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < n-1; i++){
            int xman = i;
            ans = Math.min(ans, exceptX(xman));
        }
        System.out.println(ans);
    }

    public static int exceptX(int xman){
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if (i == xman) continue;
            list.add(i);
        }

        for(int i = 1 ; i < list.size(); i++){
            sum += Math.abs(x[list.get(i)] - x[list.get(i-1)]) + Math.abs(y[list.get(i)] - y[list.get(i-1)]);
        }

        return sum;
    }
}