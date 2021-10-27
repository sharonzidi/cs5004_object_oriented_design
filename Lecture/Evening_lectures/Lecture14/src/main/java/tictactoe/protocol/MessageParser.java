package tictactoe.protocol;

/**
 * Converts the raw string messages sent between client and server into the Message format.
 */
public class MessageParser {

    /**
     * Convert a raw string into a Message.
     * @param input The raw input.
     * @return A Message representing the input.
     */
    public static Message parse(String input) {
        int firstSpace = input.indexOf(" ");
        String id = input;
        String content = "";
        if (firstSpace >= 0) {
            id = input.substring(0, firstSpace);
            if (firstSpace < input.length() - 1)
                content = input.substring(firstSpace+1);
        }
        try {
            int messageType = Integer.parseInt(id);
            return fromProtocol(messageType, content);
        } catch (NumberFormatException e) {
            return invalid();
        }
    }

    /**
     * Helper method to create the Message.
     * @param id The integer message type.
     * @param content The message content.
     * @return A Message object.
     */
    private static Message fromProtocol(int id, String content) {
        if (Protocol.inProtocol(id))
            return new Message(id, content);
        return invalid();
    }

    /**
     * Helper method used if the input cannot be parsed.
     * @return A Message object that will inform the client that their request is invalid.
     */
    private static Message invalid() {
        return new Message(Protocol.INVALID_REQUEST, "I'm sorry, I don't understand that message.");
    }
}
