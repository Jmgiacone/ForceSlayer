package Slayer;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.methods.Settings;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.wrappers.interactive.NPC;

public class GetTask extends Strategy implements Task {

	NPC master;
	public GetTask(String master) {
		this.master = NPCs.getNearest(master);
	}

	@Override
	public void run() {
		
	}
	
	public boolean validate() {
		return !(Settings.get(394) == 0);
	}
}
