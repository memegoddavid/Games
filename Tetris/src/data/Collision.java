package data;

import game.Block;
import game.Game;

public class Collision {
	
	public static boolean collideWithBlock(Block b, int direction) {
		//-1 für links, 0 für runter, 1 rechts
		
		
		switch(direction) {
		case -1:
			
			if(b.getY() > 0) {
				
				if(b.getX() > 0) {
					for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
						for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
							
							if(b.getBounds()[b.getRotation()][i][j] == 1) {
								if(Game.map[b.getX() + i -1][b.getY() + j] >= 1) {
									return true;
								}
							}
							
						}
					}
				}
			}
			
			
			
			break;
		
		case 0:
			if(b.getY() + b.getSize() > 1) {
				if(b.getY() - b.getSize() < 17) {
					try {
						for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
							for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {										
								if(b.getBounds()[b.getRotation()][i][j] == 1) {
									if(Game.map[b.getX() + i][b.getY() + j + 1] >= 1) {
										Game.spawnNewBlock = true;
										fillBlock(b);	
										return true;
									}
								}
									
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
						
			break;
						
		case 1:
			if(b.getY() > 0) {
				if(b.getX() < 10) {
					for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
						for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {						
							if(b.getBounds()[b.getRotation()][i][j] == 1) {
								if(Game.map[b.getX() + i + 1][b.getY() + j] >= 1) {
									return true;
								}
							}
							
						}
					}
				}
			}
		}
		
		
		return false;
	}
	
	public static boolean collideInRot(Block b) {
		
		int rot = b.getRotation() +1;
		if(rot == 4) {
			rot = 0;
		}
		
		Block block = new Block();
		block.setRotation(rot);
		block.setBounds(b.getBounds());
		block.setSize(b.getSize());
		block.setX(b.getX() - 1);
		block.setY(b.getY());
		
		if(collideWithWall(block, 1)) {
			return true;
		}
			block.setX(b.getX()+2);
			if(collideWithWall(block, -1)) {
				return true;
			}
			
			if(b.getY() > 0) {
				try {
					for (int i = 0; i < b.getBounds()[rot].length; i++) {
						for (int j = 0; j < b.getBounds()[rot][i].length; j++) {						
							if(b.getBounds()[rot][i][j] == 1) {
								if(Game.map[b.getX() + i + 1][b.getY() + j] >= 1) {
									return true;
								}
							}
							
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					return true;
					
				}
			}
		
		return false;
		
	}
	
	
	
	public static boolean collideWithWall(Block b, int direction) {
		
		switch(direction) {
		case -1:
			
			for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
				for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
					
					if(b.getBounds()[b.getRotation()][i][j] == 1) {
						if(b.getX() + i == 0) {
							return true;
						}
							
						
					}
					
				}
			}
			
			break;
		
		case 0:
			
			for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
				for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
					
					if(b.getBounds()[b.getRotation()][i][j] == 1) {
						if(b.getY() + j == 17) {
							Game.spawnNewBlock = true;
							fillBlock(b);
							return true;
						}
							
						
					}
					
				}
			}
			
			break;
		
		case 1:
			
			for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
				for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
					
					if(b.getBounds()[b.getRotation()][i][j] == 1) {
						if(b.getX() + (i+2) >= 11) {
							return true;
						}
							
						
					}
					
				}
			}
			
			break;
			
		}
		
		
		
		
		
		return false;
	}
	
	
	
	private static void fillBlock(Block b) {
		try {
			for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
				for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {						
					if(b.getBounds()[b.getRotation()][i][j] == 1) {
						
						Game.map[b.getX()+i][b.getY() + j] = b.getTypeValue();
						
					}
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
