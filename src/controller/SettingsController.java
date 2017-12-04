package controller;

import controller.ViewManager.ViewManagerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.BackUp;

import java.io.IOException;

public class SettingsController extends Controller
{   
    @FXML
    private Button buttonBack, buttonBack1, buttonBack2,
                   buttonChangePassword, buttonSetBackup, buttonApply;

    @FXML
    private AnchorPane anchorpaneMainSettings, anchorpanePasswordSettings, anchorpaneBackupSettings;

    @FXML
    private TextField textfieldBackupLocation;

    public SettingsController() throws IOException
    {
        initialize(this, "/view/settings", "/view/settings");
    }

    @Override
    public void load() throws ViewManagerException
    {
        if(checkInitialLoad(getClass().getSimpleName()))
        {
            buttonBack.addEventHandler(ActionEvent.ACTION, e ->
            {
                viewManager.switchViews("MainMenuController");
                clear();
            });

            buttonChangePassword.addEventHandler(ActionEvent.ACTION, e ->
            {
                anchorpaneMainSettings.setVisible(false);
                anchorpaneMainSettings.setDisable(true);
                anchorpanePasswordSettings.setVisible(true);
                anchorpanePasswordSettings.setDisable(false);
            });

            buttonBack1.addEventHandler(ActionEvent.ACTION, e ->
            {
                anchorpanePasswordSettings.setVisible(false);
                anchorpanePasswordSettings.setDisable(true);
                anchorpaneMainSettings.setVisible(true);
                anchorpaneMainSettings.setDisable(false);
            });

            buttonSetBackup.addEventHandler(ActionEvent.ACTION, e ->
            {
                anchorpaneMainSettings.setVisible(false);
                anchorpaneMainSettings.setDisable(true);
                anchorpaneBackupSettings.setVisible(true);
                anchorpaneBackupSettings.setDisable(false);
            });

            buttonBack2.addEventHandler(ActionEvent.ACTION, e ->
            {
                anchorpaneBackupSettings.setVisible(false);
                anchorpaneBackupSettings.setDisable(true);
                anchorpaneMainSettings.setVisible(true);
                anchorpaneMainSettings.setDisable(false);
            });

            buttonApply.addEventHandler(ActionEvent.ACTION, e ->
            {
                BackUp b = new BackUp(textfieldBackupLocation.getText());
            });
        }
    }

    @Override
    public void clear()
    {

    }
}
