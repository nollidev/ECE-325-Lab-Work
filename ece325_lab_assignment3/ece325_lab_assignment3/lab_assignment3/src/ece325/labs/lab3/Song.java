package ece325.labs.lab3;

import java.util.ArrayList;
import java.util.Collections;

/** 
 * Finish this class.
 */
public class Song {
	private String title;
	private ArrayList<String> instruments;
	private AverageRating averageRating;

	public Song(String title, ArrayList<String> instruments, AverageRating rating) {
		this.title = title;
		this.instruments = instruments;
		this.averageRating = rating;	
	}
	
	/**
	 * Returns true if the title of and instruments used in the Songs are the same.
	 * Note that you don't have to include the AverageRating in this comparison (as it is not really related to the equality of the Song). 
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Song) { return equals((Song) o); }
		return false;
	}
	
	/**
	 * Returns true if the title of and instruments used in the Songs are the same.
	 * Note that you don't have to include the AverageRating in this comparison (as it is not really related to the equality of the Song). 
	 */
	public boolean equals(Song s) {
		if (!this.title.equals(s.title)) { return false; }
		
		this.instruments.sort(null);
		s.instruments.sort(null);
		
		
		if (!this.instruments.equals(s.instruments)) { return false; }
		
		return true;
	}
	
	public ArrayList<String> getInstruments(){
		return this.instruments;
	}
	
	public void addRating(float rating) {
		this.averageRating.addRating(rating);
	}
	
	public AverageRating getRating() {
		return this.averageRating;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String toString() {
		return "[Song: " + title + ", instruments: " + instruments + ", avg. rating: " + averageRating + "]"; 
	}
}
