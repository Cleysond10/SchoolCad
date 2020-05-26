package controller;

import Aplicacao.CadTurmaAlunos;
import Aplicacao.CadTurmaMenu;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXTextField;
import interfaceValidacao.MascaraFX;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import tiposdados.Aluno;
import tiposdados.Turma;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class CadTurmaAlunosController implements Initializable {

    @FXML private ComboBox<Turma> cbCodTurma;
    @FXML private JFXTextField tfAlunos;
    @FXML private Button btInserir;
    @FXML private Button btVoltar;
    
    private Aluno aluno;
    
    ObservableList<Turma> obsTurmas = FXCollections.observableArrayList();

    @FXML
    void ActionBtInserir(ActionEvent event) {
        
        aluno = new Aluno(tfAlunos.getText());
        
        if(MainSchool.getLdeAlunoPP().consulta(aluno) != null) {
            
            aluno = MainSchool.getLdeAlunoPP().consulta(aluno);
            
            Aluno[] vAlunoTurmas = cbCodTurma.getSelectionModel().getSelectedItem().getAlunos();
            int cont = 0;
            for (int i = 0; i < vAlunoTurmas.length; i++){
                if (vAlunoTurmas[i] != null){
                    cont++;
                }
            }
            vAlunoTurmas[cont] = aluno;
            cbCodTurma.getSelectionModel().getSelectedItem().setAlunos(vAlunoTurmas);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("VALIDAÇÃO");
            alert.setContentText("Cadastro Realizado com Sucesso!");
            alert.show(); 
            
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
    void ActionBtVoltar(ActionEvent event) {
        CadTurmaMenu ctm = new CadTurmaMenu();

        try {
            ctm.start(new Stage());
        }catch(Exception ex) {
            ex.printStackTrace();
        }
                
        fechar();
    }
    
    public void carregarCB(){
        Turma[] vTurmas = MainSchool.getLdeTurma().listaTurma();
        if (vTurmas.length == 0){
            System.out.println("LISTA VAZIA");
        } else{
            obsTurmas.addAll(vTurmas);
            cbCodTurma.setItems(obsTurmas);
        }
        
    }
    
    public void carregarMascara() {
        MascaraFX mascara = new MascaraFX();
        mascara.mascaraCPF(tfAlunos);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarCB();
        carregarMascara();
    }    
    
    public void fechar() {
        CadTurmaAlunos.getStage().close();
    }
    
}
