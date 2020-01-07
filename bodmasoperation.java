package bodmasoperation;
import java.util.*;
public class BodmasOperation {
    public static boolean checkPriority(char operator1, char operator2) 
    { 
        if (operator2 == '(' || operator2 == ')') 
            return false; 
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) 
            return false; 
        else
            return true; 
    } 
    public static int performOperation(char operator, int num1, int num2) 
    { 
        switch (operator) 
        { 
        case '+': 
            return num1 + num2; 
        case '-': 
            return num1 - num2; 
        case '*': 
            return num1 * num2; 
        case '/': 
            if (num2 == 0) 
                throw new ArithmeticException("Divide bt Zero Error"); 
            return num1 / num2; 
        } 
        return 0; 
    }
	public static int evaluateString(String getStringFromUser) 
    { 
        char[] userExpression = getStringFromUser.toCharArray();   
        Stack<Integer> integerValues = new Stack<Integer>(); 
        Stack<Character> operatorValues = new Stack<Character>(); 
        for (int i = 0; i < userExpression.length; i++) 
        { 
            if (userExpression[i] >= '0' && userExpression[i] <= '9') 
            { 
                StringBuffer sbuf = new StringBuffer(); 
                while (i < userExpression.length && userExpression[i] >= '0' && userExpression[i] <= '9') 
                    sbuf.append(userExpression[i++]); 
                integerValues.push(Integer.parseInt(sbuf.toString())); 
            }   
            else if (userExpression[i] == '+' || userExpression[i] == '-' || 
                     userExpression[i] == '*' || userExpression[i] == '/') 
            { 
                while (!operatorValues.empty() && checkPriority(userExpression[i], operatorValues.peek())) 
                  integerValues.push(performOperation(operatorValues.pop(), integerValues.pop(), integerValues.pop())); 
                operatorValues.push(userExpression[i]); 
            } 
        } 
        while (!operatorValues.empty()) 
            integerValues.push(performOperation(operatorValues.pop(), integerValues.pop(), integerValues.pop())); 
        return integerValues.pop(); 
    } 
    public static void main(String[] args) {
        //test case 1
        System.out.println(BodmasOperation.evaluateString("100 * (10 +20+30-5-10)/(3*(4-4))"));
        
    }   
}