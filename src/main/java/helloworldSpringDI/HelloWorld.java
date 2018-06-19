package helloworldSpringDI;

public class HelloWorld {
    public static void main(String[] args) {/*
        helloworldSpringDI.MessageRenderer messageRender = new helloworldSpringDI.StandartOutMessageRenderer();
        helloworldSpringDI.MessageProvider messageProvider = new helloworldSpringDI.HelloWorldMessageProvider();
        messageRender.setMessageProvider(messageProvider);
        messageRender.render();
        helloworldSpringDI.MessageProvider customMessageProvider = new helloworldSpringDI.CustomMessageProvider();
        messageRender.setMessageProvider(customMessageProvider);
        messageRender.render();*/
        MessageRenderer renderer = MessageSupportFactory.getinstance().getRenderer();
        MessageProvider provider = MessageSupportFactory.getinstance().getProvider();
        renderer.setMessageProvider(provider);
        renderer.render();

    }
}
