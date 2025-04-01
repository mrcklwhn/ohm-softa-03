package ohm.softa.a03.state;

import ohm.softa.a03.Cat;

public class HungryState extends State {

    protected HungryState(int duration) {
        super(duration);
        logger.info("I've starved for a too long time...good bye...");
    }

    public State feed(Cat cat) {
        if (!cat.isHungry())
            throw new IllegalStateException("Can't stuff a cat...");

        logger.info("You feed the cat...");
        return new DigestingState(cat.getDigest(), cat.getAwake()-getTime());
    }

    @Override
    State successor(Cat cat) {
        return new DeathState();
    }
}
