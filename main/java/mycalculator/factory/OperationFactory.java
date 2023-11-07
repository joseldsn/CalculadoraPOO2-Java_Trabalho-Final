// Aluno: José Luzia da Silva Neto - TRABALHO FINAL DE POO2
package mycalculator.factory;

import mycalculator.operations.*;

import java.util.HashMap;
import java.util.Map;

// Factory para criar operações (Factory Pattern)
public class OperationFactory {
    private final Map<String, Operation> operations; // Map que associa operadores a implementações de operações

    public OperationFactory() {
        operations = new HashMap<>();
        operations.put("+", new AdditionOperation()); // Associa o operador "+" à operação de adição
        operations.put("-", new SubtractionOperation()); // Associa o operador "-" à operação de subtração
        operations.put("*", new MultiplicationOperation()); // Associa o operador "*" à operação de multiplicação
        operations.put("/", new DivisionOperation()); // Associa o operador "/" à operação de divisão
        operations.put("square", new UnaryOperationAdapter(new SquareOperation())); // Associa o operador "square" à operação de quadrado
        operations.put("sqrt", new UnaryOperationAdapter(new SquareRootOperation())); // Associa o operador "sqrt" à operação de raiz quadrada
    }

    public Operation getOperation(String operator) {
        return operations.get(operator); // Obtém a implementação da operação com base no operador
    }
}
