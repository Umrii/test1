package to;

public class HadithTO {

	private String hadith;
	private String book;
	private int hadithNumber;
	private String matn;
	private String sanad;
	private int sanadLength;

	public int getSanadLength() {
		return sanadLength;
	}

	public void setSanadLength(int sanadLength) {
		this.sanadLength = sanadLength;
	}

	public HadithTO(String hadith, String book, int hadithNumber, String matn, String sanad, int sanadLength) {
		super();
		this.hadith = hadith;
		this.book = book;
		this.hadithNumber = hadithNumber;
		this.matn = matn;
		this.sanad = sanad;
		this.sanadLength = sanadLength;
	}

	public HadithTO() {
		super();
		// TODO Auto-generated constructor stub
		hadith = "";
		book = "";
		hadithNumber = -1;
		matn = "";
		sanad = "";
	}

	public String getHadith() {
		return hadith;
	}

	public void setHadith(String hadith) {
		this.hadith = hadith;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public int getHadithNumber() {
		return hadithNumber;
	}

	public void setHadithNumber(int hadithNumber) {
		this.hadithNumber = hadithNumber;
	}

	public String getMatn() {
		return matn;
	}

	public void setMatn(String matn) {
		this.matn = matn;
	}

	public String getSanad() {
		return sanad;
	}

	public void setSanad(String sanad) {
		this.sanad = sanad;
	}

	public String toString() {
		return hadith + " " + book + " " + hadithNumber + " " + matn + " " + sanad + " " + sanadLength;
	}

}
