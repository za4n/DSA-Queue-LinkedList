package StackArray;

public class Stack <T>{
    private T [] array;
    private int top;

    public Stack(int size) {
        this.array =(T[]) new Object[size];
        this.top = -1;
    }

    public boolean isStackEmpty() {
        return top == -1;
    }

    public boolean isStackFull() {
        return (top == array.length - 1);
    }

    public void push(T data) {
        if (!isStackFull())
        array[++top] = data;
    }

    public T pop() {
        if (!isStackEmpty())
        return array[top--];
        return null;
    }

    public T peek() {
        if (!isStackEmpty())
            return array[top];
    return null;
    }


    public static String InfixtoPost(String infix) {
        String post = "";
        Stack stack = new Stack(infix.length());
        for (int i = 0; i < infix.length(); i++) {
            String s = String.valueOf(infix.charAt(i));
            if (Character.isLetterOrDigit(s.charAt(0))) {

                post += s;
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.isStackEmpty() && !stack.peek().equals("("))
                    post += stack.pop();
                stack.pop();
            } else {
                while (!stack.isStackEmpty() && getprecedence(stack.peek()) >
                        getprecedence(s) && stack.peek().equals("(")) {
                    post += stack.pop();
                }
                stack.push(s);

            }
        }
        while (!stack.isStackEmpty())
            post += stack.pop();

        return post;
    }

    public static <T> int getprecedence(T ch) {
        switch ((String) ch){
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    public static String postfixToInfix(String postfix) {
        String infix = "";
        Stack<String> stack = new Stack(postfix.length());
        for (int i = 0; i < postfix.length(); i++) {
            String s = String.valueOf(postfix.charAt(i));
            if (Character.isLetterOrDigit(s.charAt(0))) {
                stack.push(s);
            } else {
                String char2 = stack.pop();
                String char1 = stack.pop();
                infix = "(" + char1 + s + char2 + ")";
                stack.push(infix);
            }

        }
        return infix;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
