import java.awt.Image;

public class Target {
	
	public int height;
	public int width;
	public int x;
	public int y;
	public Image img;
	
	public Target(int height, int width, int x, int y, Image img) {
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		this.img = img;
	}
	
	public String toString() {
		return Integer.toString(this.x);
	}
}
