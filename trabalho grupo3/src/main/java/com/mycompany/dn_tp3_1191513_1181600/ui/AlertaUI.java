package com.mycompany.dn_tp3_1191513_1181600.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class AlertaUI {


    /**
     * Método utilizado para a criação de janelas de alerta. Recebe como parâmetros
     * o tipo de alerta, um título, um cabeçalho indicando o erro e uma mensagem
     * descritiva do que está a faltar para a execução de uma determinada função.
     *
     * @param tipoAlerta tipo de Alert a criar.
     * @param titulo titulo da janela de alerta.
     * @param cabecalho cabeçalho a utilizar na janela de alerta.
     * @param mensagem mensagem sugestiva a apresenta na janela de alerta.
     * @return alerta, objeto da janela de alerta
     */
    public static Alert criarAlerta(Alert.AlertType tipoAlerta, String titulo, String cabecalho, String mensagem) {
        Alert alerta = new Alert(tipoAlerta);
        
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);
        
        if (tipoAlerta == Alert.AlertType.CONFIRMATION) {
            ((Button) alerta.getDialogPane().lookupButton(ButtonType.OK)).setText("Sim");
            ((Button) alerta.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Não");
        }
        return alerta;
    }
}
