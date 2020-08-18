//		//https://www.acmicpc.net/problem/2908
//		int[] num = new int[2];
//		Scanner sc = new Scanner(System.in);
//		int temp, check;
//		
//		for(int i=0;i<2;i++)
//			num[i] = sc.nextInt();
//		
//		for(int j=0;j<2;j++) {
//			temp = 0;
//			check = 100;
//			for(int i=0;i<3;i++) {
//				temp+=(num[j]%10)*check;
//				check/=10;
//				num[j]/=10;
//			}
//			num[j] = temp;
//		}
//		
//		num[0] = (num[0] > num[1]) ? num[0] : num[1];
//		
//		System.out.println(num[0]);
//		sc.close();

---------------------------------------------------------------------------------------------------

//		//https://www.acmicpc.net/problem/5622
//		String input_dial;
//		char[] en_to_num;
//		int sum_time = 0;
//		Scanner sc = new Scanner(System.in);
//		
//		input_dial = sc.next();
//		en_to_num = new char[input_dial.length()];
//		
//		
//		for(int i=0;i<input_dial.length();i++) {
//			en_to_num[i] = input_dial.charAt(i);
//			if(en_to_num[i] == 'A' || en_to_num[i] == 'B' || en_to_num[i] == 'C')
//				sum_time+=3;
//			else if(en_to_num[i] == 'D' || en_to_num[i] == 'E' || en_to_num[i] == 'F')
//				sum_time+=4;
//			else if(en_to_num[i] == 'G' || en_to_num[i] == 'H' || en_to_num[i] == 'I')
//				sum_time+=5;
//			else if(en_to_num[i] == 'J' || en_to_num[i] == 'K' || en_to_num[i] == 'L')
//				sum_time+=6;
//			else if(en_to_num[i] == 'M' || en_to_num[i] == 'N' || en_to_num[i] == 'O')
//				sum_time+=7;
//			else if(en_to_num[i] == 'P' || en_to_num[i] == 'Q' || en_to_num[i] == 'R' || en_to_num[i] == 'S')
//				sum_time+=8;
//			else if(en_to_num[i] == 'T' || en_to_num[i] == 'U' || en_to_num[i] == 'V')
//				sum_time+=9;
//			else if(en_to_num[i] == 'W' || en_to_num[i] == 'X' || en_to_num[i] == 'Y' || en_to_num[i] == 'Z')
//				sum_time+=10;
//			else
//				sum_time+=2;
//		}
//		
//		System.out.println(sum_time);
//		
//		sc.close();

