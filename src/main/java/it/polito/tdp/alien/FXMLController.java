/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;

import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dizionario model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnClearText"
    private Button btnClearText; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtInput"
    private TextField txtInput; // Value injected by FXMLLoader

    @FXML // fx:id="txtOutput"
    private TextArea txtOutput; // Value injected by FXMLLoader
    
    @FXML
    private Label txtErr;


    @FXML
    void doClearText(ActionEvent event) {

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	txtErr.setText("");
    	txtOutput.clear();
    	
    	String input=txtInput.getText();
    	String[] parola = input.split(" ");
    	
    	// se ci sono più spazi
    	if(parola.length>2) {
    		txtErr.setText("Non puoi inserire più di un ' '!");
    		return ;
    	}
    	if(parola.length==2) {
    		// se ci sono numeri e altre robe
    		boolean b = model.add(parola[0], parola[1]);
    		if(!b) {
    			txtErr.setText("Errore: nel linguaggio alieno sono ammesse solo lettere dell'alfabeto inglese!");
    			return ;
    		}

    		// se va tutto bene -- b=true
    		else {
    			txtOutput.setText(model.toString());
    			txtInput.clear();
    		}
    	}
    	else if(parola.length==1) {
    		String res = model.trovaTraduzione(parola[0]);
    		if(res.compareTo("")==0) {
    			txtErr.setText("Errore: nessuna traduzione per la parola cercata!");
    			return ;
    		}
    		txtOutput.setText("La traduzione di questa parola aliena e': " + res);
    	}
    }
    
    public void setModel(Dizionario model) {
    	this.model = model;
    }
    
    public boolean verificaNumero(String s ) {
    	
    	return false;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
