package bll;

import java.util.ArrayList;

public interface IBLL {
	
	public ArrayList<String> getNarratorOfHadithToAGivenNarrator(String narrator);
	public ArrayList<String> getNarrateorOfHadithFromAGivenNarrator(String narrator);
	public ArrayList<String> getUniqueNarratorsInABook(String bookName);
	public ArrayList<String> getAllNarratorsAtLevelInABook(String bookName,int level);

	
}
