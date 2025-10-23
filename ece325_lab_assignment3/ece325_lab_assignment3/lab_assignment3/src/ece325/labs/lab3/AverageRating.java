package ece325.labs.lab3;

/** 
 * Finish this class.
 */
public class AverageRating {
	private float avgRating;
	private int count;
	
	public AverageRating(float rating) {
		this.avgRating = rating;
		this.count = 1;
	}
	
	/**
	 * Recomputes the average rating taking the new rating r into account.
	 * @param rating 
	 */
	public void addRating(float r) {
		this.avgRating = ((++this.count - 1)*this.avgRating + r) / this.count;
	}
	
	public float getAvgRating() {
		return avgRating;
	}
	
	public String toString() {
		return "[AverageRating: " + avgRating + "]";
	}
}
