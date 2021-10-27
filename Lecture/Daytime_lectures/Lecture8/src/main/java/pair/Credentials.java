package pair;

public class Credentials {
  private GenericPair<String, Integer> credential;

  private GenericPair<String, Number>[] credentials;

  public Credentials(String username, Integer passwordHash){
    this.credential = new GenericPair<> (username, passwordHash);

    this.credentials[0] = new GenericPair<>(username, passwordHash);
  }

  @Override
  public String toString() {
    return "Credentials{" +
        "username = " + credential.getFirst() + ", " +
        "password = " + "*****" +
        '}';
  }
}
