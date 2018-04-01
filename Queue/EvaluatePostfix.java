package Queue;

import java.util.Stack;

public class EvaluatePostfix {
    String st = "231*+9-";
    //int size = str.length();
    Stack stc = new Stack();
    String[] str=st.split("");

    public boolean isOperator(String ch) {
        return (ch == "+" || ch == "-" || ch == "*" || ch == "/" || ch == "^");
    }

    public Integer calc(Integer a, Integer b, String ch) {
        switch (ch) {
            case ("+"):
                return a + b;
            case ("-"):
                return a - b;
            case ("*"):
                return a * b;
            case ("/"):
                return a / b;
            case ("^"):
                return a ^ b;
            default:
                return 0;
        }
    }

    @SuppressWarnings("unchecked")
	public void evaluate() {
        for (int i = 0; i <  str.length; i++) {
            if ((str[i].equals("+") || str[i].equals("-") || str[i].equals("*") || str[i].equals("/") || str[i].equals("^"))) {
            	Integer a=Integer.valueOf((String)stc.pop());
                Integer b=Integer.valueOf((String)stc.pop());
                Integer c = calc(b, a, str[i]);
                stc.push(c.toString());
                
            } else {
                stc.push(str[i]);
            }

        }
        if (!stc.empty()) {
            System.out.println("value is " + stc.pop());
        }
    }

	public static void main(String[] args) {
        EvaluatePostfix evl = new EvaluatePostfix();
        evl.evaluate();

    }
}
