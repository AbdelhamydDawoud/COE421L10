public class TeamLeader implements Observer {
    private final String name;
    private int patience;
    private final UI ui;

    public TeamLeader(String name, int patience, UI ui, Eren eren) {
        this.name = name;
        this.patience = patience;
        this.ui = ui;
        eren.addObserver(this);
    }

    @Override
    public void update(int energy) {
        if (patience <= 0) {
            return;
        }
        patience -= 5;
        ui.print(name + ": Eren transformed again. Patience = " + patience);
        if (patience == 10) {
            ui.print(name + ": My patience is waning!");
        } else if (patience == 5) {
            ui.print(name + ": Is this entertaining?");
        } else if (patience == 0) {
            ui.print(name + ": Omae wa mou shindeiru");
        }
    }
}
