package bases;

public abstract class PauseThread extends Thread {
    public boolean paused = false;
    public boolean running = true;

    public synchronized void pause(){
        paused = true;
    }

    public synchronized void resume(){
        paused = false;
        notify();
    }

    public synchronized void shut(){
        running = false;
        notify();
    }
}
