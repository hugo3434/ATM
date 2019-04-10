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
        CR_CardInserted, // Card inserted
        CR_CardRemoved, // Card removed
        CR_EjectCard, // Eject card
        CancelTimer, // Set a timer
        CashR_Open, // Open cash receiver
        CDepo_100, // Deposit $100
        CDepo_1000, // Deposit $1000
        CDepo_500, // Deposit $500
        CDispense_100, // Dispense $100
        CDispense_1000, // Dispense $1000
        CDispense_500, // Dispense $500
        CDispense_Token, // cash Token
        CDispense_Refused, // cash dispense refused by client / timeout

        KP_KeyPressed, // Key pressed
        Poll, // Health poll
        PollAck, // Health poll acknowledgement
        SetTimer, // Set a timer
        Terminate, // Terminate the running thread
        Tick, // Timer clock ticks
        TimesUp // Time's up for the timer

        ,    // Card inserted
    } // Type
} // Msg
