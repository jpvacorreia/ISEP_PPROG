package com.mycompany.dn_tp3_1191513_1181600.ui;

import com.mycompany.dn_tp3_1191513_1181600.controller.AplicacaoController;
import com.mycompany.dn_tp3_1191513_1181600.model.Candidatura;
import com.mycompany.dn_tp3_1191513_1181600.model.Tarefa;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.mycompany.dn_tp3_1191513_1181600.model.Seriavel;

public class EscolhaSeriacaoUI implements Initializable {
    public TextField txtTarefaSelecionada;
    public Button btnSeriar;
    public ComboBox<Seriavel> cmbSeriacoes;
    public Button btnCancelar;

    private VisualizarCandidaturasUI visualizarCandidaturasUI;
    private AplicacaoController appCtrl;
    private Tarefa tarefaSelecionada;


    /**
     * Método que inicializa automaticamente algumas funções assim que a janela de escolha
     * de Seriação é apresentada. Neste caso não é executada nenhuma função pois o
     * utilizador é que deve interagir com as opções existentes.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * Este método executa quando o utilizador clica no botão "Cancelar". Despoleta
     * o fecho da janela de escolha de Seriação.
     *
     * @param actionEvent Utilizador clica no botão Seriar
     */
    public void cancelarAction(ActionEvent actionEvent) {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
    }

    /**
     * Método que partilha entre as scenes os seus Controllers.
     * Apresenta a designação da Tarefa na janela criada.
     */
    public void associarParentUI(VisualizarCandidaturasUI visCandidaturasUI) {
        visualizarCandidaturasUI = visCandidaturasUI;
        appCtrl = visualizarCandidaturasUI.getAplicacaoControler();
        txtTarefaSelecionada.setText(tarefaSelecionada.getDesignacao());
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
     * Este método executa quando o utilizador clica no botão "Seriar".
     * Recolhe a Seriação escolhida pelo utilizador e transfere-a para a Controller.
     * A janela de escolha de seriação é encerrada.
     * Pede à Controller para despoletar a seriação das Candidaturas segundo a seriação
     * selecionada e por fim pede à janela de visualização de Candidaturas que
     * imprima novamente a tabela das Candidaturas com as mesmas seriadas e classificadas.
     *
     * @param actionEvent Utilizador clica no botão Seriar
     */
    public void seriarAction(ActionEvent actionEvent) {
        Seriavel seriacaoEscolhida = cmbSeriacoes.getSelectionModel().getSelectedItem();
        appCtrl.transferSeriacaoEscolhida(seriacaoEscolhida);
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        List<Candidatura> lista = visualizarCandidaturasUI.tblCandidaturas.getItems();
        appCtrl.runSeriacao(lista);

        visualizarCandidaturasUI.printCandidaturasSeriadas();
    }

    /**
     * Método que pede ao Controller a lista de Seriações a apresentar
     * na ComboBox e de seguida carregando-os para a mesma.
     */
    public void popularComboBox() {
        List<Seriavel> arraySeriacoes = appCtrl.getListaSeriacoes();
        cmbSeriacoes.getItems().setAll(arraySeriacoes);
        cmbSeriacoes.setValue(arraySeriacoes.get(0));
    }
}
