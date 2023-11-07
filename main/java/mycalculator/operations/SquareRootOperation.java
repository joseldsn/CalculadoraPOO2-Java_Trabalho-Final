// Aluno: José Luzia da Silva Neto - TRABALHO FINAL DE POO2
package mycalculator.operations;

// Implementação da operação de raiz quadrada
public class SquareRootOperation implements UnaryOperation {
    @Override
    public double calculate(double num) {
        if (num < 0) {
            throw new ArithmeticException("Raiz quadrada de número negativo não é permitida.");
        }
        return Math.sqrt(num); // Calcula e retorna a raiz quadrada do número de entrada
    }
}
