import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/19866
        /*
        push_front X    : 정수 X를 덱의 앞에 넣는다.
        push_back X     : 정수 X를 덱의 뒤에 넣는다.
        pop_front       : 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        pop_back        : 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        size            : 덱에 들어있는 정수의 개수를 출력한다.
        empty           : 덱이 비어있으면 1을, 아니면 0을 출력한다.
        front           : 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        back            : 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input_testcase = Integer.parseInt(br.readLine().trim());

        Deque<Integer> dq = new LinkedList<>();

        for(int i=0;i<input_testcase;i++){
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            String check_input_txt = st.nextToken();

            if(check_input_txt.equals("push_front"))
                dq.addFirst(Integer.parseInt(st.nextToken()));
            else if(check_input_txt.equals("push_back"))
                dq.addLast(Integer.parseInt(st.nextToken()));
            else if(check_input_txt.equals("pop_front")){
                if(dq.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(dq.pollFirst() + "\n");
            }
            else if(check_input_txt.equals("pop_back")){
                if(dq.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(dq.pollLast() + "\n");
            }
            else if(check_input_txt.equals("size"))
                bw.write(dq.size() + "\n");
            else if(check_input_txt.equals("empty")){
                if(dq.isEmpty())
                    bw.write("1\n");
                else
                    bw.write("0\n");
            }
            else if(check_input_txt.equals("front")){
                if(dq.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(dq.peekFirst() + "\n");
            }
            else if(check_input_txt.equals("back")){
                if(dq.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(dq.peekLast() + "\n");
            }

        }

        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1966
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> Q = new LinkedList<>();
        int input_test_case = Integer.parseInt(br.readLine().trim());

        for(int i=0;i<input_test_case;i++){
            String[] input_count_prio = br.readLine().split(" ");
            String[] print_prio = br.readLine().split(" ");
            int count = 0;
            Q.clear();

            int print_count = Integer.parseInt(input_count_prio[0]);
            int prio = Integer.parseInt(input_count_prio[1]);

            for(int j=0;j<print_count;j++)
                Q.add(Integer.parseInt(print_prio[j]));

            while(!Q.isEmpty()) {
                boolean isPrio = true;

                for (int j = 1; j < Q.size(); j++) {
                    if (Q.peek() < Q.get(j)) {
                        isPrio = false;
                        break;
                    }
                }

                if(isPrio){
                    count++;
                    Q.poll();

                    if(prio==0)
                        break;
                    else
                        prio--;
                }
                else{
                    Q.add(Q.poll());
                    prio = (prio==0) ? Q.size()-1 : --prio;
                }
                
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();

    }
}

---------------------------------------------------------------------------------------------------