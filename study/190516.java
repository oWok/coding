//190516
//https://www.acmicpc.net/problem/2839
//int input = 0; 
//int count = 0;
//Scanner sc = new Scanner(System.in);
//input = sc.nextInt();
//    
//while(true) {
//	if (input % 5 ==0) {
//		System.out.println(input/5 + count);
//		break;
//    }
//	else if(input <= 0) {
//		System.out.println(-1);
//		break;
//    }
//	
//	input = input-3;
//	count++;
//    
//}

//https://www.acmicpc.net/problem/2438
//int input;
//Scanner sc = new Scanner(System.in);
//
//input = sc.nextInt();
//
//for(int i = 0;i<input;i++) {
//	for(int j=0;j<i+1;j++) {
//		System.out.printf("*");
//	}
//	System.out.println();
//}
//---------------------------------------------------------------
//https://www.acmicpc.net/problem/2439
//int input, i, j;
//Scanner sc = new Scanner(System.in);
//String[][] txt = new String[100][100];
//
//
//input = sc.nextInt();
//
//for(i=0;i<input;i++) {
//	for(j=input-1;j>input-i-2;j--) {
//		txt[i][j] = "*";
//	}
//	
//	if(input-i!=0) {
//		for(int k=0;k<input-i-1;k++) {
//			txt[i][k]=" ";
//		}
//	}
//}
//
//for(i=0;i<input;i++) {
//	for(j=0;j<input;j++) System.out.printf("%s", txt[i][j]);
//	System.out.println();
//}
//sc.close();
//---------------------------------------------------------------
//https://www.acmicpc.net/problem/2440
//int input;
//Scanner sc = new Scanner(System.in);
//
//input = sc.nextInt();
//
//for(int i=0;i<input;i++) {
//	for(int j=0;j<input-i;j++){
//		System.out.printf("*");
//	}
//	System.out.println();
//}
//sc.close();
//---------------------------------------------------------------
//https://www.acmicpc.net/problem/2441
//int input;
//Scanner sc = new Scanner(System.in);
//String[][] txt = new String[100][100];
//
//input = sc.nextInt();
//
//for(int i=0;i<input;i++) {
//	for(int j=i;j<input;j++) {
//		txt[i][j] = "*";
//	}
//	
//	if(i!=0) {
//		for(int k=0;k<i;k++) {
//			txt[i][k]= " ";
//		}
//	}
//}
//
//for(int i=0;i<input;i++) {
//	for(int j=0;j<input;j++) System.out.printf("%s",txt[i][j]);
//	
//	System.out.println();
//}
//---------------------------------------------------------------
//https://www.acmicpc.net/problem/1924
//String[][] day = new String[13][32];
//int x, y;
//int k=1;
//
//Scanner sc = new Scanner(System.in);
//
//x = sc.nextInt();
//y = sc.nextInt();
//
//for(int i=1;i<13;i++) {
//	if(i==1||i==3||i==5||i==7||i==8||i==10||i==12) {
//		for(int j=1;j<32;j++) {
////			switch (k) {
////			case 1:
////				day[i][j] = "MON";
////				break;
////			case 2:
////				day[i][j] = "TUE";
////				break;
////			case 3:
////				day[i][j] = "WED";
////				break;
////			case 4:
////				day[i][j] = "THU";
////				break;
////			case 5:
////				day[i][j] = "FRI";
////				break;
////			case 6:
////				day[i][j] = "SAT";
////				break;
////			default:
////				day[i][j] = "SUN";
////				break;
////			}
//			
//			if(k==1) day[i][j] = "MON";
//			else if(k==2) day[i][j] = "TUE";
//			else if(k==3) day[i][j] = "WED";
//			else if(k==4) day[i][j] = "THU";
//			else if(k==5) day[i][j] = "FRI";
//			else if(k==6) day[i][j] = "SAT";
//			else if(k==7) day[i][j] = "SUN";
//			k++;
//			if(k==8) k=1;
//		}
//	}
//	else if(i==4||i==6||i==9||i==11) {
//		for(int j=1;j<31;j++) {
////			switch (k) {
////			case 1:
////				day[i][j] = "MON";
////				break;
////			case 2:
////				day[i][j] = "TUE";
////				break;
////			case 3:
////				day[i][j] = "WED";
////				break;
////			case 4:
////				day[i][j] = "THU";
////				break;
////			case 5:
////				day[i][j] = "FRI";
////				break;
////			case 6:
////				day[i][j] = "SAT";
////				break;
////			default:
////				day[i][j] = "SUN";
////				break;
////			}
//			
//			if(k==1) day[i][j] = "MON";
//			else if(k==2) day[i][j] = "TUE";
//			else if(k==3) day[i][j] = "WED";
//			else if(k==4) day[i][j] = "THU";
//			else if(k==5) day[i][j] = "FRI";
//			else if(k==6) day[i][j] = "SAT";
//			else if(k==7) day[i][j] = "SUN";
//			
//			k++;
//			if(k==8) k=1;
//		}
//	}
//	else {
//		for(int j=1;j<29;j++) {
////			switch (k) {
////			case 1:
////				day[i][j] = "MON";
////				break;
////			case 2:
////				day[i][j] = "TUE";
////				break;
////			case 3:
////				day[i][j] = "WED";
////				break;
////			case 4:
////				day[i][j] = "THU";
////				break;
////			case 5:
////				day[i][j] = "FRI";
////				break;
////			case 6:
////				day[i][j] = "SAT";
////				break;
////			default:
////				day[i][j] = "SUN";
////				break;
////			}
//			
//			if(k==1) day[i][j] = "MON";
//			else if(k==2) day[i][j] = "TUE";
//			else if(k==3) day[i][j] = "WED";
//			else if(k==4) day[i][j] = "THU";
//			else if(k==5) day[i][j] = "FRI";
//			else if(k==6) day[i][j] = "SAT";
//			else if(k==7) day[i][j] = "SUN";
//			
//			k++;
//			if(k==8) k=1;
//		}
//	}
//}
//
//System.out.printf("%s",day[x][y]);
//sc.close();
//---------------------------------------------------------------
//https://www.acmicpc.net/problem/8393
//int num, sum;
//sum = 0;
//
//Scanner sc = new Scanner(System.in);
//
//num = sc.nextInt();
//
//
//for(int i=0;i<=num;i++) sum+=i;
//
//System.out.println(sum);
//sc.close();

//https://www.acmicpc.net/problem/2741
//int num;
//Scanner sc = new Scanner(System.in);
//
//num = sc.nextInt();
//
//for(int i=1;i<=num;i++) System.out.println(i);
//
//sc.close();
//---------------------------------------------------------------
//https://www.acmicpc.net/problem/2742
//int num;
//Scanner sc = new Scanner(System.in);
//
//num = sc.nextInt();
//
//for(int i=num;i>0;i--) System.out.println(i);
//
//sc.close();