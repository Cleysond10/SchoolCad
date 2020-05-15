package controller;

import Aplicacao.ListarProf;
import Aplicacao.MainSchool;
import com.jfoenix.controls.JFXListView;
import estruturadados.LDE;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tiposdados.Professor;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ListarProfController implements Initializable {

    @FXML private JFXListView<String> listaProf;
    ObservableList<String> lista = FXCollections.observableArrayList();
    private LDE ldeProf;

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }

    @FXML
    void acaoBtSelecionar(ActionEvent event) {

    }
    
    private void carregarDados() {
        ldeProf = MainSchool.getLdeProf();        
        Professor[] x = ldeProf.listaProf();
        if(x.length == 0) {
            System.out.println("Vazio");
        }
        else {
            String[] s = new String[x.length];
            for(int i = 0; i < x.length; i++) {
                s[i] = x[i].getNome();
            }
            lista.removeAll(lista);
            lista.addAll(s);
            listaProf.getItems().addAll(lista);
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarDados();
    }    
    
    public void fechar() {
        ListarProf.getStage().close();
    }

    public LDE getLdeProf() {
        return ldeProf;
    }

    public void setLdeProf(LDE ldeProf) {
        this.ldeProf = ldeProf;
    }
        
}
