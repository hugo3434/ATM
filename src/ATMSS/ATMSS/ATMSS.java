package ATMSS.ATMSS;

import AppKickstarter.AppKickstarter;
import AppKickstarter.misc.*;
import AppKickstarter.timer.Timer;


//======================================================================
// ATMSS
public class ATMSS extends AppThread {
    private MBox cardReaderMBox;
    private MBox keypadMBox;
    private MBox touchDisplayMBox;

    //------------------------------------------------------------
    // ATMSS
    public ATMSS(String id, AppKickstarter appKickstarter) throws Exception {
	super(id, appKickstarter);
    } // ATMSS


    //------------------------------------------------------------
    // run
    public void run() {
	Timer.setTimer(id, mbox, 60000);
	log.info(id + ": starting...");

	cardReaderMBox = appKickstarter.getThread("CardReaderHandler").getMBox(); //get MBoxes from thread
	keypadMBox = appKickstarter.getThread("KeypadHandler").getMBox();
	touchDisplayMBox = appKickstarter.getThread("TouchDisplayHandler").getMBox();

	for (boolean quit = false; !quit;) {
	    Msg msg = mbox.receive();

	    log.fine(id + ": message received: [" + msg + "].");

	    switch (msg.getType()) {
		case KP_KeyPressed:
		    log.info("KeyPressed: " + msg.getDetails());
		    processKeyPressed(msg);
		    break;

		case CR_CardInserted:
		    log.info("CardInserted: " + msg.getDetails());
		    System.out.println("ATMSS RECEIVED!!!!");
		    break;

		case TimesUp:
		    Timer.setTimer(id, mbox, 60000);
		    log.info("Poll: " + msg.getDetails());
		    cardReaderMBox.send(new Msg(id, mbox, Msg.Type.Poll, ""));
		    keypadMBox.send(new Msg(id, mbox, Msg.Type.Poll, ""));
		    touchDisplayMBox.send(new Msg(id, mbox, Msg.Type.Poll, ""));
		    break;

		case PollAck:
		    log.info("PollAck: " + msg.getDetails());
		    break;

		case Terminate:
		    quit = true;
		    break;

            case CashR_Open:
                log.severe("OPEN CASH RECEIVER");
                break;

		default:
		    log.warning(id + ": unknown message type: [" + msg + "]");
	    }
	}

	// declaring our departure
	appKickstarter.unregThread(this);
	log.info(id + ": terminating...");
    } // run


    //------------------------------------------------------------
    // processKeyPressed
    private void processKeyPressed(Msg msg) {
        // *** The following is an example only!! ***
        if (msg.getDetails().compareToIgnoreCase("Cancel") == 0) {
	    cardReaderMBox.send(new Msg(id, mbox, Msg.Type.CR_EjectCard, ""));
	}
    } // processKeyPressed
} // CardReaderHandler
