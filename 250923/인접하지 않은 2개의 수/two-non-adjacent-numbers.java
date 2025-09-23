import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int max = 0;
        for(int i = 0; i < n; i++){
            int a = arr[i];    
            for(int j = 0; j < n; j++){
                if(j == i-1 ||  j == i || j == i+1) continue;
                int b = arr[j];
                max = Math.max(max, a+b);
            }
        }
        System.out.println(max);

    }
}