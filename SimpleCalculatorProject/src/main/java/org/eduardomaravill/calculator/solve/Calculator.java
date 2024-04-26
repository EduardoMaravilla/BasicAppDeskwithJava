package org.eduardomaravill.calculator.solve;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    private static Calculator calculator;

    private Calculator() {
    }

    public static Calculator getInstance() {
        if (calculator == null) {
            calculator = new Calculator();
        }
        return calculator;
    }

    public double calculate(String expression) throws IllegalArgumentException {
        // Eliminar espacios en blanco de la expresión
        expression = expression.replaceAll("\\s+", "");
        expression = expression.replaceAll("(\\d)-", "$1+-");

        // Crear una cola de salida para almacenar los operandos y operadores
        Deque<String> outputQueue = getStringDeque(expression);

        // Calcular el resultado utilizando la cola de salida
        Deque<Double> resultStack = new ArrayDeque<>();
        while (!outputQueue.isEmpty()) {
            String token = outputQueue.removeFirst();
            if (token.matches("-?[0-9]+.?[0-9]*")) {
                resultStack.addLast(Double.parseDouble(token));
            } else {
                double operand2 = resultStack.removeLast();
                double operand1 = resultStack.removeLast();
                switch (token) {
                    case "+":
                        resultStack.addLast(operand1 + operand2);
                        break;
                    case "-":
                        resultStack.addLast(operand1 - operand2);
                        break;
                    case "*":
                        resultStack.addLast(operand1 * operand2);
                        break;
                    case "/":
                        if (operand2 == 0.0) {
                            throw new ArithmeticException("You cannot divide by zero");
                        }
                        resultStack.addLast(operand1 / operand2);
                        break;
                }
            }
        }
        return resultStack.removeLast();
    }

    private Deque<String> getStringDeque(String expression){
        Deque<String> outputQueue = new ArrayDeque<>();

        // Crear una pila para almacenar los operadores
        Deque<String> operatorStack = new ArrayDeque<>();

        // Dividir la expresión en tokens
        String[] tokens = expression.split("(?<=[+*/])|(?=[+*/])");
        // Iterar sobre los tokens
        for (String token : tokens) {
            if (token.matches("-?[0-9]+.?[0-9]*")) {
                // Si el token es un número, agregarlo a la cola de salida
                outputQueue.addLast(token);
            } else if (token.matches("[*/]")) {
                // Si el token es una multiplicación o división
                while (!operatorStack.isEmpty() && (operatorStack.peekLast().equals("*") || operatorStack.peekLast().equals("/"))) {
                    outputQueue.addLast(operatorStack.removeLast());
                }
                operatorStack.addLast(token);
            } else if (token.matches("[+]")) {
                // Si el token es una suma o resta
                while (!operatorStack.isEmpty()) {
                    outputQueue.addLast(operatorStack.removeLast());
                }
                operatorStack.addLast(token);
            }
        }

        // Vaciar la pila de operadores
        while (!operatorStack.isEmpty()) {
            outputQueue.addLast(operatorStack.removeLast());
        }
        return outputQueue;
    }
}
