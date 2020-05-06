/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Aplicacao.AltCadAluno;
import Aplicacao.RemoverAluno;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Neto
 */
public class BuscaAlunoController implements Initializable {
      

    @FXML private JFXTextField tfBuscaCPF;

    @FXML
    void acaoBtBuscar(ActionEvent event) {
        AltCadAluno aca = new AltCadAluno();
        
        try {
    		aca.start(new Stage());    		
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
        fechar();

    }

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void fechar() {
        RemoverAluno.getStage().close();
    }
    
}
