package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * Controller Interface
 *
 * Note:
 */

public abstract class Controller
{
    protected FXMLLoader loader;
    protected Parent root;

    public Controller(String fxmlpath) throws IOException
    {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlpath));
        root = loader.load();
    }

    public Parent getRoot()
    {
        return root;
    }
}
