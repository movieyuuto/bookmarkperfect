package bookmark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** テーブルurlTに対するDAO */
public class urlTDAO2{
	/** クラスの初期化時に一度だけ実行される */
	static {
		try {
			Class.forName("org.h2.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<U2> findAll2() {
		List<U2> urlList2 = new ArrayList<U2>();
		String url = "jdbc:h2:tcp://localhost/f:/h2/s1732126";
		try (Connection conn = DriverManager.getConnection(url, "user", "pass");) {
			String sql = "SELECT 番号,URL FROM  newsurls";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			int rows2 = 0;
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				rows2++;
				int number = rs.getInt("番号");
				String urls = rs.getString("URL");
				U2 url1 = new U2();
				url1.setNumber2(number);
				url1.setUrl2(urls);
				urlList2.add(url1);
			}
			System.out.println(rows2 + "件");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return urlList2;
	}


	public boolean create2(int number, String urls) {
		String url = "jdbc:h2:tcp://localhost/f:/h2/s1732126";
		try (Connection conn = DriverManager.getConnection(url, "user", "pass");) {
			if(number != 0 && urls != "null")
			{
			String sql = "INSERT INTO newsurls(番号,URL) VALUES(?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, number);
			pStmt.setString(2, urls);
			int result = pStmt.executeUpdate();
			if (result != 1)
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public boolean delete2(int number) {
		String url = "jdbc:h2:tcp://localhost/f:/h2/s1732126";
		try (Connection conn = DriverManager.getConnection(url, "user", "pass");) {
			String sql = "DELETE FROM newsurls WHERE 番号 = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, number);
			int result = pStmt.executeUpdate();
			if (result != 1)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}