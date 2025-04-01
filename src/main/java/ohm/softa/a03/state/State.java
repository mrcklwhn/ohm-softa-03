package ohm.softa.a03.state;

import ohm.softa.a03.Cat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {

    private int time;
    private final int duration;
    protected static final Logger logger = LogManager.getLogger();

    protected State(int duration) {
        this.duration = duration;
    }


    public State tick(Cat cat) {
        logger.info("tick()");
        time++;
        if(time >= duration) {
            return successor(cat);
        }
        logger.info(this.getClass().getName());
        return this;
    }

    abstract State successor(Cat cat);

    public int getTime() {
        return time;
    }

    public int getDuration() {
        return duration;
    }

}
