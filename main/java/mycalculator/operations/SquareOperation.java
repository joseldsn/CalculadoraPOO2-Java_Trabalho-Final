// Aluno: José Luzia da Silva Neto - TRABALHO FINAL DE POO2
package mycalculator.operations;

// Implementação da operação de elevar ao quadrado
public class SquareOperation implements UnaryOperation {
    @Override
    public double calculate(double num) {
        return num * num; // Retorna o quadrado do número de entrada
    }
}
