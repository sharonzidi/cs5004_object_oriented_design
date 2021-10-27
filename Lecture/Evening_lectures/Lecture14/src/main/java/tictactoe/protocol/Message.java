package tictactoe.protocol;

/**
 * Represents a Message in the expected format.
 */
public class Message {
    int message;
    String content;

    public Message(int message, String content) {
        this.message = message;
        this.content = content;
    }

    public Message(int message) {
        this.message = message;
        this.content = "";
    }

    /**
     * Gets the message type (an integer e.g. 19 for "START_GAME").
     * @return The message type.
     */
    public int getMessage() {
        return message;
    }

    /**
     * Gets the message content. Either an empty string or data.
     * @return The message content, a String.
     */
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return this.message + " " + this.content;
    }
}
