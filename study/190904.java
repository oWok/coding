import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/17298

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input_count = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int[] num = new int[input_count];

        for(int i=0;i<input_count;i++)
            num[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<Integer>();
        int[] numb = new int[input_count];

        for(int i=input_count-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek()<=num[i])
                stack.pop();

            if(stack.isEmpty())
                numb[i] = -1;
            else
                numb[i] = stack.peek();

            stack.push(num[i]);
        }

        for(int i:numb)
            bw.write(i + " ");

        bw.write("\n");
        bw.flush();
        bw.close();
    }

}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/10845

        /*
        push X  : 정수 X를 큐에 넣는 연산이다.
        pop     : 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        size    : 큐에 들어있는 정수의 개수를 출력한다.
        empty   : 큐가 비어있으면 1, 아니면 0을 출력한다.
        front   : 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        back    : 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         */


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        LinkedList<Integer> que = new LinkedList<>();

        int input_count = Integer.parseInt(br.readLine().trim());

        for(int i=0;i<input_count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            String check = st.nextToken();
            if(check.equals("push"))
                que.add(Integer.parseInt(st.nextToken().trim()));
            else if(check.equals("pop")){
                if(que.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(que.pop() + "\n");
            }
            else if(check.equals("size"))
                bw.write(que.size() + "\n");
            else if(check.equals("empty")){
                if(que.isEmpty())
                    bw.write("1\n");
                else
                    bw.write("0\n");
            }
            else if(check.equals("front")) {
                if (que.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(que.peekFirst() + "\n");
            }
            else if(check.equals("back")){
                if(que.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(que.peekLast() + "\n");

            }
        }

        bw.flush();
        bw.close();
    }

}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/2164

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_count = Integer.parseInt(br.readLine().trim());
        LinkedList<Integer> que = new LinkedList<>();

        for(int i=input_count;i>0;i--)
            que.push(i);

        int i = 1;
        while(true){
            if(que.size() == 1){
                bw.write(que.pop() + "\n");
                break;
            }

            if(i%2!=0)
                que.pop();
            else
                que.addLast(que.pop());

            i++;
        }

        bw.flush();
        bw.close();
    }

}

---------------------------------------------------------------------------------------------------