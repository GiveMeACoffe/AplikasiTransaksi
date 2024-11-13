import java.util.Scanner;

public class AplikasiTransaksi {


    public static double hitungTotal(double harga, int jumlah) {
        if (harga < 0 || jumlah < 0) {
            throw new IllegalArgumentException("Harga dan jumlah harus bernilai non-negatif.");
        }
        return harga * jumlah;
    }


    public static boolean validasiUsername(String username) {
        if (username.length() < 5 || username.length() > 15) {
            return false; 
        }
        return username.matches("[a-zA-Z0-9_]+"); 
    }


    public static double terapkanDiskon(double total, double diskon) {
        if (diskon == 0) {
            throw new ArithmeticException("Persentase diskon tidak boleh nol.");
        }
        return total - (total * (diskon / 100));
    }


    public static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Format angka tidak valid: " + input);
        }
    }


    public static double hitungTotalPembelian(double[] hargaProduk) {
        if (hargaProduk.length == 0) {
            throw new IllegalArgumentException("Daftar harga produk tidak boleh kosong.");
        }
        double total = 0;
        for (double harga : hargaProduk) {
            total += harga;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Selamat datang di Aplikasi Belanja.");
        System.out.print("Masukkan username: ");
        String username = scanner.next();
        

        if (validasiUsername(username)) {
            System.out.println("Username valid.");
        } else {
            System.out.println("Username tidak valid. Username harus antara 5-15 karakter dan hanya mengandung huruf, angka, atau underscore.");
            return;  
        }

        System.out.println("Masukkan harga produk yang ingin dibeli:");
        System.out.print("Harga produk: ");
        double harga = scanner.nextDouble();
        System.out.print("Jumlah produk: ");
        int jumlah = scanner.nextInt();

        try {
            double total = hitungTotal(harga, jumlah);
            System.out.println("Total harga tanpa diskon: " + total);


            System.out.print("Masukkan persentase diskon: ");
            double diskon = scanner.nextDouble();
            double totalDenganDiskon = terapkanDiskon(total, diskon);
            System.out.println("Total harga setelah diskon: " + totalDenganDiskon);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }


        System.out.print("Masukkan jumlah produk yang ingin dibeli: ");
        String input = scanner.next();
        try {
            int jumlahProduk = parseInteger(input);
            double[] hargaProduk = new double[jumlahProduk];
            System.out.println("Masukkan harga untuk " + jumlahProduk + " produk:");
            for (int i = 0; i < jumlahProduk; i++) {
                hargaProduk[i] = scanner.nextDouble();
            }

            try {
                double totalPembelian = hitungTotalPembelian(hargaProduk);
                System.out.println("Total harga pembelian: " + totalPembelian);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
