package com.mycompany.dn_tp3_1191513_1181600.ui;

import com.mycompany.dn_tp3_1191513_1181600.controller.AplicacaoController;
import com.mycompany.dn_tp3_1191513_1181600.model.Colaborador;
import com.mycompany.dn_tp3_1191513_1181600.model.Tarefa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import java.util.List;
import java.util.ResourceBundle;

public class JanelaPrincipalUI implements Initializable {


    public ComboBox<Colaborador> cmbColaborador;
    public Button btnCandidaturas;
    public TableColumn<Tarefa, String> colReferencia;
    public TableColumn<Tarefa, String> colDesignacao;
    public TableColumn<Tarefa, String> colDescInformal;
    public TableColumn<Tarefa, String> colDescTecnica;
    public TableColumn<Tarefa, String> colDuracao;
    public TableColumn<Tarefa, String> colCusto;
    private AplicacaoController appController;
    private Stage TarefasStage;
    @FXML
    private TableView<Tarefa> tblTarefas;

    private FXMLLoader loader;

    /**
     * Este método executa quando o utilizador clica no botão "Candidaturas". Se uma Tarefa
     * for selecionada, abre nova janela com as Candidaturas existentes à Tarefa.
     * Caso não exista um Colaborador ou Tarefa selecionada, o botão abre uma janela de erro
     * com mensagem sugestiva.
     *
     * @param actionEvent Utilizador clica no botão Candidaturas
     */
    public void getCandidaturasAction(ActionEvent actionEvent) {
        Tarefa tarefaSelecionada = tblTarefas.getSelectionModel().getSelectedItem();
        if (cmbColaborador.getSelectionModel().getSelectedItem() == null) {
            AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, "Candidaturas", "Colaborador não selecionado.",
                    String.format("Pff selecione um Colaborador e respetiva Tarefa de modo a apresentar as suas Candidaturas.")).show();
        } else if (tarefaSelecionada == null) {
            AlertaUI.criarAlerta(Alert.AlertType.INFORMATION, "Candidaturas", "Tarefa não seleccionada",
                    "Pff selecione Tarefa de forma a apresentar as suas Candidaturas").show();
        } else {
            loadVisualizarCandidaturas(tarefaSelecionada);
        }
    }

    /**
     * Método que inicializa automaticamente algumas funções assim que a janela principal
     * é apresentada. Neste caso, está a ser feito o carregamento em memória da janela de
     * visualização das Candidaturas à Tarefa selecionada.
     * Além disse, está a ser feito o carregamento dos Colaboradores na ComboBox existente
     * no topo da janela
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appController = new AplicacaoController();
        try {
            loader = new FXMLLoader(getClass().getResource("/fxml/VisualizarCandidaturasScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            TarefasStage = new Stage();
            TarefasStage.initModality(Modality.APPLICATION_MODAL);
            TarefasStage.setTitle("Candidaturas");
            TarefasStage.setResizable(true);
            TarefasStage.setScene(scene);

        } catch (IOException e) {
            AlertaUI.criarAlerta(Alert.AlertType.ERROR, "Erro", "Candidaturas", e.getMessage());
        }
        popularComboBox();
    }

    /**
     * Método que pede ao Controller a lista de colaboradores a apresentar
     * na ComboBox e de seguida carregando-os para a mesma.
     */
    public void popularComboBox() {
        List<Colaborador> arrayColabs = appController.getListaColaboradores();
        cmbColaborador.getItems().setAll(arrayColabs);
    }

    /**
     * Método que carrega em memória os atributos do Colaborador passado por parâmetro
     * na respetiva coluna da tabela da janela. Apresenta os dados carregados.
     *
     * @param colab Colaborador do qual se vai apresentar as Tarefas.
     */
    public void apresentarTarefas(Colaborador colab) {
        colReferencia.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("referencia"));
        colDesignacao.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("designacao"));
        colDescInformal.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("descricaoInformal"));
        colDescTecnica.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("descricaoCaracterTecnico"));
        colDuracao.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("duracao"));
        colCusto.setCellValueFactory(new PropertyValueFactory<Tarefa, String>("custo"));

        tblTarefas.setItems(getTarefas(colab));
    }

    /**
     * Método que pede ao Controller as Tarefas do Colaborador passado por parâmetro
     * e guarda-as numa lista observável necessária para ser imprimida na tabela.
     *
     * @param colab Colaborador do qual se vai apresentar as Tarefas.
     * @return tarefas Lista Observável que será utilizada para imprimir a tabela.
     */
    public ObservableList<Tarefa> getTarefas(Colaborador colab) {
        ObservableList<Tarefa> tarefas = FXCollections.observableArrayList();
        tarefas.addAll(appController.getListaTarefasDoColaborador(colab));
        return tarefas;
    }

    /**
     * Método que despoleta a apresentação das Tarefas de um determinado Colaborador
     * ao ser selecionado na lista existente da ComboBox.
     */
    @FXML
    private void handleComboBoxAction() {
        Colaborador selectedColaborador = cmbColaborador.getSelectionModel().getSelectedItem();
        apresentarTarefas(selectedColaborador);
    }

    /**
     * Método que retorna a instância do Controller da janela principal de apresentação de Tarefas.
     *
     * @return appController AplicacaoController da janela principal.
     */
    public AplicacaoController getAplicacaoControler() {
        return appController;
    }

    /**
     * Método que despoleta o aparecimento da janela de visualização das Candidaturas à Tarefa
     * selecionada, transmite-lhe a informação de qual a Tarefa efetivamente selecionada pelo
     * utilizador e despoleta a apresentação das Candidaturas à Tarefa.
     */
    public void loadVisualizarCandidaturas(Tarefa tarefaSelecionada) {
        TarefasStage.show();

        VisualizarCandidaturasUI visCandidaturasUI = loader.getController();
        visCandidaturasUI.transferTarefaSelecionada(tarefaSelecionada);
        visCandidaturasUI.associarParentUI(this);

        visCandidaturasUI.apresentarCandidaturas();
    }
}

