package org.eduardomaravill.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.eduardomaravill.calculator.solve.Calculator;


public class CalculatorController {

    private boolean wasResolve;
    private boolean errorOperation;

    @FXML
    private TextField screenOperation;

    @FXML
    private Label errorMessage;

    @FXML
    protected void putNumberZero() {
        appendNumberToScreen("0");
    }

    @FXML
    protected void putNumberOne() {
        appendNumberToScreen("1");
    }

    @FXML
    protected void putNumberTwo() {
        appendNumberToScreen("2");
    }

    @FXML
    protected void putNumberThree() {
        appendNumberToScreen("3");
    }

    @FXML
    protected void putNumberFour() {
        appendNumberToScreen("4");
    }

    @FXML
    protected void putNumberFive() {
        appendNumberToScreen("5");
    }

    @FXML
    protected void putNumberSix() {
        appendNumberToScreen("6");
    }

    @FXML
    protected void putNumberSeven() {
        appendNumberToScreen("7");
    }

    @FXML
    protected void putNumberEight() {
        appendNumberToScreen("8");
    }

    @FXML
    protected void putNumberNine() {
        appendNumberToScreen("9");
    }

    @FXML
    protected void  putOperatorAdd(){
        appendOperatorToScreen("+");
    }

    @FXML
    protected void  putOperatorSubtract(){
        appendOperatorToScreen("-");
    }

    @FXML
    protected void  putOperatorMultiply(){
        appendOperatorToScreen("*");
    }

    @FXML
    protected void  putOperatorDivide(){
        appendOperatorToScreen("/");
    }

    @FXML
    protected void  putOperatorDecimal(){
        appendOperatorToScreen(".");
    }

    @FXML
    protected void clearAllScreen(){
        screenOperation.setText("");
        if (errorOperation){
            errorMessage.setText("");
            errorOperation = false;
        }
    }

    @FXML
    protected void eraseLastScreen() {
        String currentText = screenOperation.getText();
        int selectionStart = screenOperation.getSelection().getStart();
        int selectionEnd = screenOperation.getSelection().getEnd();
        if (selectionStart == 0 && selectionEnd == currentText.length()) {
            screenOperation.setText("");
        } else {
            // Si no, borrar el último carácter normalmente
            if (wasResolve) {
                wasResolve = false;
            }
            if (errorOperation) {
                errorMessage.setText("");
                errorOperation = false;
            }
            screenOperation.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    @FXML
    protected void resolveOperation(){
        String currentText = screenOperation.getText();
        if(!currentText.isEmpty() && !currentText.equals("-")) {
            Calculator calculator = new Calculator();
            double result;
            try {
                result = calculator.calculate(currentText);
                screenOperation.setText(String.format("%.3f", result));
                wasResolve = true;
            } catch (Exception e) {
                errorOperation = true;
                errorMessage.setText("Fail operation!");
            }
        }
    }

    private void appendNumberToScreen(String text) {
        if (wasResolve){
            clearAllScreen();
            wasResolve = false;
        }
        if (errorOperation){
            errorMessage.setText("");
            errorOperation = false;
        }
        String currentText = screenOperation.getText();
        screenOperation.setText(currentText + text);
    }

    private void appendOperatorToScreen(String text) {
        if (wasResolve){
            wasResolve = false;
        }
        if (errorOperation){
            errorMessage.setText("");
            errorOperation = false;
        }
        String currentText = screenOperation.getText();
        if (!currentText.isEmpty() || text.equals("-")) {
            String[] operation = currentText.split("(?<=[+*/])|(?=[+*/])");
            String operator = operation[operation.length - 1];
            if (text.equals(".")) {
                if (!operator.contains(".") && !operator.equals("-") && !operator.equals("+") && !operator.equals("*") && !operator.equals("/")) {
                    screenOperation.setText(currentText + text);
                }
            }else if (text.equals("-")){
                if (currentText.isEmpty()){
                    screenOperation.setText(currentText+text);
                }else {
                    char c =  operator.charAt(operator.length()-1);
                    if(Character.isDigit(c) || c == '*' || c == '/'){
                        screenOperation.setText(currentText+text);
                    }
                }
            }else {
                if (!operator.equals("-") &&!operator.equals("+") && !operator.equals("*") && !operator.equals("/")) {
                    screenOperation.setText(currentText + text);
                }
            }
        }
    }

    @FXML
    protected void handleKeyPressed(KeyEvent event) {
        String key = event.getText();
        if (event.getCode() == KeyCode.BACK_SPACE) {
            eraseLastScreen();
        } else if (event.getCode() == KeyCode.DECIMAL) {
            putOperatorDecimal();
        } else if (key.matches("[0-9]")) {
            appendNumberToScreen(key);
        } else if (event.getCode() == KeyCode.ADD || event.getCode() == KeyCode.SUBTRACT || event.getCode() == KeyCode.DIVIDE || event.getCode() == KeyCode.MULTIPLY) {
            appendOperatorToScreen(key);
        } else if (event.getCode() == KeyCode.ENTER) {
            resolveOperation();
        }
    }
}