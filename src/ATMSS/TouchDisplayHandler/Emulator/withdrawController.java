package ATMSS.TouchDisplayHandler.Emulator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class withdrawController {
    @FXML
    public Button Dback;

    public withdrawController() {
        TouchDisplayEmulatorController.getInstance().withdraw();
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
