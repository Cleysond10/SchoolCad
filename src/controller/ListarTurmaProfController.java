package controller;

import Aplicacao.ExbTurmaCad;
import Aplicacao.ListarTurmaProf;
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
public class ListarTurmaProfController implements Initializable {
    
    @FXML private JFXListView<Turma> listaTurmasProf;
    ObservableList<Turma> obsTurmaProf = FXCollections.observableArrayList();

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    @FXML
    void AcaoDaLista(MouseEvent event) {
    	Turma cLista = listaTurmasProf.getSelectionModel().getSelectedItem();
    	if(cLista == null /*|| cLista.isEmpty()*/) {
            //fieldCarregar.setText("Lista Vazia");
    	}
    	else {
            Turma a;
            a = listaTurmasProf.getSelectionModel().getSelectedItem();            
            MainSchool.setTurma(a);
            
            ExbTurmaCad ect = new ExbTurmaCad();

            try {
                ect.start(new Stage());    		
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            fechar();
    	}
    }
    
    public void carregarList(){
        Turma[] vTurma = MainSchool.getProf().getTurmas();
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
            obsTurmaProf.addAll(vTurmaTest);
            listaTurmasProf.setItems(obsTurmaProf);
        }        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarList();
    }
    
    public void fechar() {
        ListarTurmaProf.getStage().close();
    }
    
}
