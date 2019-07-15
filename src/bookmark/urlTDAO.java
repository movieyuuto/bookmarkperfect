package bookmark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** テーブルurlTに対するDAO */
public class urlTDAO {
	/** クラスの初期化時に一度だけ実行される */
	static {
		try {
			Class.forName("org.h2.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** テーブルurlTのすべてのデータを返す */
	public List<U> findAll() {
		List<U> urlList = new ArrayList<U>();
		String url = "jdbc:h2:tcp://localhost/f:/h2/s1732126";
		try (Connection conn = DriverManager.getConnection(url, "user", "pass");) {
			String sql = "SELECT 番号,URL FROM urlT";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			int rows = 0;
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				rows++;
				int number = rs.getInt("番号");
				String urls = rs.getString("URL");
				U url1 = new U();
				url1.setNumber(number);
				url1.setUrl(urls);
				urlList.add(url1);
			}
			System.out.println(rows + "件");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return urlList;
	}

	/** テーブルurlTにデータを追加する．成功したらtrueを返す */
	public boolean create(int number, String urls) {
		String url = "jdbc:h2:tcp://localhost/f:/h2/s1732126";
		try (Connection conn = DriverManager.getConnection(url, "user", "pass");) {
			if (number != 0 && urls != "null") {
				String sql = "INSERT INTO urlT(番号,URL) VALUES(?, ?)";
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

	public boolean delete(int number) {
		String url = "jdbc:h2:tcp://localhost/f:/h2/s1732126";
		try (Connection conn = DriverManager.getConnection(url, "user", "pass");) {
			String sql = "DELETE FROM urlT WHERE 番号 = ?";
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