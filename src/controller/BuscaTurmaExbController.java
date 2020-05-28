package controller;

import Aplicacao.BuscaTurmaExb;
import Aplicacao.ExbTurma;
import Aplicacao.ExbTurmaCad;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import tiposdados.Turma;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class BuscaTurmaExbController implements Initializable {
    
    private Turma turma;    
    @FXML private JFXTextField tfBuscaCodTurma;

    @FXML
    void acaoBtBuscar(ActionEvent event) {
        turma = new Turma(tfBuscaCodTurma.getText(), "");
        
        if(MainSchool.getLdeTurma().consulta(turma) != null) {
            
            turma = MainSchool.getLdeTurma().consulta(turma);
            
            MainSchool.setTurma(turma);
            
            ExbTurmaCad et = new ExbTurmaCad();
        
            try {
                    et.start(new Stage());    		
            }catch(Exception ex) {
                    ex.printStackTrace();
            }
            fechar();
        
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("Código da Turma Inválido!!! \n Tente Novamente");
            alert.show();            
        }
    }

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCodTurma(tfBuscaCodTurma);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregarMascara();
    }
    
    public void fechar() {
        BuscaTurmaExb.getStage().close();
    }
    
}
