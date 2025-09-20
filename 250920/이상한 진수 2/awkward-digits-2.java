import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        char [] nums = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        boolean isValid = false;
        for(int i = 0; i < nums.length; i++){
            if(!isValid && nums[i] != '1') {
                nums[i] = '1';
                isValid = true;
            }
            if(!isValid && i == nums.length-1){
                nums[nums.length-1] = '0';
            }
            if(nums[i] == '1') ans += pow(1, nums.length-1-i);
        }
        System.out.println(ans);
    }

    public static int pow(int num, int exp){
        while(exp > 0){
            num *= 2;
            exp--;
        }
        return num;
    }
}