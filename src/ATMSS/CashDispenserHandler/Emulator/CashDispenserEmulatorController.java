package ATMSS.CashDispenserHandler.Emulator;

import AppKickstarter.AppKickstarter;
import AppKickstarter.misc.MBox;
import AppKickstarter.misc.Msg;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CashDispenserEmulatorController {
    private String id;
    private AppKickstarter appKickstarter;
    private Logger log;
    private CashDispenserEmulator CashDispenserEmulator;
    private MBox CashDispenserMBox;

    //------------------------------------------------------------
    // initialize
    public void initialize(String id, AppKickstarter appKickstarter, Logger log, CashDispenserEmulator CashDispenserEmulator) {
        this.id = id;
        this.appKickstarter = appKickstarter;
        this.log = log;
        this.CashDispenserEmulator = CashDispenserEmulator;
        this.CashDispenserMBox = appKickstarter.getThread("CashDispenserHandler").getMBox();
    } // initialize

    //------------------------------------------------------------
    // buttonPressed
    public void buttonPressed(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();

        switch (btn.getText()) {
            case "Take cash":
                System.out.println("Take cash");
                CashDispenserMBox.send(new Msg(id, CashDispenserMBox, Msg.Type.CDispense_Token, "Take cash"));
                break;

            case "Refused":
                System.out.println("Refused");
                CashDispenserMBox.send(new Msg(id, CashDispenserMBox, Msg.Type.CDispense_Refused, "Refused"));
                break;



            default:
                log.warning(id + ": unknown button: [" + btn.getText() + "]");
                break;
        }
    } // buttonPressed



} // CashDispenserEmulatorController
