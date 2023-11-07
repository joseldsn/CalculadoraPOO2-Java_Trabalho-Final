// Aluno: José Luzia da Silva Neto - TRABALHO FINAL DE POO2
package mycalculator.operations;

// Implementação da operação de divisão
public class DivisionOperation implements Operation {
    @Override
    public double calculate(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida."); // Verifica se o divisor (num2) é zero e lança uma exceção em caso True
        }
        return num1 / num2; // Realiza a operação de divisão entre num1 e num2 e retorna o resultado
    }
}
