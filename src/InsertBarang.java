import java.sql.*;
import java.util.Scanner;

public class InsertBarang {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/toko";
        String user = "root";
        String password = ""; // Ganti sesuai konfigurasi Anda

        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.print("Masukkan Kode Barang: ");
            String kode = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            int harga = scanner.nextInt();

            System.out.print("Masukkan Stok Barang: ");
            int stok = scanner.nextInt();

            String sql = "CALL insert_barang(?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, kode);
                stmt.setString(2, nama);
                stmt.setInt(3, harga);
                stmt.setInt(4, stok);
                stmt.execute();
                System.out.println("Data berhasil disimpan.");
            }

        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}