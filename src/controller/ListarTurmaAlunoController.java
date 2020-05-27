package controller;

import Aplicacao.ExbCadTurma;
import Aplicacao.ListarTurmaAluno;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tiposdados.Turma;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ListarTurmaAlunoController implements Initializable {
    
    @FXML private JFXListView<Turma> listaTurmasAluno;
    ObservableList<Turma> obsTurmaAluno = FXCollections.observableArrayList();

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    @FXML
    void AcaoDaLista(MouseEvent event) {
    	Turma cLista = listaTurmasAluno.getSelectionModel().getSelectedItem();
    	if(cLista == null /*|| cLista.isEmpty()*/) {
            //fieldCarregar.setText("Lista Vazia");
    	}
    	else {
            Turma a;
            a = listaTurmasAluno.getSelectionModel().getSelectedItem();            
            MainSchool.setTurma(a);
            
            ExbCadTurma ect = new ExbCadTurma();

            try {
                ect.start(new Stage());    		
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            fechar();
    	}
    }
    
    public void carregarList(){
        Turma[] vTurma = MainSchool.getAlunoPP().getTurmas();
        Turma t = new Turma("", "");        
        if (vTurma.length == 0){
            System.out.println("LISTA VAZIA");
        } else{
            Turma[] vTurmaTest = new Turma[vTurma.length];
            for(int i = 0; i < vTurma.length; i++) {
                if(vTurma[i] == null) {
                    vTurmaTest[i] = t;
                }
                else {
                    vTurmaTest[i] = vTurma[i];
                }
            }
            obsTurmaAluno.addAll(vTurmaTest);
            listaTurmasAluno.setItems(obsTurmaAluno);
        }        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarList();
    }
    
    public void fechar() {
        ListarTurmaAluno.getStage().close();
    }
    
}
