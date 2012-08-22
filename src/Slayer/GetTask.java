package Slayer;

import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.wrappers.interactive.NPC;

public class GetTask extends ActiveScript {

	@Override
	protected void setup() {
		getNPC(null);
	}
	
	public NPC getNPC(NPC master) {
		return master;
	}
}
