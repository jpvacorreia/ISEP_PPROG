package com.mycompany.dn_tp3_1191513_1181600.ui;

import com.mycompany.dn_tp3_1191513_1181600.model.LerFicheirosTexto;
import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class MainApp extends Application {

    public static final String TITULO_APLICACAO = "Tarefas";

    /**
     * Método que inicia o script deste projeto. Lê os ficheiros de texto e cria as
     * instâncias das classes criadas. Carrega para memória o ficheiro fxml com a
     * janela principal que possibilita a escolha do Colaborador e seleção das
     * Tarefas deste. Por fim, apresenta esta janela ao utilizador.
     */
    @Override
    public void start(Stage stage) throws Exception {
        LerFicheirosTexto.lerFicheirosCriacao();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/JanelaPrincipalScene.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle(TITULO_APLICACAO);
        stage.setScene(scene);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alerta = AlertaUI.criarAlerta(Alert.AlertType.CONFIRMATION, TITULO_APLICACAO,
                        "Confirmação da ação.", "Deseja mesmo encerrar a aplicação?");

                if (alerta.showAndWait().get() == ButtonType.CANCEL) {
                    event.consume();
                }
            }
        });


        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
