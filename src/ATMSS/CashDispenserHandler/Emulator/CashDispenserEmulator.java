package ATMSS.CashDispenserHandler.Emulator;

import ATMSS.ATMSSStarter;
import ATMSS.CashDispenserHandler.CashDispenserHandler;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class CashDispenserEmulator extends CashDispenserHandler{
    private ATMSSStarter atmssStarter;
    private String id;
    private Stage myStage;
    private CashDispenserEmulatorController CashDispenserEmulatorController;

    //------------------------------------------------------------
    // CashDispenserEmulator
    public CashDispenserEmulator(String id, ATMSSStarter atmssStarter) {
        super(id, atmssStarter);
        this.atmssStarter = atmssStarter;
        this.id = id;
    } // CashDispenserEmulator

    //------------------------------------------------------------
    // start
    public void start() throws Exception {
        Parent root;
        myStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        String fxmlName = "CashDispenserEmulator.fxml";
        loader.setLocation(CashDispenserEmulator.class.getResource(fxmlName));
        root = loader.load();
        CashDispenserEmulatorController = (CashDispenserEmulatorController) loader.getController();
        CashDispenserEmulatorController.initialize(id, atmssStarter, log, this);
        myStage.initStyle(StageStyle.DECORATED);
        myStage.setScene(new Scene(root, 360, 200));
        myStage.setTitle("Cash Dispenser");
        myStage.setResizable(false);
        myStage.setOnCloseRequest((WindowEvent event) -> {
            atmssStarter.stopApp();
            Platform.exit();
        });
        myStage.show();
    } // CashDispenserEmulator

    // handleDispenseRequest
    protected void handleDispenseRequest() {
        // fixme
        super.handleDispenseRequest();
    } // handleDispenseRequest

} // CashDispenserEmulator
