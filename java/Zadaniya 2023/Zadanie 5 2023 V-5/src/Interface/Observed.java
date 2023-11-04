package Interface;

public interface Observed {
    void addTest(String test);
    void removeTest (String test);
    void addPatient (Observer observer);
    void removePatient (Observer observer);
    void notifyObserver();
}
