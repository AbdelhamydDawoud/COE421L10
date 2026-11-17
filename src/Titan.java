import java.util.Random;

public class Titan implements Observer {
    private final String name;
    private final UI ui;
    private final Random random;

    public Titan(String name, UI ui, Eren eren) {
        this.name = name;
        this.ui = ui;
        this.random = new Random();
        eren.addObserver(this);
    }

    @Override
    public void update(int energy) {
        if (random.nextBoolean()) {
            ui.print(name + ": attacks Eren!");
        }

        if (energy > 40) {
            ui.print(name + ": Now we got problems, and I don't think we can solve 'em");
        }
    }
}
