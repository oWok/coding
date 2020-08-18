//https://www.acmicpc.net/problem/15552

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input_num = Integer.parseInt(br.readLine().trim());
		
		for(int i=0;i<input_num;i++) {
			String txt = br.readLine();
			String[] word = txt.split(" ");
			int num1 = Integer.parseInt(word[0]);
			int num2 = Integer.parseInt(word[1]);
	
			bw.write((num1+num2) + "\n");
			}
		
		bw.flush();
		bw.close();
		
	}
}

----------------------------------------------------------------------------------------------------


public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		int input_count;
		Scanner sc = new Scanner(System.in);

		int max = 0, num[] = new int[1000];
		double[] result = new double[1000];
		double avg = 0;

		input_count = sc.nextInt();

		for(int i=0;i<input_count;i++) {
			num[i] = sc.nextInt();
			max = (max > num[i]) ? max : num[i];			
		}

		for(int i=0;i<input_count;i++) { 	
			result[i] = (double)num[i]/(double)max*100;
			avg += result[i];
		}


		System.out.printf("%.2f", avg/inpu);
				
		sc.close();

		
	}
}

↓ 나중에 수정
//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//int input_count = Integer.parseInt(br.readLine().trim());
//int max = 0, num[] = new int[1000];
//
//double[] result = new double[1000];
//double sum = 0;
//
//for(int i=0;i<input_count;i++) {
//	num[i] = Integer.parseInt(br.readLine().trim());
//	max = (max > num[i]) ? max : num[i];
//}
//
//for(int i=0;i<input_count;i++) {
//	result[i] = (double)num[i]/max*100;
//	sum+=result[i];
//}
//
//double avg = sum/input_count;
//
//bw.write(avg + "\n");
//
//bw.flush();
//bw.close();

