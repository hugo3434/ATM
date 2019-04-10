package AppKickstarter.misc;


//======================================================================
// Msg
public class Msg {
    private String sender;
    private MBox senderMBox;
    private Type type;
    private String details;

    //------------------------------------------------------------
    // Msg
    public Msg(String sender, MBox senderMBox, Type type, String details) {
	this.sender = sender;
	this.senderMBox = senderMBox;
	this.type = type;
	this.details = details;
    } // Msg


    //------------------------------------------------------------
    // getters
    public String getSender()     { return sender; }
    public MBox   getSenderMBox() { return senderMBox; }
    public Type   getType()       { return type; }
    public String getDetails()    { return details; }


    //------------------------------------------------------------
    // toString
    public String toString() {
	return sender + " (" + type + ") -- " + details;
    } // toString


    //------------------------------------------------------------
    // Msg Types
    public enum Type {
	Terminate,		// Terminate the running thread
	SetTimer,		// Set a timer
	CancelTimer,		// Set a timer
	Tick,			// Timer clock ticks
	TimesUp,		// Time's up for the timer
	Poll,			// Health poll
	PollAck,		// Health poll acknowledgement
	CR_CardInserted,	// Card inserted
	CR_CardRemoved,		// Card removed
	CR_EjectCard,		// Eject card
	KP_KeyPressed,		// Key pressed
    } // Type
} // Msg
