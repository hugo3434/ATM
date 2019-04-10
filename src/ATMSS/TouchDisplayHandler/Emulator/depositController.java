package ATMSS.TouchDisplayHandler.Emulator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class depositController {
    @FXML
    public Button Dback;

    public depositController() {
        TouchDisplayEmulatorController.getInstance().deposit();
    }

    public void back () {
        try {

            TouchDisplayEmulatorController.getInstance().mainScreen.getChildren().remove(0,TouchDisplayEmulatorController.getInstance().mainScreen.getChildren().size());
            Node main = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

            TouchDisplayEmulatorController.getInstance().mainScreen.getChildren().add(main);
        } catch (Exception e) {
        }
    }
}
