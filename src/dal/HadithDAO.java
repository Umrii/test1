package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import to.HadithTO;

public class HadithDAO implements IDAL {
	private Connection con;

	// Dependency Injection
	public HadithDAO(Connection con) {
		this.con = con;
	}

	public HadithDAO() {
		String url = "jdbc:mysql://localhost:3306/haidth_st_b?useSSL=false";
		String user = "root";
		String password = "";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author Abdullah Faisal
	 * 
	 * @param book
	 * @param hadithNumber
	 * @return HadithTO
	 */
	@Override
	public HadithTO getHadithByBookAndHadithNumber(String book, int hadithNumber) {
		HadithTO hadith = new HadithTO();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM `dataset` WHERE `Num_hadith` = ? AND `Book` = ?");
			ps.setInt(1, hadithNumber);
			ps.setString(2, book);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				hadith.setBook(rs.getString("book"));
				hadith.setHadith(rs.getString("hadith"));
				hadith.setHadithNumber(rs.getInt("Num_hadith"));
				hadith.setMatn(rs.getString("matn"));
				hadith.setSanad(rs.getString("sanad"));
				hadith.setSanadLength(rs.getInt("Sanad_Length"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hadith;
	}

	/**
	 * 
	 * @author Abdullah Faisal
	 * 
	 * @return ArrayList<HadithTO>
	 */
	public ArrayList<HadithTO> getAllHadith() {
		ArrayList<HadithTO> allHadithList = new ArrayList<HadithTO>();
		HadithTO hadith = new HadithTO();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM `dataset`");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				hadith.setBook(rs.getString("book"));
				hadith.setHadith(rs.getString("hadith"));
				hadith.setHadithNumber(rs.getInt("Num_hadith"));
				hadith.setMatn(rs.getString("matn"));
				hadith.setSanad(rs.getString("sanad"));
				hadith.setSanadLength(rs.getInt("Sanad_Length"));
				allHadithList.add(hadith);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allHadithList;
	}

	/**
	 * 
	 * @author Abdullah Faisal
	 * 
	 * @param hadith
	 * @return boolean
	 */
	public boolean addHadith(HadithTO hadith) {
		try {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO `dataset` (`Hadith`, `Book`, `Num_hadith`, `Matn`, `Sanad`, `Sanad_Length`) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, hadith.getHadith());
			ps.setString(2, hadith.getBook());
			ps.setInt(3, hadith.getHadithNumber());
			ps.setString(4, hadith.getMatn());
			ps.setString(5, hadith.getSanad());
			ps.setInt(6, hadith.getSanadLength());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @author Abdullah Faisal
	 * 
	 * @param book
	 * @param hadithNumber
	 * @return boolean
	 */
	public boolean deleteHadithByBookAndHadithNumber(String book, int hadithNumber) {
		try {
			PreparedStatement ps = con
					.prepareStatement("DELETE FROM `dataset` WHERE `Book` = ? AND `Num_hadith` = ?");
			ps.setString(1, book);
			ps.setInt(2, hadithNumber);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @author Muaaz Ahmed
	 * 
	 * @param hadith
	 * @return
	 */
	public boolean deleteHadith(HadithTO hadith) {
		try {
			PreparedStatement ps = con
					.prepareStatement("DELETE FROM `dataset` WHERE `Book` = ? AND `Num_hadith` = ?");
			ps.setString(1, hadith.getBook());
			ps.setInt(2, hadith.getHadithNumber());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public ArrayList<String> getAllSanad(){		
		ArrayList<String> sanadList = new ArrayList();
		String sanad="";
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM `dataset`");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sanad=rs.getString("Sanad");
				sanadList.add(sanad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sanadList;
	}


	@Override
	public ArrayList<String> getAllSanadsOfABook(String bookName) {
		// TODO Auto-generated method stub
		ArrayList<String> sanadList = new ArrayList();
		String sanad="";
		try {
			PreparedStatement ps = con.prepareStatement("SELECT Sanad FROM `dataset` WHERE `Book` = ?");
			ps.setString(1, bookName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sanad=rs.getString("Sanad");
				sanadList.add(sanad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sanadList;
	}

	@Override
	public String getSanadAtLevelOfABook(String bookName, int level) {
		// TODO Auto-generated method stub
		String sanad="";
		try {
			PreparedStatement ps = con.prepareStatement("SELECT Sanad FROM `dataset` WHERE `Book` = ? AND `Num_hadith` = ?");
			ps.setString(1, bookName);
			ps.setInt(2, level);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sanad=rs.getString("Sanad");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return sanad;
	}

	/**
	 * 
	 * @author Muhammad Abdullah
	 * 
	 * @param hadith
	 * @return boolean
	 */
	public boolean updateHadith(HadithTO hadith) {
		try {
			PreparedStatement ps = con.prepareStatement(
					"UPDATE `dataset` SET (Hadith = ?, Matn = ?, Sanad = ?, Sanad_Length = ?) "
							+ "WHERE Book = ? AND Num_hadith= ?");
			ps.setString(1, hadith.getHadith());
			ps.setString(2, hadith.getMatn());
			ps.setString(3, hadith.getSanad());
			ps.setInt(4, hadith.getSanadLength());
			ps.setString(5, hadith.getBook());
			ps.setInt(6, hadith.getHadithNumber());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
