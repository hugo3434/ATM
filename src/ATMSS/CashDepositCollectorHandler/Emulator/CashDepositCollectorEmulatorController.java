package ATMSS.CashDepositCollectorHandler.Emulator;

import AppKickstarter.AppKickstarter;
import AppKickstarter.misc.MBox;
import AppKickstarter.misc.Msg;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CashDepositCollectorEmulatorController {
    private String id;
    private AppKickstarter appKickstarter;
    private Logger log;
    private CashDepositCollectorEmulator CashDepositCollectorEmulator;
    private MBox CashDepositCollectorMBox;

    //------------------------------------------------------------
    // initialize
    public void initialize(String id, AppKickstarter appKickstarter, Logger log, CashDepositCollectorEmulator CashDepositCollectorEmulator) {
        this.id = id;
        this.appKickstarter = appKickstarter;
        this.log = log;
        this.CashDepositCollectorEmulator = CashDepositCollectorEmulator;
        this.CashDepositCollectorMBox = appKickstarter.getThread("CashDepositCollectorHandler").getMBox();
    } // initialize

    //------------------------------------------------------------
    // buttonPressed
    public void buttonPressed(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();

        switch (btn.getText()) {
            case "Deposit 100":
                System.out.println("Deposit 100");
                System.out.println(": "+ id);

                CashDepositCollectorMBox.send(new Msg(id, CashDepositCollectorMBox, Msg.Type.CDepo_100, "Deposit 100"));
                break;

            case "Deposit 500":
                System.out.println("Deposit 500");
                CashDepositCollectorMBox.send(new Msg(id, CashDepositCollectorMBox, Msg.Type.CDepo_500, "Deposit 500"));
                break;

            case "Deposit 1000":
                System.out.println("Deposit 1000");
                CashDepositCollectorMBox.send(new Msg(id, CashDepositCollectorMBox, Msg.Type.CDepo_1000, "Deposit 100"));
                break;


            default:
                log.warning(id + ": unknown button: [" + btn.getText() + "]");
                break;
        }
    } // buttonPressed



} // CashDepositCollectorEmulatorController
