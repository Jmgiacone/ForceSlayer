package Slayer;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.wrappers.interactive.NPC;

public class GetTask extends Strategy implements Task {

	public NPC getNPC(NPC master) {
		return master;
	}

	@Override
	public void run() {
		getNPC(null);
		
	}
}
