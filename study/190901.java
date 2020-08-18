import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ#1541 잃어버린 괄호
 * https://www.acmicpc.net/problem/1541
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] strArr1 = input.split("\\-");

        int minSum = 0;
        for (int i = 0; i < strArr1.length; i++) {

            String[] strArr2 = strArr1[i].split("\\+");

            int tempSum = 0;
            for (String x : strArr2) {

                tempSum += Integer.parseInt(x);
            }

            if (i == 0) tempSum *= -1;

            minSum -= tempSum;
        }

        System.out.println(minSum);
    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1541

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sum_ma = br.readLine().trim(), temp = "";

        StringTokenizer minsu, plus;
        int num_minsu = 0, num_plus = 0;
        for(int i=0;i<sum_ma.length();i++){
            if(sum_ma.charAt(i) == '-'){
                plus = new StringTokenizer(sum_ma.substring(0, i).replace("+", " "));
                minsu = new StringTokenizer(sum_ma.substring(i+1, sum_ma.length()).replaceAll("[- | +]", " "));

                while (minsu.hasMoreElements())
                    num_minsu += Integer.parseInt(minsu.nextToken());

                while (plus.hasMoreElements())
                    num_plus += Integer.parseInt(plus.nextToken());

                break;
            }
        }

        bw.write(num_plus-num_minsu + "\n");
        bw.flush();
        bw.close();
    }

}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/10828
        /*
        push X  : 정수 X를 스택에 넣는 연산이다.
        pop     : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        size    : 스택에 들어있는 정수의 개수를 출력한다.
        empty   : 스택이 비어있으면 1, 아니면 0을 출력한다.
        top     : 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_count = Integer.parseInt(br.readLine().trim());
        Stack<Integer> stack_num = new Stack<Integer>();

        for(int i=0;i<input_count;i++){
            StringTokenizer stack_st = new StringTokenizer(br.readLine().trim());
            String input_txt = stack_st.nextToken();
            if(input_txt.equals("push")){
                int input_num = Integer.parseInt(stack_st.nextToken());
                stack_num.push(input_num);
            }
            else if(input_txt.equals("pop")){
                bw.write((stack_num.empty()?-1:stack_num.pop()) + "\n");
            }
            else if(input_txt.equals("size")){
                bw.write(stack_num.size() + "\n");
            }
            else if(input_txt.equals("empty")){
                bw.write((stack_num.empty()?1:0) + "\n");
            }
            else if(input_txt.equals("top")){
                bw.write((stack_num.empty()?-1:stack_num.peek()) + "\n");
            }
        }

        bw.flush();
        bw.close();

    }

}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/10828

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_count = Integer.parseInt(br.readLine().trim());
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;

        for(int i=0;i<input_count;i++){
            int input_num = Integer.parseInt(br.readLine().trim());
            if(input_num == 0){
                stack.pop();
            }
            else{
                stack.push(input_num);
            }
        }

        if(!stack.empty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                sum += stack.pop();
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();

    }

}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/9012

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input_count = Integer.parseInt(br.readLine().trim());


        while(input_count-->0){
            String input_txt = br.readLine().trim();
            Stack<Character> stack = new Stack<Character>();
            boolean check = true;

            char check_txt;
            for(int i=0;i<input_txt.length();i++){
                check_txt = input_txt.charAt(i);

                if(check_txt == '(')
                    stack.push(check_txt);
                else if(check_txt == ')'){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    else{
                        check = false;
                        break;
                    }
                }
            }

            if(!stack.isEmpty())
                check = false;

            if(check)
                bw.write("YES" + "\n");
            else
                bw.write("NO" + "\n");


        }


        bw.flush();
        bw.close();

    }

}

---------------------------------------------------------------------------------------------------

