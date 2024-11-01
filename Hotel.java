import java.util.Scanner;

class Hotel {
    private String namaHotel;
    private Kamar[] kamars;
    private Reservasi[] reservasis;
    private int jumlahReservasi;

    public Hotel(String namaHotel) {
        this.namaHotel = namaHotel;
        this.kamars = new Kamar[2];
        this.reservasis = new Reservasi[10];
        this.jumlahReservasi = 0;

        kamars[0] = new StandarKamar();
        kamars[1] = new SuiteKamar();
    }

    public void tambahReservasi(Reservasi reservasi) {
        if (jumlahReservasi < reservasis.length) {
            reservasis[jumlahReservasi++] = reservasi;
        }
    }

    public void displayKamar() {
        System.out.println("Pilihan Kamar:");
        for (int i = 0; i < kamars.length; i++) {
            if (kamars[i] != null) {
                System.out.println((i + 1) + ". " + kamars[i].getTipeKamar() + " - Rp " + kamars[i].getHarga());
            }
        }
        System.out.println("Jam Checkin: 14.00\nJam Checkout: 12.00");
        System.out.println("Note: Silahkan tunjukkan identitas KTP anda saat Checkin");
    }

    public void displayReservasi() {
        System.out.println("Rincian Reservasi:");
        for (Reservasi reservasi : reservasis) {
            if (reservasi != null) {
                System.out.println("Tamu: " + reservasi.getTamu().getNama());
                System.out.println("No Telepon: " + reservasi.getTamu().getNoTelepon());
                System.out.println("Kamar: " + reservasi.getKamar().getTipeKamar());
                System.out.println("Harga per malam: Rp " + reservasi.getKamar().getHarga());
                System.out.println("Total biaya: Rp " + reservasi.getTotalBiaya());
                System.out.println("Nomor Kamar: " + reservasi.getNomorKamar());
                System.out.println("\nTerimakasih,\nSilakan datang dan melakukan pembayaran.");
                System.out.println();
            }
        }
    }

    public void prosesReservasi() {
        Scanner scanner = new Scanner(System.in);
        displayKamar();

        System.out.print("\nNama Tamu: ");
        String namaTamu = scanner.nextLine();

        System.out.print("No Telepon Tamu: ");
        String noTelepon = scanner.nextLine();

        System.out.print("Berapa hari menginap: ");
        int hariMenginap = scanner.nextInt();

        System.out.print("Pilih kamar (1 untuk Standar, 2 untuk Suite): ");
        int pilihanKamar = scanner.nextInt();
        Kamar kamarPilihan = null;

        if (pilihanKamar == 1) {
            kamarPilihan = kamars[0];
        } else if (pilihanKamar == 2) {
            kamarPilihan = kamars[1];
        }

        if (kamarPilihan != null) {
            Reservasi reservasi;
            reservasi = (kamarPilihan instanceof StandarKamar) ?
                    new ReservasiStandar(new TamuUmum(namaTamu, noTelepon), (StandarKamar) kamarPilihan, hariMenginap, 1) :
                    new ReservasiSuite(new TamuUmum(namaTamu, noTelepon), (SuiteKamar) kamarPilihan, hariMenginap, 2);

            tambahReservasi(reservasi);
            System.out.println("\nReservasi berhasil! Kamar yang dipilih: " + kamarPilihan.getTipeKamar());
        } else {
            System.out.println("Pilihan kamar tidak valid.");
        }
    }

    public void welcomeMessage() {
        System.out.println("Selamat datang di " + namaHotel + "!");
    }
}