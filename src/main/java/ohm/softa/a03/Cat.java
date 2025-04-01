package ohm.softa.a03;

import ohm.softa.a03.state.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Cat {
	private static final Logger logger = LogManager.getLogger();

	private State state;
	private final int sleep;
	private final int awake;
	private final int digest;
	private final String name;


	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
		this.state = new SleepingState(0);
	}

	public void tick(){
		state = state.tick(this);
	}


	public void feed(){
		if (!isHungry())
			throw new IllegalStateException("Can't stuff a cat...");

		logger.info("You feed the cat...");

		state = ((HungryState)state).feed(this);
	}

	public boolean isAsleep() {
		return state instanceof SleepingState;
	}

	public boolean isPlayful() {
		return state instanceof PlayfulState;
	}

	public boolean isHungry() {
		return state instanceof HungryState;
	}

	public boolean isDigesting() {
		return state instanceof DigestingState;
	}

	public boolean isDead() {
		return state instanceof DeathState;
	}

	public int getAwake() {
		return awake;
	}
	public int getDigest() {
		return digest;
	}
	public int getSleep() {
		return sleep;
	}

	@Override
	public String toString() {
		return name;
	}

}
