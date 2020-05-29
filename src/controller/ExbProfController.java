package controller;

import Aplicacao.ExbCadProf;
import Aplicacao.ExbProf;
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
import tiposdados.Professor;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ExbProfController implements Initializable {
    
    private Professor prof;
    @FXML private JFXTextField tfBuscCpf;
    
    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void btBusc(ActionEvent event) {
        prof = new Professor(tfBuscCpf.getText());


        if(MainSchool.getLdeProf().consulta(prof) != null) {

            prof = MainSchool.getLdeProf().consulta(prof);
            MainSchool.setProf(prof);

            ExbCadProf ecp = new ExbCadProf();

            try {
                    ecp.start(new Stage());
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
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCPF(tfBuscCpf);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarMascara();
    }    
    
    public void fechar() {
        ExbProf.getStage().close();
    }
    
}
