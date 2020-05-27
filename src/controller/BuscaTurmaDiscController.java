package controller;

import Aplicacao.BuscaTurmaDisc;
import Aplicacao.ListarTurmaDisc;
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
import tiposdados.Disciplina;


/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class BuscaTurmaDiscController implements Initializable {
    
    private Disciplina disc;    
    @FXML private JFXTextField tfBuscaCPF;

    @FXML
    void acaoBtBuscar(ActionEvent event) {
        disc = new Disciplina(tfBuscaCPF.getText());
        
        if(MainSchool.getLdeDisc().consulta(disc) != null) {
            
            disc = MainSchool.getLdeDisc().consulta(disc);
            
            MainSchool.setDisc(disc);
            
            ListarTurmaDisc ltd = new ListarTurmaDisc();
        
            try {
                    ltd.start(new Stage());    		
            }catch(Exception ex) {
                    ex.printStackTrace();
            }
            fechar();
        
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("Código da Disciplina Inválida!!! \n Tente Novamente");
            alert.show();            
        }
    }

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCodDisc(tfBuscaCPF);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.carregarMascara();
    }
    
    public void fechar() {
        BuscaTurmaDisc.getStage().close();
    }
    
}
