package layout;

public class Constants {

	// Environment Constants

	private static float gravity = 2000f;  // pixels per second
	private static float restitution = 0.85f;
	private static float epsilon = 0.000009f;
	
	public static float getGravity() {
		return gravity;
	}
	public static float getRestitution() {
		return restitution;
	}
	public static float getEpsilon() {
		return epsilon;
	}
}
