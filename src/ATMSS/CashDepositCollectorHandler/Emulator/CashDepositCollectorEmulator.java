package ATMSS.CashDepositCollectorHandler.Emulator;

import ATMSS.ATMSSStarter;
import ATMSS.CashDepositCollectorHandler.CashDepositCollectorHandler;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class CashDepositCollectorEmulator extends CashDepositCollectorHandler{
    private ATMSSStarter atmssStarter;
    private String id;
    private Stage myStage;
    private CashDepositCollectorEmulatorController CashDepositCollectorEmulatorController;

    //------------------------------------------------------------
    // CashDepositCollectorEmulator
    public CashDepositCollectorEmulator(String id, ATMSSStarter atmssStarter) {
        super(id, atmssStarter);
        this.atmssStarter = atmssStarter;
        this.id = id;
    } // CashDepositCollectorEmulator

    //------------------------------------------------------------
    // start
    public void start() throws Exception {
        Parent root;
        myStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        String fxmlName = "CashDepositCollectorEmulator.fxml";
        loader.setLocation(CashDepositCollectorEmulator.class.getResource(fxmlName));
        root = loader.load();
        CashDepositCollectorEmulatorController = (CashDepositCollectorEmulatorController) loader.getController();
        CashDepositCollectorEmulatorController.initialize(id, atmssStarter, log, this);
        myStage.initStyle(StageStyle.DECORATED);
        myStage.setScene(new Scene(root, 360, 200));
        myStage.setTitle("CashDeposit Collector");
        myStage.setResizable(false);
        myStage.setOnCloseRequest((WindowEvent event) -> {
            atmssStarter.stopApp();
            Platform.exit();
        });
        myStage.show();
    } // CashDepositCollectorEmulator

    // handleCardRemove
    protected void handleReject() {
        // fixme
        super.handleReject();
    } // handleReject

} // CashDepositCollectorEmulator
