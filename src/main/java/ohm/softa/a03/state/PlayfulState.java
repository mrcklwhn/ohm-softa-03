package ohm.softa.a03.state;

import ohm.softa.a03.Cat;

public class PlayfulState extends State {

    protected PlayfulState(int duration) {
        super(duration);
        logger.info("Yoan... getting tired!");
    }

    @Override
    State successor(Cat cat) {
        return new SleepingState(cat.getSleep());
    }
}
