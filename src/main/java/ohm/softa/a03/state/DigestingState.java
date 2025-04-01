package ohm.softa.a03.state;

import ohm.softa.a03.Cat;

public class DigestingState extends State {

    private final int remaining;

    protected DigestingState(int duration, int remaining) {
        super(duration);
        this.remaining = remaining;
        logger.info("Getting in a playful mood!");
    }

    @Override
    State successor(Cat cat) {
        return new PlayfulState(remaining-getDuration());
    }
}
