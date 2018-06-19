
public class HelloWorld {
    public static void main(String[] args) {/*
        MessageRenderer messageRender = new StandartOutMessageRenderer();
        MessageProvider messageProvider = new HelloWorldMessageProvider();
        messageRender.setMessageProvider(messageProvider);
        messageRender.render();
        MessageProvider customMessageProvider = new CustomMessageProvider();
        messageRender.setMessageProvider(customMessageProvider);
        messageRender.render();*/
        MessageRenderer renderer = MessageSupportFactory.getinstance().getRenderer();
        MessageProvider provider = MessageSupportFactory.getinstance().getProvider();
        renderer.setMessageProvider(provider);
        renderer.render();

    }
}
