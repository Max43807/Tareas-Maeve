package com.analistas.tareasmaven.controller;

import com.analistas.tareasmaven.MainApp;
import com.analistas.tareasmaven.model.service.UsuarioServiceImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import util.ventanasjfx.DialogoJFX;

public class FXMLController implements Initializable {


    @FXML
    private Label label;
    @FXML
    private Button btnIngresar;
    @FXML
    private Button btnCancelar;
    @FXML
    private PasswordField pwfClave;
    @FXML
    private TextField txfUsuario;
    
    UsuarioServiceImpl service = new UsuarioServiceImpl();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        if(service.validar(txfUsuario.getText().trim(), pwfClave.getText().trim())) {
            
            //Cargar el usuario en la sesión de la app...
            MainApp.usuarioLogueado = service.buscarPorNombre(txfUsuario.getText().trim());
            
            Window wd = label.getScene().getWindow();
            wd.hide();
            DialogoJFX.pedirConfirmacion("Bienvenide " + txfUsuario.getText());
            DialogoJFX.abrir(wd, "/fxml/TareasFxml", "Mis Tareas");
        } else {
            DialogoJFX.mostrarError("Usuario o clave incorrectos...");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txfUsuario.setText("jorgito");
        pwfClave.setText("5678");
    }    

    @FXML
    private void cancelar_OnAction(ActionEvent event) {
    }
}
