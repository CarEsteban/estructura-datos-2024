
public class ShutingYard {
    private IStack<Character> operatorStack;
    private StringBuilder postfix = new StringBuilder();

    public ShutingYard(IStack<Character> operatorStack) {
        this.operatorStack = operatorStack;
    }
    
    public void parseExpression(String expression) {
        for (char token : expression.toCharArray()) {
            if (Character.isDigit(token)) {
                postfix.append(token);
            } else if (isOperator(token)) {
                processOperator(token, getPrecedence(token));
            } else if (token == '(') {
                operatorStack.push(token);
            } else if (token == ')') {
                popOperatorsUntilLeftParenthesis();
            }
        }
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }
    }

    public String output() {
        return postfix.toString();
    }

    private void processOperator(char operator, int precedence) {
        while (!operatorStack.isEmpty() && isOperator(operatorStack.peek())) {
            char topOperator = operatorStack.peek();
            if (getPrecedence(topOperator) >= precedence) {
                postfix.append(operatorStack.pop());
            } else {
                break;
            }
        }
        operatorStack.push(operator);
    }

    private void popOperatorsUntilLeftParenthesis() {
        while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
            postfix.append(operatorStack.pop());
        }
        if (!operatorStack.isEmpty()) {
            operatorStack.pop();  // Pop the left parenthesis
        }
    }

    private int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private boolean isOperator(char token) {
        return token == '+' || token == '-' || token == '*' || token == '/';
    }
}