package AOPKeyGenerate;


import java.util.Random;

public class KeyGenerator {
    protected static final long WEAK_KEY = 0xFFFFFFF0000000L;
    protected static final long STRONG_KEY = 0xACDF03F590AE56L;

    private Random rand = new Random();
    public long getKey(){
        if(rand.nextInt(3)==1){
            return WEAK_KEY;
        }
        return STRONG_KEY;
    }
}
