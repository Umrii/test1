package pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import bll.HadithBO;
import bll.IBLL;
import dal.HadithDAO;
import dal.IDAL;
import to.HadithTO;

public class HadithManagementSystemView implements ActionListener {

	private IBLL bo;

	public HadithManagementSystemView(IDAL dao) throws SQLException {
		bo = new HadithBO(dao);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void mainScreen() {

	}

	public static void main(String[] args) {
		HadithManagementSystemView app;
		String url = "jdbc:mysql://localhost:3306/haidth_st_b?useSSL=false";
		String user = "root";
		String password = "";
		Connection connection;
		try {
			connection = DriverManager.getConnection(url, user, password);
			IDAL dao = new HadithDAO(connection);
			try {
				app = new HadithManagementSystemView(dao);
				app.mainScreen();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

};