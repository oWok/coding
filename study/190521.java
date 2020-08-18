//https://www.acmicpc.net/problem/9498

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int input;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = Integer.parseInt(br.readLine().trim());
		
		if(input >= 90 && input <=100) bw.write("A\n");
		else if(input >=80 && input < 90) bw.write("B\n");
		else if(input >=70 && input < 80) bw.write("C\n");
		else if(input >=60 && input < 70) bw.write("D\n");
		else bw.write("F\n");
	
		
		bw.flush();
		bw.close();
	}	
}

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input;
		Scanner sc = new Scanner(System.in);
		
		input = sc.nextInt();
		
		if(input>=90 && input<=100) System.out.println("A");
		else if(input>=80 && input<90) System.out.println("B");
		else if(input>=70 && input<80) System.out.println("C");
		else if(input>=60 && input<70) System.out.println("D");
		else System.out.println("F");
		
		
	}	
}


---------------------------------------------------------------------------------------
//https://www.acmicpc.net/problem/10817

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[3];
		int temp;
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<3;i++) input[i] = sc.nextInt();
		
		for(int i=0;i<3;i++) {
			for(int j=i+1;j<3;j++) {
				if(input[i] < input[j]) {
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		
		System.out.println(input[1]);
	}
}


---------------------------------------------------------------------------------------
//https://www.acmicpc.net/problem/10871

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input_max, input_check, input_num[] = new int[10000];
		Scanner sc = new Scanner(System.in);
		
		input_max = sc.nextInt();
		input_check = sc.nextInt();
		
		for(int i=0;i<input_max;i++) 
			input_num[i] = sc.nextInt();
		
		for(int i=0;i<input_max;i++) {
			if(input_num[i] < input_check) 
				System.out.printf("%d ", input_num[i]);
		}
		
		
	}
}