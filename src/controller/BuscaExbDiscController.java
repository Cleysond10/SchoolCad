package controller;


import Aplicacao.AltCadDisc;
import Aplicacao.BuscaExbAluno;
import Aplicacao.BuscaExbDisc;
import Aplicacao.ExbCadAluno;
import Aplicacao.ExbCadDisc;
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
import tiposdados.Disciplina;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class BuscaExbDiscController implements Initializable {
      
    private Disciplina disc;    
    @FXML private JFXTextField tfCodDisc;

    @FXML
    void acaoBtBuscarExb(ActionEvent event) {
        disc = new Disciplina(tfCodDisc.getText());
        
        if(MainSchool.getLdeDisc().consulta(disc) != null) {
            
            disc = MainSchool.getLdeDisc().consulta(disc);
            
            MainSchool.setDisc(disc);
            
            ExbCadDisc ecd = new ExbCadDisc();
        
            try {
                    ecd.start(new Stage());    		
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
        BuscaExbDisc.getStage().close();
    }
    
}
