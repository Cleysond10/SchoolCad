package controller;

import Aplicacao.ExbTurmaCad;
import Aplicacao.ListarTurma;
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
public class ListarTurmaController implements Initializable {
    
    @FXML private JFXListView<Turma> listaTurmas;
    ObservableList<Turma> obsTurma = FXCollections.observableArrayList();

    @FXML
    void acaoBtCancelar(ActionEvent event) {

    }
    
    @FXML
    void AcaoDaLista(MouseEvent event) {
    	Turma cLista = listaTurmas.getSelectionModel().getSelectedItem();
    	if(cLista == null /*|| cLista.isEmpty()*/) {
            //fieldCarregar.setText("Lista Vazia");
    	}
    	else {
            Turma a;
            a = listaTurmas.getSelectionModel().getSelectedItem();            
            MainSchool.setTurma(a);
            
            ExbTurmaCad etc = new ExbTurmaCad();

            try {
                etc.start(new Stage());    		
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            fechar();
    	}
    }
    
    public void carregarList(){
        Turma[] vTurma = MainSchool.getLdeTurma().listaTurma();
        if (vTurma.length == 0){
            System.out.println("LISTA VAZIA");
        } else{
            obsTurma.addAll(vTurma);
            listaTurmas.setItems(obsTurma);
        }        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarList();
    }
    
    public void fechar() {
        ListarTurma.getStage().close();
    }
    
}
