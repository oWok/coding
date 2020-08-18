	//https://www.acmicpc.net/problem/8958
//		char[][] OX;
//		String[] O_X;
//		int count = 0, num_time, temp = 0;
//		Scanner sc = new Scanner(System.in);
//		ArrayList<Integer> score = new ArrayList<>();
//		
//		num_time = sc.nextInt();
//				
//		O_X = new String[num_time];
//		
//		for(int i=0;i<num_time;i++) 
//			O_X[i] = sc.next();
//				
//		OX = new char[num_time][80];
//			
//		
//		for(int i=0;i<num_time;i++) {
//			for(int j=0;j<O_X[i].length();j++) {
//				OX[i][j] = O_X[i].charAt(j);
//			}
//		}
//		
//		for(int i=0;i<num_time;i++) {
//			for(int j=0;j<O_X[i].length();j++) {
//				if(OX[i][j] == 'O') {
//					count++;
//					temp+=count;
//				}
//				else {
//					count = 0;
//				}
//			}
//			score.add(temp);
//			temp = 0;
//			count = 0; 
//		}
//		
//		score.forEach(System.out::println);
//		
//		
//		sc.close();
---------------------------------------------------------------------------------------------------
//		//https://www.acmicpc.net/problem/1157
//				String input_txt;
//				char[] txt;
//				int[] count = {0};
//				int check = 0, max = 0;
//				
//				
//				Scanner sc = new Scanner(System.in);
//				
//				input_txt = sc.next().toUpperCase();
//				txt = new char[input_txt.length()];
//				count = new int[input_txt.length()];
//				
//				for(int i=0;i<input_txt.length();i++) {
//					txt[i] = input_txt.charAt(i);
//				}
//				
//				for(int i=0;i<input_txt.length()-1;i++) {
//					for(int j=i+1;j<input_txt.length();j++) {
//						if(txt[i] == txt[j])
//							count[i]++;
//					}
//				}
//				
//				for(int i=0;i<input_txt.length()-1;i++) {
//					check = 0;
//					if(count[max] == count[i+1]) {
//							check++;
//							break;
//					}
//					else {
//						if(count[i] > count[i+1]) {
//							if(count[max] < count[i]) {
//								max = i;
//							}
//						}
//					}
//					
//				}
//				
//				if(check > 0) 
//					System.out.println("?");
//				else
//					System.out.println(txt[max]);
//				
//				sc.close();
//
//				
//....
//		Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine().toUpperCase();
// 
//        int[] cnt = new int[26];
//        int max = 0;
//        char result = '?';
// 
//        for (int i = 0; i < str.length(); i++) {
//            cnt[str.charAt(i) - 65]++;
//            if (max < cnt[str.charAt(i) - 65]) {
//                max = cnt[str.charAt(i) - 65];
//                result = str.charAt(i);
//            } else if (max == cnt[str.charAt(i) - 65]) {
//                result = '?';
//            }
//        }
//        System.out.println(result);
// 
//        sc.close();

// -> cnt[str.charAt(i) - 65] -> 이게 왜 이렇게 되는지 확인해보기
