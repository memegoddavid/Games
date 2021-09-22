package game;

import java.util.concurrent.ThreadLocalRandom;

public enum BlockType {
	i,o,t,l,j,z,s;
	
	public static BlockType random() {
		return values()[ThreadLocalRandom.current().nextInt(0,values().length)];
	}
}
