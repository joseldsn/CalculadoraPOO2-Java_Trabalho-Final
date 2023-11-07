// Aluno: José Luzia da Silva Neto - TRABALHO FINAL DE POO2
package calculator.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import mycalculator.calculator.Calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
    private Calculator calculator; // Instância da classe Calculator para realizar cálculos

    @FXML
    private TextField textField; // Campo de texto onde os números e resultados são exibidos

    @FXML
    private Text savedNumbers; // Área de texto para exibir os números salvos e o histórico de operações

    private String firstNumber = ""; // Variável para armazenar o primeiro número da operação
    private String currentNumber = ""; // Variável para armazenar o número atual
    private String calculationType = ""; // Variável para armazenar o tipo de operação

    private List<String> savedNumberList = new ArrayList<>(); // Lista para armazenar números e operações no histórico

    public CalculatorController() {
        calculator = new Calculator(); // Inicializa a classe Calculator para realizar cálculos
    }

    @FXML
    void performOperation() {
        savedNumberList.clear(); // Limpa o histórico de números e operações
        savedNumbers.setText(""); // Limpa a área de texto de exibição

        // Verifica se algum dos campos necessários está vazio
        if (currentNumber.isEmpty() || firstNumber.isEmpty() || calculationType.isEmpty()) {
            return;
        }

        double num1 = Double.parseDouble(firstNumber); // Converte o primeiro número em double
        double num2 = Double.parseDouble(currentNumber); // Converte o número atual em double

        try {
            double result = calculator.calculate(num1, num2, calculationType);
            displayResult(num1, num2, calculationType, result); // Exibe o resultado na interface
        } catch (IllegalArgumentException e) {
            savedNumbers.setText("Erro: " + e.getMessage());
        }
    }

    @FXML
    void setAdditionOperation() {
        if (!currentNumber.isEmpty()) {
            firstNumber = currentNumber;
            currentNumber = "";
            textField.clear();
        }
        calculationType = "+"; // Define a operação de adição

        savedNumberList.add(calculationType);
        savedNumbers.setText(String.join(" ", savedNumberList));
    }

    @FXML
    void setSubtractionOperation() {
        if (!currentNumber.isEmpty()) {
            firstNumber = currentNumber;
            currentNumber = "";
            textField.clear();
        }
        calculationType = "-"; // Define a operação de subtração

        savedNumberList.add(calculationType);
        savedNumbers.setText(String.join(" ", savedNumberList));
    }

    @FXML
    void setMultiplicationOperation() {
        if (!currentNumber.isEmpty()) {
            firstNumber = currentNumber;
            currentNumber = "";
            textField.clear();
        }
        calculationType = "*"; // Define a operação de multiplicação

        savedNumberList.add(calculationType);
        savedNumbers.setText(String.join(" ", savedNumberList));
    }

    @FXML
    void setDivisionOperation() {
        if (!currentNumber.isEmpty()) {
            firstNumber = currentNumber;
            currentNumber = "";
            textField.clear();
        }
        calculationType = "/"; // Define a operação de divisão

        savedNumberList.add(calculationType);
        savedNumbers.setText(String.join(" ", savedNumberList));
    }

    @FXML
    void clearTextField() {
        currentNumber = "";
        firstNumber = "";
        calculationType = "";
        textField.clear(); // Limpa o campo de texto
        savedNumberList.clear(); // Limpa a lista de histórico
        savedNumbers.setText(""); // Limpa a área de texto de exibição
    }

    @FXML
    void addNumber(ActionEvent event) {
        Button button = (Button) event.getSource();
        String number = button.getText();

        // Verifica se há um número atual ou se o número atual não é zero
        if (currentNumber.length() > 0 || !number.equals("0")) {
            savedNumberList.clear();
        }

        currentNumber += number;
        textField.setText(currentNumber); // Exibe o número atual no campo de texto

        savedNumberList.add(currentNumber); // Adiciona o número atual à lista de histórico
        savedNumbers.setText(currentNumber); // Exibe o número atual na área de texto
    }

    public void displayResult(double num1, double num2, String operation, double result) {
        String calculation;
        if (result < 0) {
            calculation = num1 + " " + operation + " " + num2 + " = " + result;
            savedNumberList.add(calculation);
            savedNumbers.setText(String.join("\n", savedNumberList));
            textField.clear();
        } else {
            calculation = num1 + " " + operation + " " + num2 + " = ";
            savedNumberList.add(calculation);
            savedNumbers.setText(String.join("\n", savedNumberList));
            textField.setText(String.valueOf(result));
        }
        firstNumber = String.valueOf(result); // Atualiza o primeiro número com o resultado
        currentNumber = ""; // Limpa o número atual
    }

    public void init() {
        textField.setEditable(false); // Torna o campo de texto somente leitura
    }
}
