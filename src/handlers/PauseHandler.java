package handlers;

abstract public class PauseHandler {
    public boolean paused = false;
    public boolean running = true;

    public synchronized void pause(){
        paused = true;
    }

    public synchronized void resume(){
        paused = false;
        notify();
    }

    public synchronized void stop(){
        running = false;
        notify();
    }
}
