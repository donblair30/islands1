package islands;

public class Islands {
	private static final int MAP_WIDTH = 10;
	private static final int MAP_HEIGHT = 10;
	private int islandNum = 0; 
	
	private int[][] inMap = new int[][]{
		  { 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0, 1, 1, 0, 0 },
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
		  { 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 },
		  { 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 }		  
		};

	private int[][] outMap = new int[MAP_WIDTH][MAP_HEIGHT]; // All 0's by default. 
	
	public Islands() {
		return; 
	}
	
	public void printMaps() {
		System.out.println("Total islands = " + islandNum);
		System.out.println("Here's the inMap: ");
		for (int y = 0; y < MAP_HEIGHT; y++) {
			System.out.print("{ ");
			for (int x = 0; x < MAP_WIDTH; x++) {
				System.out.print(inMap[y][x] + ", ");
			}
			System.out.println("},");
		}
		System.out.println("Here's the outMap: ");
		for (int y = 0; y < MAP_HEIGHT; y++) {
			System.out.print("{ ");
			for (int x = 0; x < MAP_WIDTH; x++) {
				System.out.print(outMap[y][x] + ", ");
			}
			System.out.println("},");
		}
	}
	
	public void findNewIslands() {
		// Search row by row, for next "1" that isn't already marked as an island. 
		// When we find it, we know it's a new island.  And ready to mark.  
		for (int y = 0; y < MAP_HEIGHT-1; y++) {
			for (int x = 0; x < MAP_WIDTH-1; x++) {
				if ((inMap[y][x] == 1) && (outMap[y][x] == 0)) {
					// It's a new island!
					markIsland(++islandNum, x, y);
					printMaps();
				}
			}
		}
		return;
	}
	
	private boolean isIsland(int x, int y) {
		if ((x < MAP_WIDTH) && (x >= 0) && (y < MAP_HEIGHT) && (y >= 0)) {
			if ((inMap[y][x] == 1) && (outMap[y][x] == 0)) {
				return true;			
			}
		}
		return false; 
	}
	
	private void markIsland(int thisIsland, int x, int y) {
		// We know this is an island, and that it's not already marked. 
		// Mark this as island 
		// Check the 4 surrounding spaces, if any are island, and not already marked, mark them.   
		outMap[y][x] = thisIsland;
		if (isIsland(x+1, y)) {
			markIsland(thisIsland, x+1, y);			
		}
		if (isIsland(x-1, y)) {
			markIsland(thisIsland, x-1, y);
		}		
		if (isIsland(x, y+1)) {
			markIsland(thisIsland, x, y+1);
		}
		if (isIsland(x, y-1)) {
			markIsland(thisIsland, x, y-1);
		}
		return; 
	}
	
}

