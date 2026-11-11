import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class gaji {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            // Menggunakan sintaks Locale standar agar kompatibel di semua versi Java
            Locale indonesia = new Locale("id", "ID");
            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(indonesia);

            double[] arraygaji = { 5000000, 6500000, 9500000 };
            double[] arraylembur = { 0.30, 0.32, 0.34, 0.36, 0.38 };


            String golongan;
            int jamlembur;
            double gajipokok = 0;
            double gajilembur = 0;

            // Validasi Input Golongan
            while (true) {
                System.out.print("Masukkan golongan (A/B/C) atau ketik 'exit' untuk keluar: ");
                golongan = input.nextLine().trim().toUpperCase();

                if (golongan.equals("EXIT")) {
                    return;
                }
                if (golongan.equals("A") || golongan.equals("B") || golongan.equals("C")) {
                    break;
                }
                System.out.println("Golongan tidak valid. Silakan masukkan A, B, atau C.\n");
            }

            // Validasi Input Jam Lembur (Boleh 0 jam jika tidak lembur)
            while (true) {
                System.out.print("Masukkan jam lembur (0 atau lebih): ");
                if (input.hasNextInt()) {
                    jamlembur = input.nextInt();
                    if (jamlembur >= 0) {
                        break;
                    }
                } else {
                    input.next(); // Bersihkan input yang bukan angka
                }
                System.out.println("Jam lembur tidak valid. Masukkan angka 0 atau lebih besar.\n");
            }

            // 1. Penentuan Gaji Pokok Menggunakan Statemen IF
            if (golongan.equals("A")) {
                gajipokok = arraygaji[0];
            } else if (golongan.equals("B")) {
                gajipokok = arraygaji[1];
            } else if (golongan.equals("C")) {
                gajipokok = arraygaji[2];
            }

            // 2. Penentuan Persentase Lembur Menggunakan Statemen IF
            double persenlembur = 0;
            if (jamlembur == 1) {
                persenlembur = arraylembur[0];
            } else if (jamlembur == 2) {
                persenlembur = arraylembur[1];
            } else if (jamlembur == 3) {
                persenlembur = arraylembur[2];
            } else if (jamlembur == 4) {
                persenlembur = arraylembur[3];
            } else if (jamlembur >= 5) {A
                persenlembur = arraylembur[4];
            }

            // Perhitungan Gaji
            gajilembur = gajipokok * persenlembur;
            double totalgaji = gajipokok + gajilembur;

            // Output Hasil
            System.out.println("\n------------------------------");
            System.out.println("         TOTAL GAJI           ");
            System.out.println("------------------------------");
            System.out.println("Golongan     : " + golongan);
            System.out.println("Jam Lembur   : " + jamlembur + " Jam");
            System.out.println("Gaji Pokok   : " + formatRupiah.format(gajipokok));
            System.out.println("Gaji Lembur  : " + formatRupiah.format(gajilembur));
            System.out.println("------------------------------");
            System.out.println("Total Gaji   : " + formatRupiah.format(totalgaji));
        }
    }
}