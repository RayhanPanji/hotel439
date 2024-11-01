abstract class Reservasi {
    private Tamu tamu;
    private Kamar kamar;
    private int hariMenginap;
    private int nomorKamar;

    public Reservasi(Tamu tamu, Kamar kamar, int hariMenginap, int nomorKamar) {
        this.tamu = tamu;
        this.kamar = kamar;
        this.hariMenginap = hariMenginap;
        this.nomorKamar = nomorKamar;
    }

    public Tamu getTamu() {
        return tamu;
    }

    public Kamar getKamar() {
        return kamar;
    }

    public int getHariMenginap() {
        return hariMenginap;
    }

    public int getTotalBiaya() {
        return (int) (kamar.getHarga() * hariMenginap);
    }

    public int getNomorKamar() {
        return nomorKamar;
    }
}