package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Aplicacao.AltCadProf;
import Aplicacao.AltProf;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import tidosdados.Professor;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AltProfController implements Initializable {
    
    @FXML private JFXTextField tfBuscaCPF;
    private Professor prof;

    @FXML
    void acaoBtBuscar(ActionEvent event) {
        
        prof = new Professor(tfBuscaCPF.getText());
        
        if(MainSchool.getLdeProf().consulta(prof) != null) {

            prof = MainSchool.getLdeProf().consulta(prof);
            MainSchool.setProf(prof);

            AltCadProf acp = new AltCadProf();

            try {
                    acp.start(new Stage());
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
        AltProf.getStage().close();
    }
    
}