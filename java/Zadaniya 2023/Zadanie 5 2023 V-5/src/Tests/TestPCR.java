package Tests;

import Interface.Observed;
import Interface.Observer;

import java.util.ArrayList;
import java.util.List;

public class TestPCR implements Observed {

    List<String> tests = new ArrayList<>();
    List<Observer> patient = new ArrayList<>();

    @Override
    public void addTest(String test) {
        this.tests.add(test);
        notifyObserver();
    }

    @Override
    public void removeTest(String test) {
        this.tests.remove(test);
        notifyObserver();

    }

    @Override
    public void addPatient(Observer observer) {
        this.patient.add(observer);

    }

    @Override
    public void removePatient(Observer observer) {
        this.patient.remove(observer);

    }

    @Override
    public void notifyObserver() {
        for (Observer obs: patient) {
            obs.handEvent(tests);
        }
    }
}
