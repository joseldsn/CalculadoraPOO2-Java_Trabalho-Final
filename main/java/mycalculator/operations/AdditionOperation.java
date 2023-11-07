// Aluno: José Luzia da Silva Neto - TRABALHO FINAL DE POO2
package mycalculator.operations;

// Implementação da operação de adição
public class AdditionOperation implements Operation {
    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2; // Realiza a operação de adição entre num1 e num2 e retorna o resultado
    }
}
