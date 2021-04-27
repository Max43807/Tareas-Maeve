package com.analistas.tareasmaven.controller;

import com.analistas.tareasmaven.model.domain.Tarea;
import com.analistas.tareasmaven.model.service.TareaServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import util.ventanasjfx.DialogoJFX;

import java.net.URL;
import java.util.ResourceBundle;

public class CargarUsuarioFXMLController implements Initializable {

    @FXML
    public Button btnAceptar;
    @FXML
    public Button brnCancelar;
    @FXML
    public TextArea tfxDescrip;
    @FXML
    public DatePicker dpFecha;

    TareaServiceImpl service = new TareaServiceImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void guardar_OnAction(ActionEvent actionEvent) {
        Tarea t = new Tarea();
        t.setDescripcion(tfxDescrip.getText().trim());
        t.setFecha(dpFecha.getValue());

        service.guardar(t);

        Stage st = (Stage) btnAceptar.getScene().getWindow();
        st.close();
    }

    public void cancelar_OnAction(ActionEvent actionEvent) {
        if (DialogoJFX.pedirConfirmacion("¿Desea Continuar'")) {
            Stage st = (Stage) brnCancelar.getScene().getWindow();
            st.close();
        }
    }
}
