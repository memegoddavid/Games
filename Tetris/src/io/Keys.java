package io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import data.Collision;
import game.Game;
import game.GameState;

public class Keys implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(Game.gamestate == GameState.start) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				Game.gamestate = GameState.ingame;
			}
		}
		
		if(Game.gamestate == GameState.start) {
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				try {
					if(!Collision.collideInRot(Game.currentBlock)) {
						Game.currentBlock.rotate();

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Game.speedup = true;
			}
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				try {
					if(!Collision.collideWithWall(Game.currentBlock, 1) && 
							!Collision.collideWithWall(Game.currentBlock, 1)) {
						Game.currentBlock.setX(Game.currentBlock.getX() + 1);

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				try {
					if(!Collision.collideWithWall(Game.currentBlock, -1) && 
							!Collision.collideWithWall(Game.currentBlock, -1)) {
						Game.currentBlock.setX(Game.currentBlock.getX() + -1);

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			Game.gamestate = GameState.pause;
			}
		// TODO Auto-generated method stub
		
		}else if (Game.gamestate == GameState.pause) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				Game.gamestate = GameState.ingame;
				}
		}else if (Game.gamestate == GameState.gameover) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				Game.gamestate = GameState.ingame;
				Game.clear();
				}
		}
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		if(Game.gamestate == GameState.ingame) {
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				Game.speedup = false;
			}
		}
		
	}

}
