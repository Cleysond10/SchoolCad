package controller;

import Aplicacao.RemTurmaAlunos;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class RemTurmaAlunosController implements Initializable {
    
    @FXML private JFXTextField tfBuscaAluno;
    @FXML private JFXComboBox<String> cbCodTurma;

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void acaoBtRem(ActionEvent event) {
        
    }
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCPF(tfBuscaAluno);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarMascara();
    }

    public void fechar(){
        RemTurmaAlunos.getStage().close();
    }
    
}
