//https://www.acmicpc.net/problem/1193
		int check = 1;
		int check_dir = 1, num_i = 1, num_j = 1;
		int check_time, count = 1;
		//String sel_num;
		Scanner sc = new Scanner(System.in);
		
		check_time = sc.nextInt();
		
		//sel_num = new String[check_time+1];
		//sel_num = num_i + "/" + num_j;
		count++;
		
		if(check_time > 1) {
			while(true) {
				check++;
				if(check_dir == 1) {
					num_i = 1;
					num_j = check;
					for(int i=0;i<check;i++) {
					//	sel_num = num_i + "/" + num_j;
						
						num_i++;
						if(num_j != 1) {
							num_j--;
						}
						count++;
						
						if(count == check_time)
							break;
					}
					check_dir = -1;
				}
				else {
					num_i = check;
					num_j = 1;
					for(int i=0;i<check;i++) {
					//	sel_num = num_i + "/" + num_j;
						if(num_i != 1) {						
							num_i--;
						}
						num_j++;
						count++;
						
						if(count == check_time)
							break;
					}
					check_dir = 1;
				}
				
				if(count == check_time)
					break;
			}
	
		}
		System.out.println(num_i + "/" + num_j);
		sc.close();
		
//-------------------------------------------------------------------------------------------------

//https://www.acmicpc.net/problem/2292
		int input_num, count=1, check = 1;
		Scanner sc = new Scanner(System.in);
		
		input_num = sc.nextInt();
		
		while(true) {
			
			
			if(input_num == 1) 
				break;
			else {
				if(input_num > check && input_num <= check + count*6) {
					count++;
					break;
				}
			}
			check = check + count*6;
			count++;
		}
		
		System.out.println(count);
		sc.close();
		
//-------------------------------------------------------------------------------------------------

