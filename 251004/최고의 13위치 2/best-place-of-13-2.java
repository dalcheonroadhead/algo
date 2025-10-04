import java.util.*;

public class Main {
    static int [][] acc;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        acc = new int [n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        // Please write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-2; j++){
                acc[i][j] = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                list.add(acc[i][j]);
            }
        }
        Collections.sort(list);
        System.out.println((list.get(list.size()-1) + list.get(list.size()-2)));
    }
}