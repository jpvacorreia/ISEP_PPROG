package com.mycompany.dn_tp3_1191513_1181600.ui;

import com.mycompany.dn_tp3_1191513_1181600.controller.AplicacaoController;
import com.mycompany.dn_tp3_1191513_1181600.model.Candidatura;
import com.mycompany.dn_tp3_1191513_1181600.model.Tarefa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VisualizarCandidaturasUI implements Initializable {
    public TextField txtTarefaId;
    public Button btnSeriarCandidaturasTarefa;
    private JanelaPrincipalUI janelaPrincipalUI;
    private AplicacaoController appCtrl;
    private Tarefa tarefaSelecionada;
    private FXMLLoader loader;

    public TableColumn<Candidatura, String> colValor;
    public TableColumn<Candidatura, String> colDuracao;
    public TableColumn<Candidatura, String> colTextoApresentacao;
    public TableColumn<Candidatura, String> colTextoMotivacao;
    public TableColumn<Candidatura, String> colClassificacao;
    public TableView<Candidatura> tblCandidaturas;
    private Stage EscolhaSeriacaoStage;


    /**
     * Este método executa quando o utilizador clica no botão "Seriar". Despoleta a
     * apresentação da janela que permite ao utilizador escolher que tipo de seriação
     * pretende utilizar para na classificação das Candidaturas.
     * Transfere também a Tarefa selecionada para a janela apresentada de forma a
     * que possa ser apresentada a sua designação.
     *
     * @param actionEvent Utilizador clica no botão Seriar
     */
    public void seriarCandidaturasAction(ActionEvent actionEvent) {
        EscolhaSeriacaoStage.show();

        EscolhaSeriacaoUI escolhaSeriacaoUI = loader.getController();
        escolhaSeriacaoUI.transferTarefaSelecionada(tarefaSelecionada);
        escolhaSeriacaoUI.associarParentUI(this);
        escolhaSeriacaoUI.popularComboBox();
    }

    /**
     * Método que inicializa automaticamente algumas funções assim que a janela de visualizar
     * as Candidaturas é apresentada. Neste caso, está a ser feito o carregamento em memória da
     * janela que permite ao utilizador escolher o tipo de seriação.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loader = new FXMLLoader(getClass().getResource("/fxml/EscolhaSeriacaoScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            EscolhaSeriacaoStage = new Stage();
            EscolhaSeriacaoStage.initModality(Modality.APPLICATION_MODAL);
            EscolhaSeriacaoStage.setTitle("Candidaturas");
            EscolhaSeriacaoStage.setResizable(true);
            EscolhaSeriacaoStage.setScene(scene);

        } catch (IOException e) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Erro","Escolha Seriação", e.getMessage());
        }
    }

    /**
     * Método que partilha entre as scenes os seus Controllers.
     * Apresenta a designação da Tarefa na janela criada.
     */
    public void associarParentUI(JanelaPrincipalUI janelaPrincUI) {
        janelaPrincipalUI = janelaPrincUI;
        appCtrl = janelaPrincipalUI.getAplicacaoControler();
        txtTarefaId.setText(tarefaSelecionada.getDesignacao());
    }

    /**
     * Método que recebe e guarda como atributo a tarefa selecionada na janela principal.
     *
     * @param tarefaSelecionada Tarefa selecionada pelo utilizador na janela principal.
     */
    public void transferTarefaSelecionada(Tarefa tarefaSelecionada) {
        this.tarefaSelecionada = tarefaSelecionada;
    }

    /**
     * Método utilizado para associar as colunas da tabela da janela de visualização das
     * Candidaturas aos atributos destas.
     * Imprime na tabela as informações das Candidaturas.
     */
    public void apresentarCandidaturas() {
        colValor.setCellValueFactory(new PropertyValueFactory<Candidatura, String>("custo"));
        colDuracao.setCellValueFactory(new PropertyValueFactory<Candidatura, String>("dias"));
        colTextoApresentacao.setCellValueFactory(new PropertyValueFactory<Candidatura, String>("textoApresentacao"));
        colTextoMotivacao.setCellValueFactory(new PropertyValueFactory<Candidatura, String>("textoMotivacao"));
        colClassificacao.setCellValueFactory((new PropertyValueFactory<Candidatura, String>("classificacao")));

        tblCandidaturas.setItems(getCandidaturas(tarefaSelecionada));
    }

    /**
     * Método que pede ao Controller a lista de Candidaturas de uma determinada Tarefa
     * passada por parâmetro e cria uma lista observável necessária para ser imprimida na tabela.
     *
     * @param tarefaSelecionada Tarefa selecionada pelo utilizador
     * @return candidaturas Lista observável que será utilizada para imprimir a tabela.
     */
    public ObservableList<Candidatura> getCandidaturas(Tarefa tarefaSelecionada) {
        ObservableList<Candidatura> candidaturas = FXCollections.observableArrayList();
        candidaturas.addAll(appCtrl.getListaCandidaturasTarefa(tarefaSelecionada));
        return candidaturas;
    }

    /**
     * Método que retorna a instância do Controller da janela de visualização das Candidaturas
     * à Tarefa selecionada.
     *
     * @return appCtrl AplicacaoController da janela principal.
     */
    public AplicacaoController getAplicacaoControler() {
        return appCtrl;
    }

    /**
     * Método limpa a tabela e imprime nesta as Candidaturas após a sua seriação.
     */
    public void printCandidaturasSeriadas() {
        ObservableList<Candidatura> candidaturas = FXCollections.observableArrayList();
        candidaturas.addAll(appCtrl.getListaCandidaturasSeriadas());
        tblCandidaturas.getItems().clear();
        tblCandidaturas.setItems(candidaturas);

    }

}
