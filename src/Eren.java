import java.util.ArrayList;


import java.util.List;
import java.util.Random;

public class Eren extends Thread implements Subject {
    private int energy;
    private final UI ui;
    private final List<Observer> observers;
    private final Random random;

    public Eren(int energy, UI ui) {
        this.energy = energy;
        this.ui = ui;
        this.observers = new ArrayList<>();
        this.random = new Random();
        start();
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(energy);
        }
    }

    @Override
    public void run() {
        while (energy > 0) {
            int waitSeconds = random.nextInt(6) + 5;

            try {
                Thread.sleep(waitSeconds * 1000L);
            } catch (InterruptedException e) {


                ui.print("Eren's thread was interrupted.");
                return;
            }

            ui.print("\nEren transforms into a Titan! Current energy: " + energy);
            notifyObservers();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                ui.print("Eren's transformation was interrupted.");
                return;
            }

            energy -= 5;
            if (energy < 0) {
                energy = 0;
            }

            ui.print("Eren returns to human form. Energy is now: " + energy);
        }

        ui.print("\nEren can no longer transform. Energy reached 0.");
    }
}
