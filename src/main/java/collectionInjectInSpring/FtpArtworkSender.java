package collectionInjectInSpring;


public class FtpArtworkSender implements ArtworlSender {
    public void sendArkwork(String artworkPath, Recipient recipient) {

    }

    public String getFriendlyName() {
        return "File Transport Protocol";
    }

    public String getShortName() {
        return "ftp";
    }
}
