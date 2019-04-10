package ATMSS.TouchDisplayHandler.Emulator;

import AppKickstarter.AppKickstarter;
import AppKickstarter.misc.MBox;
import AppKickstarter.misc.Msg;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Logger;


//======================================================================
// TouchDisplayEmulatorController
public class TouchDisplayEmulatorController {
    private String id;
    private AppKickstarter appKickstarter;
    private Logger log;
    private TouchDisplayEmulator touchDisplayEmulator;
    private MBox touchDisplayMBox;

    @FXML
    Button deposit;

    @FXML
    Button withdraw;

    @FXML
    Button Wback;

    @FXML
    Button Dback;

    @FXML
    Button eject;

    @FXML
    AnchorPane mainScreen;

    //------------------------------------------------------------
    // initialize
    public void initialize(String id, AppKickstarter appKickstarter, Logger log, TouchDisplayEmulator touchDisplayEmulator) {
        this.id = id;
        this.appKickstarter = appKickstarter;
        this.log = log;
        this.touchDisplayEmulator = touchDisplayEmulator;
        this.touchDisplayMBox = appKickstarter.getThread("TouchDisplayHandler").getMBox();
    } // initialize

    private static TouchDisplayEmulatorController instance;

    public TouchDisplayEmulatorController() {
        instance = this;
    }

    public static TouchDisplayEmulatorController getInstance() {
        return instance;
    }


    public void deposit() {

        touchDisplayMBox.send(new Msg(id, touchDisplayMBox, Msg.Type.CashR_Open, "Requesting Cash Receiver to open"));

    }

    public void withdraw() {

        touchDisplayMBox.send(new Msg(id, touchDisplayMBox, Msg.Type.CashR_Open, "Requesting Cash"));

    }

    public void mainMenu() {
        mainScreen.getChildren().remove(0, mainScreen.getChildren().size());
        try {
            Node main = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            mainScreen.getChildren().add(main);
        } catch (Exception e) {
            log.warning(e.toString());
        }
    }

    public void back() {
        try {
            mainScreen.getChildren().remove(0, mainScreen.getChildren().size());
            Parent content = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            mainScreen.getChildren().add(content);
        } catch (IOException e) {
            log.warning(e.toString());
        }

    }


    public void Eject() {
        touchDisplayMBox.send(new Msg(id, touchDisplayMBox, Msg.Type.CR_EjectCard, "Ejecting card"));
        {

        }
    } // TouchDisplayEmulatorController

}