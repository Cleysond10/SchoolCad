package controller;

import Aplicacao.AltCadTurma;
import Aplicacao.AltTurma;
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
 * @author Lenovo
 */
public class AltTurmaController implements Initializable {
    
    private Turma turma;
    
    @FXML private JFXTextField tfBuscaCodTurma;

    @FXML
    void acaoBtBuscar(ActionEvent event) {
        turma = new Turma(tfBuscaCodTurma.getText(), "");
        
        if(MainSchool.getLdeTurma().consulta(turma) != null) {
            
            turma = MainSchool.getLdeTurma().consulta(turma);
            //System.out.println(MainSchool.getLdeAlunoPP());
            MainSchool.setTurma(turma);
            
            AltCadTurma act = new AltCadTurma();
            
            try {
                    act.start(new Stage());    		
            }catch(Exception ex) {
                    ex.printStackTrace();
            }
            fechar();
        
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("Código Inválido!!! \n Tente Novamente");
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
        carregarMascara();
    }    
    
    public void fechar() {
        AltTurma.getStage().close();
    }
    
}
