import java.sql.*;

public class ViewBarang {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/toko";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM view_barang");

            System.out.println("Kode\tNama\tHarga\tStok\tTotal Nilai");
            while (rs.next()) {
                System.out.printf("%s\t%s\t%d\t%d\t%d\n",
                        rs.getString("kode"),
                        rs.getString("nama"),
                        rs.getInt("harga"),
                        rs.getInt("stok"),
                        rs.getInt("total_nilai"));
            }

        } catch (SQLException e) {
            System.err.println("Gagal menampilkan data: " + e.getMessage());
        }
    }
}
