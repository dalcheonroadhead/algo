import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Main {

	static int [] dwarf = new int [9];
	static boolean[] flag = new boolean[9]; 
	
	 static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 값을 입력 받는다. 
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		// 2. 부분집합의 모든 양상을 재귀를 통해 구한다. 
		hundred(0);


	}
	public static void hundred(int index) {
		//2-2 기저조건
		
		if(index == flag.length) {
			//-> 마지막에 boolean에서 true인 인덱스들의 합끼리 더한다. 
			int sum = 0;
			int cnt = 0;
			for(int i = 0 ; i< flag.length; i++) {
				if (flag[i] == true) {
					sum += dwarf[i];
					cnt++;
				}
			}
			// 만약 합이 100이면 해당 영광의 멤버들을 출력한다. 
			if(sum == 100 && cnt == 7) {
				for(int i = 0; i<flag.length; i++) {
					if(flag[i] == true) {
						System.out.println(dwarf[i]);
					}
				}
			}
			
			return;
		}
		
		//2-3 유도 부분 
		
		//i는 인덱스 -> flag는 각 자릿수의 값을 포함하냐 안하냐를 표현, 
		// flag가 true일 떄 한번, false 일 때 한번 경우의 수를 모두 본다. 
		
		for(int i = index; i< flag.length; i++) {
			flag[i] = true;
			hundred(index+1);
			flag[i] = false;
			hundred(index+1);
			//하나의 경우에서 true인 경우 false인 경우 다 봤으면 
			// 그 전 index도 T, F인 경우 확인 해줘야함.
			return;
		}
		
	}
}