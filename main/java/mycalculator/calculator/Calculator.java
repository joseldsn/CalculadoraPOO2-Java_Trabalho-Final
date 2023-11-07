// Aluno: José Luzia da Silva Neto - TRABALHO FINAL DE POO2
package mycalculator.calculator;

import mycalculator.factory.OperationFactory;
import mycalculator.operations.Operation;

// Classe que segue o Template Method Pattern
public class Calculator {
    private final OperationFactory operationFactory; // Instância de OperationFactory para obter operações

    public Calculator() {
        this.operationFactory = new OperationFactory(); // Inicializa a OperationFactory
    }

    // O método calculate utiliza a OperationFactory para obter a operação com base no operador passado como argumento
    public double calculate(double num1, double num2, String operator) {
        Operation operation = operationFactory.getOperation(operator); // Obtém a operação da OperationFactory

        if (operation == null) {
            throw new IllegalArgumentException("Operador inválido: " + operator); // Lança uma exceção se o operador for inválido
        }

        return operation.calculate(num1, num2); // Realiza o cálculo usando a operação obtida da OperationFactory
    }
}
