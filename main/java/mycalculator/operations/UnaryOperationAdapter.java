// Aluno: José Luzia da Silva Neto - TRABALHO FINAL DE POO2
package mycalculator.operations;

// Adapter Pattern para operações unárias
public class UnaryOperationAdapter implements Operation {
    private final UnaryOperation unaryOperation;

    public UnaryOperationAdapter(UnaryOperation unaryOperation) {
        this.unaryOperation = unaryOperation;
    }

    @Override
    public double calculate(double num1, double num2) {
        // Ignora num2 e usa apenas num1 para operações unárias
        return unaryOperation.calculate(num1);
    }
}
