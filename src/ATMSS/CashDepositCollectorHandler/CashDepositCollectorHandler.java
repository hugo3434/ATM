package ATMSS.CashDepositCollectorHandler;

import AppKickstarter.AppKickstarter;
import AppKickstarter.misc.*;


//======================================================================
// CashDepositCollectorHandler
public class CashDepositCollectorHandler extends AppThread {
    //------------------------------------------------------------
    // CashDepositCollectorHandler
    public CashDepositCollectorHandler(String id, AppKickstarter appKickstarter) {
        super(id, appKickstarter);
    } // CashDepositCollectorHandler


    //------------------------------------------------------------
    // run
    public void run() {
        MBox atmss = appKickstarter.getThread("ATMSS").getMBox();
        log.info(id + ": starting...");

        for (boolean quit = false; !quit;) {
            Msg msg = mbox.receive();

            log.fine(id + ": message received: [" + msg + "].");


            switch (msg.getType()) {
                case CDepo_100:
                    atmss.send(new Msg(id, mbox, Msg.Type.CDepo_100, msg.getDetails()));
                    System.out.println("Handle Deposit 100");
                    break;

                case CDepo_1000:
                    atmss.send(new Msg(id, mbox, Msg.Type.CDepo_1000, msg.getDetails()));
                    System.out.println("Handle Deposit 1000");
                    break;

                case CDepo_500:
                    atmss.send(new Msg(id, mbox, Msg.Type.CDepo_500, msg.getDetails()));
                    System.out.println("Handle Deposit 500");
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
    // handleReject
    protected void handleReject() {

    } // handleReject

} // CashDepositCollectorHandler

