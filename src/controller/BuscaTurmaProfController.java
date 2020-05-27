package controller;

import Aplicacao.AltCadAluno;
import Aplicacao.BuscaAluno;
import Aplicacao.BuscaTurmaAluno;
import Aplicacao.BuscaTurmaProf;
import Aplicacao.ListarTurmaAluno;
import Aplicacao.ListarTurmaProf;
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
import tiposdados.Aluno;
import tiposdados.Professor;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class BuscaTurmaProfController implements Initializable {
    
    private Professor prof;    
    @FXML private JFXTextField tfBuscaCPF;

    @FXML
    void acaoBtBuscar(ActionEvent event) {
        prof = new Professor(tfBuscaCPF.getText());
        
        if(MainSchool.getLdeProf().consulta(prof) != null) {
            
            prof = MainSchool.getLdeProf().consulta(prof);
            
            MainSchool.setProf(prof);
            
            ListarTurmaProf ltp = new ListarTurmaProf();
        
            try {
                    ltp.start(new Stage());    		
            }catch(Exception ex) {
                    ex.printStackTrace();
            }
            fechar();
        
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("CPF Inválido!!! \n Tente Novamente");
            alert.show();            
        }
    }

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCPF(tfBuscaCPF);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregarMascara();
    }
    
    public void fechar() {
        BuscaTurmaProf.getStage().close();
    }
    
}
