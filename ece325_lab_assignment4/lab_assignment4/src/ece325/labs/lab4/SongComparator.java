package ece325.labs.lab4;

import java.util.Comparator;

// finish this
public class SongComparator implements Comparator<Song> {
	
	@Override
	public int compare(Song song1, Song song2) {
		float song1Rating = song1.getAverageRating().getAvgRating();
		float song2Rating = song2.getAverageRating().getAvgRating();
		
		if (Float.compare(song1Rating, song2Rating) != 0) { 
			return -Float.compare(song1Rating, song2Rating); // negate for high-low ordering
		} else {
			int song1Votes = song1.getAverageRating().getVotes();
			int song2Votes = song2.getAverageRating().getVotes();
			return -Integer.compare(song1Votes, song2Votes); // negate for high-low ordering
		}
	}
}