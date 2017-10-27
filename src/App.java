import controller.MainController;
import controller.ViewManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    /**
     * TODO: Is the Title of the Stage correct?
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/mainmenu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        ViewManager viewManager = new ViewManager();
        view


        primaryStage.setTitle("Tony Joe's POS System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}