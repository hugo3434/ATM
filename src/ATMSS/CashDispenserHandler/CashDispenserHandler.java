package ATMSS.CashDispenserHandler;

import AppKickstarter.AppKickstarter;
import AppKickstarter.misc.*;

public class CashDispenserHandler extends AppThread{
    //------------------------------------------------------------
    // CashDispenserHandler
    public CashDispenserHandler(String id, AppKickstarter appKickstarter) {
        super(id, appKickstarter);
    } // CashDispenserHandler

    //------------------------------------------------------------
    // run
    public void run() {
        MBox atmss = appKickstarter.getThread("ATMSS").getMBox();
        log.info(id + ": starting...");

        for (boolean quit = false; !quit;) {
            Msg msg = mbox.receive();

            log.fine(id + ": message received: [" + msg + "].");


            switch (msg.getType()) {
                case CDispense_100:

                    System.out.println("Handle Dispense 100");
                    break;

                case CDispense_1000:

                    System.out.println("Handle Dispense 1000");
                    break;

                case CDispense_500:

                    System.out.println("Handle Dispense 500");
                    break;

                case CDispense_Token:
                    atmss.send(new Msg(id, mbox, Msg.Type.CDispense_Token, msg.getDetails()));
                    System.out.println("Handle successful dispense message");
                    //close
                    break;

                case CDispense_Refused:
                    atmss.send(new Msg(id, mbox, Msg.Type.CDispense_Refused, msg.getDetails()));
                    System.out.println("Handle refused dispensing");
                    //close
                    break;

                case Poll:
                    atmss.send(new Msg(id, mbox, Msg.Type.PollAck, id + " is up!"));
                    break;

                case Terminate:
                    quit = true;
                    break;



                default:
                    log.warning(id + ": unknown handle message type: [" + msg + "]");
            }
        }

        // declaring our departure
        appKickstarter.unregThread(this);
        log.info(id + ": terminating...");
    } // run

    //------------------------------------------------------------
    // handleDispenseRequest
    protected void handleDispenseRequest() {
    // give N x 100
        // give N x 500
        // give N x 1000

    } // handleDispenseRequest
}
