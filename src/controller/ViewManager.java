package controller;

import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewManager class
 *
 * The ViewManager class handles the changing of roots in the Stage's scene.
 * Holds all controllers needed in the application.
 * Holds the scene of the application
 */
public class ViewManager
{
    List<Controller> controllerList;
    Scene scene;

    public ViewManager()
    {
        controllerList = new ArrayList<>();
    }

    /**
     *
     */
    public void addController(Controller controller)
    {
        controllerList.add(controller);
    }

    public void getScene()
    {
        return scene;
    }

    public void switchViews()
    {

    }
}
