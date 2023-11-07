// Aluno: José Luzia da Silva Neto - TRABALHO FINAL DE POO2
package calculator.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class CalculatorApp extends Application {
    public static void main(String[] args) {
        launch(args); // Método principal que inicia o aplicativo JavaFX
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Carrega o arquivo FXML (interface gráfica) do aplicativo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root = loader.load();

            // Obtém uma instância do controlador associado à interface gráfica
            CalculatorController controller = loader.getController();
            controller.init();

            primaryStage.setTitle("Calculadora"); // Define o título da janela

            // Carrega a imagem do ícone a partir dos recursos
            Image icon = new Image(getClass().getResourceAsStream("/FlatIcon_Calculator.png"));
            primaryStage.getIcons().add(icon); // Define o ícone da janela

            Scene scene = new Scene(root);
            primaryStage.setScene(scene); // Define a cena (conteúdo) da janela
            primaryStage.show(); // Exibe a janela
            primaryStage.setResizable(false); // Impede o redimensionamento da janela

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
