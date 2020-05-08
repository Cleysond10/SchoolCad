package controller;


import Aplicacao.BuscaExbAluno;
import Aplicacao.ExbCadAluno;
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
 * @author Neto e Cleyson
 */
public class BuscaExbAlunoController implements Initializable {
      

    @FXML private JFXTextField tfBuscaCPF;

    @FXML
    void acaoBtBuscar(ActionEvent event) {
        ExbCadAluno aca = new ExbCadAluno();
        
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
        BuscaExbAluno.getStage().close();
    }
    
}
