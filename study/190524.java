
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//https://www.acmicpc.net/problem/4344
		int c, num[][] = new int[1000][1000], sum[]= new int[1000] ,n[] = new int[1000];
		double[] avg_c = new double[1000], avg = new double[1000];
		int count;
		
		Scanner sc = new Scanner(System.in);
		
		c = sc.nextInt();
		
		
		for(int i=0;i<c;i++) {
			
			n[i] = sc.nextInt();
			
			for(int j=0;j<n[i];j++) {
				num[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<c;i++) {
			
			sum[i] = 0;
			
			for(int j=0;j<n[i];j++) {
				sum[i]+=num[i][j];
			}
			avg[i] = (double)sum[i]/(double)n[i];
		}
				
		for(int i=0;i<c;i++) { 
			
			count=0;
			
			for(int j=0;j<n[i];j++) {
				if(avg[i]<(double)num[i][j]) {
					count++;
				}				
			}
			avg_c[i] = (double)count/(double)n[i];
		}
		
		for(int i=0;i<c;i++) {
			String avgg = String.format("%.3f", avg_c[i]*100);
			System.out.println(avgg + "%");	
		}
		
//		for(int i=0;i<c;i++) 
//			System.out.printf("%.3\n", avg_c[i]*100);
		
		sc.close();
	}
}

/*
못푼문제
https://www.acmicpc.net/problem/11721

 */

