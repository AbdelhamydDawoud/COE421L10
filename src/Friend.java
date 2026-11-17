import java.util.Random;

public class Friend implements Observer {
    private final String name;
    private final UI ui;
    private final Random random;

    public Friend(String name, UI ui, Eren eren) {
        this.name = name;
        this.ui = ui;
        this.random = new Random();
        eren.addObserver(this);
    }

    @Override
    public void update(int energy) {
        if (random.nextBoolean()) {


            ui.print(name + ": Eren, please be safe!");
        }

        if (energy < 20) {
            ui.print(name + ": Rage, rage against the dying of the light");
        }
    }
}
