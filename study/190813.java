import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1427
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input_num = br.readLine().trim();
        int[] arr_num = new int[input_num.length()];

        Arrays.fill(arr_num, 0);

        for(int i=0;i<input_num.length();i++)
            arr_num[i] = Integer.parseInt(input_num.charAt(i) + "");


        for(int i=0;i<input_num.length()-1;i++){
            int temp;
            for(int j=i+1;j<input_num.length();j++){
                if(arr_num[i] < arr_num[j]){
                    temp = arr_num[i];
                    arr_num[i] = arr_num[j];
                    arr_num[j] = temp;
                }
            }
        }

        for(int i=0;i<input_num.length();i++)
            bw.write(arr_num[i] + "");

//        List<int[]> num = Arrays.asList(arr_num);
//
//        Collections.reverse(num);
//
//        num.forEach(System.out::println);

        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1427
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input_num = br.readLine().trim();
        Integer[] arr_num = new Integer[input_num.length()];

        for(int i=0;i<input_num.length();i++)
            arr_num[i] = Integer.parseInt(input_num.charAt(i) + "");


        for(int i=0;i<input_num.length()-1;i++){
            int temp;
            for(int j=i+1;j<input_num.length();j++){
                if(arr_num[i] < arr_num[j]){
                    temp = arr_num[i];
                    arr_num[i] = arr_num[j];
                    arr_num[j] = temp;
                }
            }
        }

        Arrays.sort(arr_num, Collections.reverseOrder());

        for(int i=0;i<input_num.length();i++)
            bw.write(arr_num[i] + "");

//        List<int[]> num = Arrays.asList(arr_num);
//
//        Collections.reverse(num);
//
//        num.forEach(System.out::println);

        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------