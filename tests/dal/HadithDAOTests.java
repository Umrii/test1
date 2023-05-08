package dal;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import to.HadithTO;

class HadithDAOTests {

	static HadithDAO dao;

	@BeforeAll
	static void coldStart() {
		dao = new HadithDAO();
	}

	@Test
	@DisplayName("Checking if the correct object is coming from the database when searched")
	void testGetHadithByBookAndHadithNumber1() {

		String book = "سنن النسائى الصغرى";
		int hadithNumber = 1;
		HadithTO hadithExpected = new HadithTO(
				"أخبرنا <SANAD> <NAR> قتيبة بن سعيد <AR> قال حدثنا <NAR> سفيان <AR> عن <NAR> الزهري <AR> عن <NAR> أبي سلمة <AR> عن <NAR> أبي هريرة <AR> <ANAD> <MATN>  أن النبي صلى الله عليه وسلم قال إذا استيقظ أحدكم من نومه فلا يغمس يده في وضوئه حتى يغسلها ثلاثا فإن أحدكم لا يدري أين باتت يده <ATN>",
				book, hadithNumber,
				" أن النبي صلى الله عليه وسلم قال  إذا استيقظ أحدكم من نومه فلا يغمس يده في وضوئه حتى يغسلها ثلاثا فإن أحدكم لا يدري أين باتت يده  ",
				"['قتيبة بن سعيد', 'سفيان', 'الزهري', 'أبي سلمة', 'أبي هريرة']", 5);
		HadithTO hadithActual = dao.getHadithByBookAndHadithNumber(book, hadithNumber);
		Assertions.assertEquals(hadithExpected.toString(), hadithActual.toString());

	}

	@Test
	@DisplayName("Checking by sending details of the book that does not exist in database when searched")
	void testGetHadithByBookAndHadithNumber2() {

		String book = "";
		int hadithNumber = -1;
		HadithTO hadithExpected = new HadithTO();
		HadithTO hadithActual = dao.getHadithByBookAndHadithNumber(book, hadithNumber);
		Assertions.assertEquals(hadithExpected.toString(), hadithActual.toString());
	}

	@Test
	@DisplayName("Checking if all Hadith are received")
	void testGetAllHadith() {

		int expectedTotal = 15;
		int actualTotal = dao.getAllHadith().size();
		Assertions.assertEquals(expectedTotal, actualTotal);
	}

	@Test
	@DisplayName("Checking if size was increased after adding a Hadith")
	void testAddHadith1() {

		int expectedTotal = dao.getAllHadith().size() + 1;
		HadithTO hadith = new HadithTO("new Hadith", "Hadith Book", 1000, "Hadith Matn", "Hadith Sanad", 10);
		dao.addHadith(hadith);
		int actualTotal = dao.getAllHadith().size();
		Assertions.assertEquals(expectedTotal, actualTotal);
	}

	@Test
	@DisplayName("Checking if added object is passed into the database")
	void testAddHadith2() {

		String book = "Hadith Book";
		int hadithNumber = 1000;
		HadithTO actualHadith = new HadithTO("new Hadith", book, hadithNumber, "Hadith Matn", "Hadith Sanad", 10);
		dao.addHadith(actualHadith);
		HadithTO expectedHadith = dao.getHadithByBookAndHadithNumber(book, hadithNumber);
		Assertions.assertEquals(expectedHadith.toString(), actualHadith.toString());
		dao.deleteHadithByBookAndHadithNumber(book, hadithNumber);

	}

	@Test
	@DisplayName("Checking if the object was deleted or not")
	void testDeleteHadithByBookAndHadithNumber1() {

		String book = "Hadith Book";
		int hadithNumber = 1000;
		dao.deleteHadithByBookAndHadithNumber(book, hadithNumber);
		HadithTO expectedHadith = dao.getHadithByBookAndHadithNumber(book, hadithNumber);
		Assertions.assertEquals(expectedHadith.toString(), new HadithTO().toString());
	}

	@Test
	@DisplayName("Checking if the size of the lists are equal after deletion")
	void testDeleteHadithByBookAndHadithNumber2() {

		String book = "Hadith Book 2";
		int hadithNumber = 2;
		HadithTO hadith = new HadithTO("new Hadith 2", book, hadithNumber, "Hadith Matn", "Hadith Sanad", 10);
		dao.addHadith(hadith);
		int actualSize = dao.getAllHadith().size();
		dao.deleteHadithByBookAndHadithNumber(book, hadithNumber);
		int expectedSize = dao.getAllHadith().size();
		Assertions.assertEquals(expectedSize, actualSize - 1);
	}

	@Test
	@DisplayName("Checking if the object was deleted or not by checking the length")
	void testDeleteHadith1() {

		HadithTO hadith = new HadithTO("new Hadith 22", "Book 22", 22, "Hadith Matn", "Hadith Sanad", 10);
		dao.addHadith(hadith);
		int expectedSize = dao.getAllHadith().size();
		dao.deleteHadith(hadith);
		expectedSize--;
		int actualSize = dao.getAllHadith().size();
		Assertions.assertEquals(expectedSize, actualSize);
	}
	
	
	@Test
	@DisplayName("Checking if the right object was deleted")
	void testDeleteHadith2() {

		HadithTO hadith = new HadithTO("new Hadith 22", "Book 22", 22, "Hadith Matn", "Hadith Sanad", 10);
		dao.addHadith(hadith);
		Assertions.assertEquals(hadith.toString(), dao.getHadithByBookAndHadithNumber(hadith.getBook(), hadith.getHadithNumber()).toString());
		dao.deleteHadith(hadith);
		Assertions.assertEquals(new HadithTO().toString(),dao.getHadithByBookAndHadithNumber(hadith.getBook(), hadith.getHadithNumber()).toString());
	}


	@Test
	@DisplayName("Checking if the object was updated succesfully")
	void testUpdateHadith() {

		HadithTO hadith = new HadithTO("new Hadith 33", "Book 33", 33, "Hadith Matn", "Hadith Sanad", 10);
		dao.addHadith(hadith);
		hadith.setMatn("Matn updated");
		dao.updateHadith(hadith);
		HadithTO actualHadith=dao.getHadithByBookAndHadithNumber(hadith.getBook(),hadith.getHadithNumber());
		Assertions.assertEquals(hadith.getBook(), null);
		Assertions.assertEquals(new HadithTO().toString(),dao.getHadithByBookAndHadithNumber(hadith.getBook(), hadith.getHadithNumber()).toString());
	}

	

}