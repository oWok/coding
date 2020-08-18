//import java.util.Scanner;
//
//public class Main {
//	
//	
//	public static void main(String[] args) {
//	//https://www.acmicpc.net/problem/2577	
//		int[] num_count = new int[10], input_num = new int[3];
//		int gub = 1;
//		Scanner sc = new Scanner(System.in);
//		
//		
//		for(int i=0;i<10;i++)
//			num_count[i] = 0;
//		
//		for(int i=0;i<3;i++) {
//			input_num[i] = sc.nextInt();
//			gub*=input_num[i];
//		}
//		while(gub > 0) {
//			num_count[gub%10]++;
//			gub/=10;			
//			
//			
//		}
//		
//		for(int i=0;i<10;i++)
//			System.out.println(num_count[i]);
//		sc.close();	
//	}
//}
// -> BufferedReader, BufferedWriter로도 풀어보기 

