package cls;

import game.Block;
import game.Game;
import ui.Gui;

public class main {

	public static void main(String[] args) {
		
		Game.currentBlock = new Block();
		Game.blocks.add(Game.currentBlock);
		Game.nextBlock = new Block();
		
		
		Gui g = new Gui();
		g.create();
		
		startLoop();
	}
	
	
	public static void startLoop() {
		GameLoop loop = new GameLoop();
		loop.start();
	}

}
