package com.analistas.tareasmaven.controller;

import com.analistas.tareasmaven.MainApp;
import com.analistas.tareasmaven.model.domain.Tarea;
import com.analistas.tareasmaven.model.service.TareaServiceImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import util.ventanasjfx.DialogoJFX;


public class TareasFxmlController implements Initializable {

    @FXML
    private TableView<Tarea> tbvTareas;
    @FXML
    private TextField txfBuscar;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnMarcar;
    @FXML
    private Label lblUsuario;

    TareaServiceImpl service = new TareaServiceImpl();
    Tarea ta = new Tarea();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUsuario.setText(lblUsuario.getText() + " " + MainApp.usuarioLogueado);
        tbvTareas.getItems().addAll(service.listarPorUsuario(MainApp.usuarioLogueado));
    }

    private void cargarDatos() {
        tbvTareas.getItems().clear();
        tbvTareas.getItems().addAll(service.listarPorUsuario(MainApp.usuarioLogueado));
    }


    @FXML
    private void nuevo_OnAction(ActionEvent event) {
        DialogoJFX.abrir(btnNuevo.getScene().getWindow(), "/fxml/CargarTareaFXML", "AgregarTarea");
        cargarDatos();
    }

    @FXML
    private void modificarOnAction(ActionEvent event) {
        if (tbvTareas.getSelectionModel().getSelectedItems().size() > 0) {
            MainApp.tareaSeleccionada = tbvTareas.getSelectionModel().getSelectedItem();
            DialogoJFX.abrir(btnNuevo.getScene().getWindow(), "/fxml/FormTareasFXML", "Modificar Tarea");
            cargarDatos();
        } else
            DialogoJFX.mostrarError("No hay filas seleccionadas.");
    }

    @FXML
    private void borrarOnAction(ActionEvent event) {
        if (tbvTareas.getSelectionModel().getSelectedItems().size() == 0) {
            DialogoJFX.mostrarError(("Hay que seleccionar una tarea para borrar"));
            return;
        }

        if (DialogoJFX.pedirConfirmacion("¿Seguro que quiere borrrar esta tarea \n" + ta.getDescripcion() + " ? ")) ;
        service.borrar(tbvTareas.getSelectionModel().getSelectedItem().getId());
        cargarDatos();
    }

    @FXML
    private void marcarOnAction(ActionEvent event) {
        int idTarea = tbvTareas.getSelectionModel().getSelectedItem().getId();
        service.cambiarEstado(idTarea);

        cargarDatos();
    }

    @FXML
    public void buscar_OnKeyTyped(KeyEvent keyEvent) {

        String criterio = "";
        if (txfBuscar.getText().length() > 0) {
            criterio = txfBuscar.getText();
        }
        tbvTareas.getItems().clear();
        tbvTareas.getItems().addAll(service.buscarPor(MainApp.usuarioLogueado, criterio));
    }
}
