package division;
import java.util.*;
public class parenthesis
{
    public static void main(String[] args) 
    {
    	String inpt;
    	int count=0, count1=0;
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stk = new Stack<Integer>();
        System.out.println("Enter expression");
        inpt = sc.next();
        if(inpt != "(" && inpt != ")") {
        	System.out.println("Wrong Input..!!");
        }
        int len = inpt.length();
        for (int i = 0; i < len; i++)
        {    
            char ch = inpt.charAt(i);
            if (ch == '(') {
                stk.push(i);
            	count++;
            }
            else if (ch == ')')
            {
                try
                {
                    int p = stk.pop() + 1;
                    count1++;
                    if(count == count1)
                    System.out.println("Stack Matched");
                }
                catch(Exception e)
                {
                    System.out.println("Expression not Started with ( sign - " + e);
                }
            }            
        }
        while (!stk.isEmpty() ) {
            System.out.println("Stack is unmatched");
        	break;	
        }
    }
}
