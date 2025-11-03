package ece325.labs.lab3;

import java.util.ArrayList;

/** 
 * Finish this class.
 */
public class SongCollection {
	private ArrayList<Song> songs;

	public SongCollection() {
		this.songs = new ArrayList<Song>();
	}

	/**
	 * Add the song if it is not in the list yet, otherwise update the average
	 * rating of the song.
	 * 
	 * @param s
	 */
	public void add(Song s) {
		if (!this.songs.contains(s)) { this.songs.add(s); }
		else { 
			for (Song song: this.songs) { 
				if (song.equals(s)) { song.addRating(s.getRating().getAvgRating()); }
			}
		}
	}

	public void remove(Song s) {
		if (this.songs.contains(s)) { this.songs.remove(s); }
	}

	public boolean contains(Song s) {
		for (Song song: this.songs) { if (song.equals(s)) { return true; } }
		return false;
	}

	public Song getSong(int index) {
		return this.songs.get(index);
	}

	public int getNumberOfSongs() {
		return this.songs.size();	
	}

	public ArrayList<Song> getSongs() {
		return this.songs;
	}

	public String toString() {
		String toRet = "[SongCollection: ";
		for (Song s : songs)
			toRet += "\n\t" + s + "; ";
		return toRet + "\n]";
	}
}
