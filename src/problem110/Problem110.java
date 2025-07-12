package problem110;

import java.util.Stack;

enum State {
    INITIAL_STATE,
    SEEN_PLUS,
    SEEN_MINUS,
    SEEN_NUMBER,
    SEEN_OPENING_PARENTHESIS
}

public class Problem110 {
    private int operate(char operator, String operand1, String operand2) {
        if (operator == '+') {
            return Integer.parseInt(operand1) + Integer.parseInt(operand2);
        } else if (operator == '-') {
            return Integer.parseInt(operand1) - Integer.parseInt(operand2);
        } else {
            return 0;
        }
    }

    public int calculate(String s) {
        State currentState = State.INITIAL_STATE;
        Stack<Character> operatorStack = new Stack<>();
        Stack<String> numberStack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == ' ') {
                continue;
            } else if (c == '(') {
                if (currentState == State.INITIAL_STATE) {
                    operatorStack.push(c);
                } else if (currentState == State.SEEN_MINUS) {
                    operatorStack.push(c);
                } else if (currentState == State.SEEN_PLUS) {
                    operatorStack.push(c);
                }
                currentState = State.SEEN_OPENING_PARENTHESIS;
            } else if (c == ')') {
                // Pop the stack and keep on doing the arithmetic operations until '(' is popped
                if (currentState == State.SEEN_NUMBER) {
                    while (operatorStack.peek() != '(') {
                        // Pop two numbers from the stack and perform the calculation
                        Character operator = operatorStack.pop();
                        String number2 = numberStack.pop();
                        String number1 = numberStack.pop();

                        numberStack.push(Integer.toString(operate(operator, number1, number2)));
                    }
                    operatorStack.pop();
                }
            } else if (c == '+') {
                if (currentState == State.SEEN_NUMBER) {
                    if (!operatorStack.isEmpty() && operatorStack.peek() == '-') {
                        String number = numberStack.pop();
                        numberStack.push('-' + number);
                        operatorStack.push('+'); // Plus replaces the minus
                    }
                    operatorStack.push(c);
                } else {
                    return 0;
                }
                currentState = State.SEEN_PLUS;
            } else if (c == '-') {
                if (currentState == State.INITIAL_STATE || currentState == State.SEEN_NUMBER ||
                        currentState == State.SEEN_OPENING_PARENTHESIS) {
                    operatorStack.push(c);
                } else {
                    return 0;
                }
                currentState = State.SEEN_MINUS;
            }else {
                // c is a digit
                if (currentState == State.INITIAL_STATE) {
                    numberStack.push(String.valueOf(c));
                } else if (currentState == State.SEEN_NUMBER) {
                    // Pop the number from the stack and push the new number
                    String num = numberStack.pop();
                    numberStack.push(num + c);
                } else {
                    // Plus or Minus or Parenthesis
                    numberStack.push(String.valueOf(c));
                }
                currentState = State.SEEN_NUMBER;
            }
        }
        while (numberStack.size() >= 2 && !operatorStack.isEmpty()) {
            Character operator = operatorStack.pop();
            String number2 = numberStack.pop();
            String number1 = numberStack.pop();

            numberStack.push(Integer.toString(operate(operator, number1, number2)));
        }
        return Integer.parseInt(numberStack.peek());
    }
}
