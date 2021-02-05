import java.util.Random;

public class Coin {

    public static final String HEADS = "heads";
    public static final String TAILS = "tails";
    private String side;


    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String flip() {
        Random random = new Random();
        if (random.nextBoolean()) {
            setSide(HEADS);
        } else
            setSide(TAILS);
        return getSide();
    }
}
