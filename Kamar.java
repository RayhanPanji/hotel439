abstract class Kamar {
    private String tipeKamar;
    private double harga;

    public Kamar(String tipeKamar, double harga) {
        this.tipeKamar = tipeKamar;
        this.harga = harga;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public double getHarga() {
        return harga;
    }
}
