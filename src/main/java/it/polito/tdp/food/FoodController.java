/**
 * Sample Skeleton for 'Food.fxml' Controller Class
 */

package it.polito.tdp.food;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.food.model.Adiacente;
import it.polito.tdp.food.model.Food;
import it.polito.tdp.food.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FoodController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtPorzioni"
    private TextField txtPorzioni; // Value injected by FXMLLoader

    @FXML // fx:id="txtK"
    private TextField txtK; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalisi"
    private Button btnAnalisi; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalorie"
    private Button btnCalorie; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="boxFood"
    private ComboBox<Food> boxFood; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	txtResult.clear();
    	txtResult.appendText("Creazione grafo..."+"\n\n");
    	int porzioni;
    	try {
    		porzioni = Integer.parseInt(this.txtPorzioni.getText());
    	}catch(NumberFormatException e) {
    		this.txtResult.appendText("Inserire un valore numerico\n");
    		return;
    	}
    	
    	model.creaGrafo(porzioni);
    	this.txtResult.appendText("GRAFO CREATO\n");
    	this.txtResult.appendText("#VERTICI: "+this.model.nVertici()+"\n");
    	this.txtResult.appendText("#ARCHI: "+this.model.nArchi()+"\n");
    	
    	this.boxFood.setDisable(false);
    	this.boxFood.getItems().clear();
    	this.boxFood.getItems().addAll(model.getFood());
    	this.btnCalorie.setDisable(false);

    	this.txtK.setDisable(false);
    	this.btnSimula.setDisable(false);
    }
    
    @FXML
    void doCalorie(ActionEvent event) {
    	txtResult.clear();
    	txtResult.appendText("Analisi calorie..."+"\n\n");
    	
    	Food f = this.boxFood.getValue();
    	
    	if(f == null) {
    		this.txtResult.appendText("Selezionare un cibo di interesse\n");
    		return;
    	}
    	
    	this.txtResult.appendText("Lista di adiacenti con calorie massime: ");
    	this.txtResult.appendText("\n");
    	List<Adiacente> vicini = model.getAdiacenti(f);
    	for(int i = 0; i < 5 && i < vicini.size(); i++) { // LA STAMPA DEI 5 CON CAL MAX VIENE FATTA NEL CONTROLLER, NON A LIVELLO DELL'ALGORITMO
    		this.txtResult.appendText(vicini.get(i).toString()+"\n");
    		
    	}
    }

    @FXML
    void doSimula(ActionEvent event) {
    	txtResult.clear();
    	txtResult.appendText("Simulazione...");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtPorzioni != null : "fx:id=\"txtPorzioni\" was not injected: check your FXML file 'Food.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnAnalisi != null : "fx:id=\"btnAnalisi\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnCalorie != null : "fx:id=\"btnCalorie\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Food.fxml'.";
        assert boxFood != null : "fx:id=\"boxFood\" was not injected: check your FXML file 'Food.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Food.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    	
    	this.btnCalorie.setDisable(true);
    	this.btnSimula.setDisable(true);
    	
    	this.txtK.setDisable(true);
    	this.boxFood.setDisable(true);
    }
}
