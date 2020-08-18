
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//https://www.acmicpc.net/problem/1110
		
		int Early_num, next_num, r_num, l_num, count = 0, sum;
		
		Scanner sc = new Scanner(System.in);
		
		Early_num = sc.nextInt();
		next_num = Early_num;
		
		while(true) {
			r_num = next_num%10;
			l_num = next_num/10;
			
			sum = r_num + l_num;
			
			next_num = r_num*10 + sum%10;
			count++;
			
			if(next_num == Early_num) {
				System.out.println(count);
				break;
			}
			
		}
		
	}
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		//https://www.acmicpc.net/problem/1110
		
		int Early_num, next_num, r_num, l_num, count = 0, sum;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Early_num = Integer.parseInt(br.readLine().trim());
		next_num = Early_num;
		
		while(true) {
			r_num = next_num%10;
			l_num = next_num/10;
			
			sum = r_num+l_num;
			
			next_num = r_num*10 + sum%10;
			count++;
			
			
			
			if(next_num == Early_num) {
				System.out.println(count);
				break;
			}
		}
		
//		bw.flush();
//		bw.close();
		
	}
}

-----------------------------------------------------------------------------------------------------------------------------------------------

