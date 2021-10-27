import javax.sound.midi.Receiver;

public class Mail {
    private int width;
    private int height;
    private int depth;
    private Recipient recipient;


    public Mail(int width, int height, int depth, Recipient recipient) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.recipient = recipient;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public boolean isOwner(Recipient r){
        return this.recipient.equals(r);
    }
}
