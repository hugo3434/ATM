package ATMSS.TouchDisplayHandler.Emulator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class mainMenuController {
    private static mainMenuController instance = null;
    @FXML
    public Button deposit;

    @FXML
    public Button withdraw;

    @FXML
    public Button account;
    @FXML
    public Button eject;

    public mainMenuController() {
        instance = this;
    }

    public void deposit () {
        try {
            Node main = FXMLLoader.load(getClass().getResource("deposit.fxml"));
            TouchDisplayEmulatorController.getInstance().mainScreen.getChildren().remove(0,TouchDisplayEmulatorController.getInstance().mainScreen.getChildren().size());
            TouchDisplayEmulatorController.getInstance().mainScreen.getChildren().add(main);
        } catch (Exception e) {
        }
    }

    public void withdraw () {
        try {
            Node main = FXMLLoader.load(getClass().getResource("withdraw.fxml"));
            TouchDisplayEmulatorController.getInstance().mainScreen.getChildren().remove(0,TouchDisplayEmulatorController.getInstance().mainScreen.getChildren().size());
            TouchDisplayEmulatorController.getInstance().mainScreen.getChildren().add(main);
        } catch (Exception e) {
        }
    }

    public void Eject () {
        try {
            Node main = FXMLLoader.load(getClass().getResource("goodbye.fxml"));
            TouchDisplayEmulatorController.getInstance().mainScreen.getChildren().remove(0, TouchDisplayEmulatorController.getInstance().mainScreen.getChildren().size());
            TouchDisplayEmulatorController.getInstance().mainScreen.getChildren().add(main);
            TouchDisplayEmulatorController.getInstance().Eject();
        } catch (Exception e) {
        }




    }


}
