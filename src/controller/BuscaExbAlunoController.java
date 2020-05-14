package controller;


import Aplicacao.BuscaExbAluno;
import Aplicacao.ExbCadAluno;
import Aplicacao.MainSchool;
import Aplicacao.RemoverAluno;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import tidosdados.Aluno;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class BuscaExbAlunoController implements Initializable {
      
    private Aluno aluno;
    @FXML private JFXTextField tfBuscaCPF;

    @FXML
    void acaoBtBuscarExb(ActionEvent event) {
        
        aluno = new Aluno(tfBuscaCPF.getText());
        
        
        if(MainSchool.getLdeAlunoPP().consulta(aluno) != null) {
            
            aluno = MainSchool.getLdeAlunoPP().consulta(aluno);        
            MainSchool.setAlunoPP(aluno);

            ExbCadAluno aca = new ExbCadAluno();

            try {
                    aca.start(new Stage());    		
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
        BuscaExbAluno.getStage().close();
    }
    
}
