package controller;


import Aplicacao.ExbTurmaCad;
import Aplicacao.ListarTurmaDisc;
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
public class ListarTurmaDiscController implements Initializable {
    
    @FXML private JFXListView<Turma> listaTurmasDisc;
    ObservableList<Turma> obsTurmaDisc = FXCollections.observableArrayList();

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    @FXML
    void AcaoDaLista(MouseEvent event) {
    	Turma cLista = listaTurmasDisc.getSelectionModel().getSelectedItem();
    	if(cLista == null /*|| cLista.isEmpty()*/) {
            //fieldCarregar.setText("Lista Vazia");
    	}
    	else {
            Turma a;
            a = listaTurmasDisc.getSelectionModel().getSelectedItem();            
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
        Turma[] vTurma = MainSchool.getDisc().getTurmas();
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
            obsTurmaDisc.addAll(vTurmaTest);
            listaTurmasDisc.setItems(obsTurmaDisc);
        }        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarList();
    }
    
    public void fechar() {
        ListarTurmaDisc.getStage().close();
    }
    
}
