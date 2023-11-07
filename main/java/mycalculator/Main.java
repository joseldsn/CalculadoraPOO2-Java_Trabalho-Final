// Aluno: José Luzia da Silva Neto - TRABALHO FINAL DE POO2
package mycalculator;

import mycalculator.calculator.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite o primeiro número (ou 'q' para sair): ");
            String input = scanner.nextLine();
            if ("q".equalsIgnoreCase(input)) {
                break;
            }

            double num1 = Double.parseDouble(input);

            System.out.print("Digite o operador (+, -, *, /, sqrt, square): ");
            String operator = scanner.nextLine();

            double num2 = 0.0;
            if (!"sqrt".equals(operator) && !"square".equals(operator)) {
                System.out.print("Digite o segundo número: ");
                num2 = Double.parseDouble(scanner.nextLine());
            }

            try {
                double result = calculator.calculate(num1, num2, operator);
                System.out.println("Resultado: " + result);
            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }

        System.out.println("Calculadora encerrada.");
    }
}
