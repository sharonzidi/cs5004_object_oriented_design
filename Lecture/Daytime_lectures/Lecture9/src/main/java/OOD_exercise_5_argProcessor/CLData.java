package OOD_exercise_5_argProcessor;

public class CLData implements ICLData{
    private Integer port;
    private String hostname;
    private String encrypted;

    public CLData(){
        port = Integer.MIN_VALUE;
        hostname = "localhost";
        encrypted = "plain";
    }

    public CLData(Integer myPort){
        port = myPort;
        hostname = "localhost";
        encrypted = "plain";
    }

    public CLData(Integer myPort, String myHostname, String myEncy){
        port = myPort;
        hostname = myHostname;
        encrypted = myEncy;
    }

    public void setEncrypted(String encrypted) {
        this.encrypted = encrypted;
    }

    public void setPort(Integer port){
        this.port = port;
    }

    public void setHostname(String hostname){
        this.hostname = hostname;
    }
}
