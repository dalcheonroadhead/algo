import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        System.out.println(factorial(Long.parseLong(br.readLine())));
    }

    public static long factorial (long start){

        if(start == 0){
            return 1;
        }

        if(start == 1){
            return 1;
        }
        return start * factorial(start -1);
    }
}