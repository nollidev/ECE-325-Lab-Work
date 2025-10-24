package ece325.labs.lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** 
 * Finish this class.
 */
public class SongLoader {
	/**
	 * Load a SongCollection from a file. Uses one or more Scanners to read the
	 * file, create Song objects and insert them into a SongCollection.
	 * 
	 * 
	 * The input is of the format: Songtitle; Instruments; Rating 
	 * Contribution;Guitar,Guitar,Drums;4.5
	 * 
	 * (see songratings.txt for the full input)
	 * 
	 * @param file
	 * @return the loaded SongCollection
	 */
	public static SongCollection loadSongs(String file) throws InvalidSongFormatException{
		SongCollection result = new SongCollection();

		String[] songArr = loadTxt(file);
		for (String song: songArr) { result.add(parseSong(song)); }
		
		return result;
	}

	/**
	 * Parse a Song object from the String and return it. If the String cannot be
	 * parsed into a Song, throw an InvalidSongFormatException.
	 * 
	 * @param songString
	 * @return
	 * @throws InvalidSongFormatException
	 */
	public static Song parseSong(String songString) throws InvalidSongFormatException {
		String[] arr = songString.split(";");
		
		String title = arr[0];
		ArrayList<String> instruments = parseInstrumentsList(arr[1]);
		AverageRating rating = new AverageRating(Float.parseFloat(arr[2]));

		return (new Song(title, instruments, rating));
	}

	/**
	 * Uses a scanner to parse the instruments string into an ArrayList of String
	 * objects. You can assume that the string comes in CSV (comma-separated-value)
	 * format, and that it is valid CSV (so no need to do error checking or account
	 * for issues with the data).
	 * 
	 * @param instruments
	 * @return an ArrayList with one String per parsed instrument
	 */
	public static ArrayList<String> parseInstrumentsList(String instruments) {
		ArrayList<String> result = new ArrayList<String>();
		String[] arr = instruments.split(",");

		for (String instrument: arr) {
			result.add(instrument);
		}
		
		return result;
	}

	/**
	 * This method loads a text file into a String array. It assumes the number of 
	 * lines in the file is on the first line of the file itself.
	 * 
	 * Note: you are not allowed to make changes to this method. You can use this method for 
	 * loading text files in the other lab and course assignments as well.
	 * 
	 * @param file
	 * @return
	 */
	private static String[] loadTxt(String file) {
		String[] data = new String[0];
		BufferedReader in = null;
		
		try { 
			in = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			int totalLines = 0;

			while((line = in.readLine()) != null) { ++totalLines; }
			in.close();
			in = new BufferedReader(new FileReader(file));

			data = new String[totalLines];
			while((line = in.readLine()) != null) { data[i++] = line; }

		} catch (Exception e) {
			System.err.println("Problem while reading file: " + file);
			e.printStackTrace();			
		}
		finally {
			if(in != null) { 
				try {
					in.close();
				} catch (IOException e) {
					System.err.println("Problem closing file: " + file);
					e.printStackTrace();
				} 
			}
		}
		return data;
	}

	public static void main(String[] args) {
		String file = "songratings.txt";
		try {
			System.out.println(SongLoader.loadSongs(file));
		} catch (InvalidSongFormatException e) {
			e.printStackTrace();
		}
	}
}
