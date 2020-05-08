package controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Aplicacao.AltCadProf;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AltProfController implements Initializable {
    
    @FXML
    private JFXButton btAltCadBusca;

    @FXML
    void AltCadBusca(ActionEvent event) {
        AltCadProf acp = new AltCadProf();
        
        try {
            acp.start(new Stage());    		
    	}catch(Exception ex) {
            ex.printStackTrace();
    	}
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}