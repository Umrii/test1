package dal;

import java.util.ArrayList;
import java.util.Hashtable;

import to.HadithTO;

public class HadithDAOStub implements IDAL {

	private Hashtable<Integer, HadithTO> db;

	public HadithDAOStub() {
		super();
		// TODO Auto-generated constructor stub
		db = new Hashtable<Integer, HadithTO>();
		db.put(1, new HadithTO(
				"أخبرنا <SANAD> <NAR> قتيبة بن سعيد <AR> قال حدثنا <NAR> سفيان <AR> عن <NAR> الزهري <AR> عن <NAR> أبي سلمة <AR> عن <NAR> أبي هريرة <AR> <ANAD> <MATN>  أن النبي صلى الله عليه وسلم قال إذا استيقظ أحدكم من نومه فلا يغمس يده في وضوئه حتى يغسلها ثلاثا فإن أحدكم لا يدري أين باتت يده <ATN>",
				"سنن النسائى الصغرى", 1,
				" أن النبي صلى الله عليه وسلم قال  إذا استيقظ أحدكم من نومه فلا يغمس يده في وضوئه حتى يغسلها ثلاثا فإن أحدكم لا يدري أين باتت يده  ",
				"['قتيبة بن سعيد', 'سفيان', 'الزهري', 'أبي سلمة', 'أبي هريرة']", 5));
		db.put(2, new HadithTO(
				"أخبرنا <SANAD> <NAR> إسحاق بن إبراهيم <AR> <NAR> وقتيبة بن سعيد <AR> عن <NAR> جرير <AR> عن <NAR> منصور <AR> عن <NAR> أبي وائل <AR> عن <NAR> حذيفة <AR> <ANAD> <MATN>  قال كان رسول الله صلى الله عليه وسلم إذا قام من الليل يشوص فاه بالسواك <ATN>",
				"سنن النسائى الصغرى", 2, "قال كان رسول الله صلى الله عليه وسلم إذا قام من الليل يشوص فاه بالسواك  ",
				"['إسحاق بن إبراهيم', 'وقتيبة بن سعيد', 'جرير', 'منصور', 'أبي وائل', 'حذيفة']", 6));
	}

	@Override
	public HadithTO getHadithByBookAndHadithNumber(String book, int hadithNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getAllSanad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getAllSanadsOfABook(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSanadAtLevelOfABook(String bookName, int level) {
		// TODO Auto-generated method stub
		return null;
	}

}
