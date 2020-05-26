package controller;

import Aplicacao.ExbCadDisc;
import Aplicacao.ExbCadProf;
import Aplicacao.ListarDisc;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tiposdados.Disciplina;
import tiposdados.Professor;

/**
 * FXML Controller class
 *
 * @author Neto e Cleyson
 */
public class ListarDiscController implements Initializable {
    
    @FXML private JFXListView<String> listaDisc;
    ObservableList<String> lista = FXCollections.observableArrayList();
    private LDE ldeDisc;
        

    @FXML
    void acaoBtCancelar(ActionEvent event) {
        fechar();
    }
    
    @FXML
    void AcaoDaLista(MouseEvent event) {
    	String cLista = listaDisc.getSelectionModel().getSelectedItem();
    	if(cLista == null || cLista.isEmpty()) {
    		//fieldCarregar.setText("Lista Vazia");
    	}
    	else {
            Disciplina a;
            a = Buscar(cLista);
            MainSchool.setDisc(a);
            
            ExbCadDisc aca = new ExbCadDisc();

            try {
                aca.start(new Stage());    		
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            fechar();
    	}
    }
    
    public Disciplina Buscar(String nome) {
        Disciplina[] x = ldeDisc.listaDisc();
        Disciplina a = null;        
        
        for(int i = 0; i < x.length; i++) {
            if(x[i].getNome().equals(nome)) {
                a = x[i];
            }            
        }
        
        return a;
    }
    
    private void carregarDados() {
        ldeDisc = MainSchool.getLdeDisc();        
        Disciplina[] x = ldeDisc.listaDisc();
        if(x.length == 0) {
            System.out.println("Vazio");
        }
        else {
            String[] s = new String[x.length];
            for(int i = 0; i < x.length; i++) {
                s[i] = x[i].getNome();
            }
            //listaJogo.Inicializar();
            //x = listaJogo.listaSalvo();
            lista.removeAll(lista);
            lista.addAll(s);
            listaDisc.getItems().addAll(lista);
        }
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarDados();
    } 
    
    public void fechar() {
        ListarDisc.getStage().close();
    }
    
}
