package ece325.labs.lab3;

import java.util.ArrayList;

/** 
 * Finish this class.
 */
public class SongCollection {
	private ArrayList<Song> songs;

	public SongCollection() {
		songs = new ArrayList<Song>;
	}

	/**
	 * Add the song if it is not in the list yet, otherwise update the average
	 * rating of the song.
	 * 
	 * @param s
	 */
	public void add(Song s) {
		if (!songs.contains(s))	{ songs.add(s); }
	}

	public void remove(Song s) {
		
	}

	public boolean contains(Song s) {
		
	}

	public Song getSong(int index) {
		return songs.get(index);
	}

	public int getNumberOfSongs() {
		return songs.size();	
	}

	public ArrayList<Song> getSongs() {
		return songs;
	}

	public String toString() {
		String toRet = "[SongCollection: ";
		for (Song s : songs)
			toRet += "\n\t" + s + "; ";
		return toRet + "\n]";
	}
}
