public class Frog{
	private int jumps = 0;
	private int x = 0;
	private int y = 0;
	
	public Frog(){
		
	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public int getJumps(){
		return this.jumps;
	}
	
	public void jumpNorth(){
		jumps++;
		y++;
	}
	public void jumpSouth(){
		y--;
		jumps++;
	}
	public void jumpEast(){
		x++;
		jumps++;
	}
	public void jumpWest(){
		jumps++;
		x--;
	}
}