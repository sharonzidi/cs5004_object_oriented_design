public class Locker {
    private int width;
    private int height;
    private int depth;
    private Mail mail;


    public Locker(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.mail = null;
    }

    public void addMail(Mail inputMail) throws Exception {
        if (inputMail == null) {
            return;
        }
        if (this.mail != null) {
            throw new LockerOccupiedException("This locker is occupied.");
        }

        if (inputMail.getDepth() > this.depth ||
                inputMail.getWidth() > this.width ||
                inputMail.getHeight() > this.height) {
            throw new MailOverSizeException("This mail cannot fit in this locker.");
        }

        this.mail = inputMail;
    }

    public Mail pickupMail(Recipient recipient) {
        if (this.mail == null ||
                !this.mail.isOwner(recipient)) {
            return null;
        }

        Mail returnMail = this.mail;
        this.mail = null;
        return returnMail;
    }
}
