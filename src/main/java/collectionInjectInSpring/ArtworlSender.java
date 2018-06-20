package collectionInjectInSpring;


public interface ArtworlSender {
    void sendArkwork(String artworkPath, Recipient recipient);
    String getFriendlyName();
    String getShortName();
}
