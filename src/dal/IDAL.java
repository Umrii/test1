package dal;

import java.util.ArrayList;

import to.HadithTO;

public interface IDAL {

	public HadithTO getHadithByBookAndHadithNumber(String book, int hadithNumber);
	public ArrayList<String> getAllSanad();
	public ArrayList<String> getAllSanadsOfABook(String bookName);
	public String getSanadAtLevelOfABook(String bookName,int level);
	
}