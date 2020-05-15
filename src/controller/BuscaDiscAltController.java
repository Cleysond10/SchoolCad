/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Aplicacao.AltCadAluno;
import Aplicacao.AltCadDisc;
import Aplicacao.BuscaAluno;
import Aplicacao.BuscaDiscAlt;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXTextField;
import estruturadados.LDE;
import interfaceValidacao.MascaraFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import tiposdados.Aluno;
import tiposdados.Disciplina;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class BuscaDiscAltController implements Initializable {
    
    private Disciplina disc;    
    @FXML private JFXTextField tfCodDisc;

    @FXML
    void acaoBtBuscar(ActionEvent event) {
        disc = new Disciplina(tfCodDisc.getText());
        
        if(MainSchool.getLdeDisc().consulta(disc) != null) {
            
            disc = MainSchool.getLdeDisc().consulta(disc);
            
            MainSchool.setDisc(disc);
            
            AltCadDisc acd = new AltCadDisc();
        
            try {
                    acd.start(new Stage());    		
            }catch(Exception ex) {
                    ex.printStackTrace();
            }
            fechar();
        
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("Código da Disciplina Inválido!!! \n Tente Novamente");
            alert.show();            
        }
    }

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCodDisc(tfCodDisc);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregarMascara();
    }
    
    public void fechar() {
        BuscaDiscAlt.getStage().close();
    }
    
}
