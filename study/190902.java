import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/4949

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String input_txt = br.readLine();
            char check_txt;
            Stack<Character> stack_parentheses = new Stack<Character>();
            boolean parentheses = true;

            if(input_txt.charAt(0) == '.')
                break;


            for(int i=0;i<input_txt.length();i++){
                check_txt = input_txt.charAt(i);

                if(check_txt == '[' || check_txt == '(')
                    stack_parentheses.push(check_txt);
                else if(check_txt == ']'){
                    if(stack_parentheses.isEmpty() || stack_parentheses.pop() == '('){
                        parentheses = false;
                        break;
                    }
                }
                else if(check_txt == ')'){
                    if(stack_parentheses.isEmpty() || stack_parentheses.pop() == '['){
                        parentheses = false;
                        break;
                    }
                }

            }

            if(!stack_parentheses.isEmpty())
                parentheses = false;

            if(parentheses)
                bw.write("yes\n");
            else
                bw.write("no\n");

        }


        bw.flush();
        bw.close();
    }

}

---------------------------------------------------------------------------------------------------

