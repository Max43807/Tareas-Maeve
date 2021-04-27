package com.analistas.tareasmaven.controller;

import com.analistas.tareasmaven.MainApp;
import com.analistas.tareasmaven.model.service.TareaServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class FormTareasFXMLController implements Initializable {
    @FXML
    public TextField tfxDescripcion;
    @FXML
    public DatePicker dpFecha;
    @FXML
    public Button btnGuardar;
    @FXML
    public Button btnCancelar;

    TareaServiceImpl service = new TareaServiceImpl();

    public void initialize(URL url, ResourceBundle rb) {
        if (MainApp.tareaSeleccionada != null) {
            tfxDescripcion.setText(MainApp.tareaSeleccionada.getDescripcion());
            dpFecha.setValue(MainApp.tareaSeleccionada.getFecha());
        }
    }

    public void Guardar_OnAction(ActionEvent actionEvent) {

        //Pasar los datos modificados a la tarea seleccionada
        MainApp.tareaSeleccionada.setDescripcion(tfxDescripcion.getText().trim());
        MainApp.tareaSeleccionada.setFecha(dpFecha.getValue());

        //Guardar la tarea modficada
        service.guardar(MainApp.tareaSeleccionada);

        //Cerrar esta ventana
        Cancelar_OnAction(null);
    }

    public void Cancelar_OnAction(ActionEvent actionEvent) {
        Stage st = (Stage) btnCancelar.getScene().getWindow();
        st.close();
    }
}
