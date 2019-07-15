package bookmark;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SelectUrlSample {
public static void main(String args[]) {
try {
Class.forName("org.h2.Driver");
} catch (Exception e) {
e.printStackTrace();
}
String url = "jdbc:h2:tcp://localhost/f:/h2/s1732126";
try (Connection conn = DriverManager.getConnection(url, "user", "pass");) {
String sql = "SELECT URL,番号, FROM urlT";
PreparedStatement pStmt = conn.prepareStatement(sql);
ResultSet rs = pStmt.executeQuery();
while (rs.next()) {
int number = rs.getInt("番号");
String urls = rs.getString("URL");

System.out.printf("%3d [%3d] \n",number, urls);
}
} catch (SQLException e) {
e.printStackTrace();
}
}
}