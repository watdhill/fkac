class Transaksi extends Produk {
    private String noFaktur;
    private int jumlahBeli;
    private double total;

    public Transaksi (String kodeBarang, String namaBarang, double hargaBarang, String noFaktur, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang); // Menggunakan inheritance
        this.noFaktur = noFaktur;
        this.jumlahBeli = jumlahBeli;
        this.total = 0; // Total akan dihitung melalui metode hitungTotal()
    }

    public void hitungTotal() {
        try {
            // Exception handling untuk memastikan jumlah beli dan harga valid
            if (jumlahBeli < 0 || hargaBarang < 0){
                throw new IllegalArgumentException("Jumlah beli dan harga barang harus bernilai positif.");
            }
            total = jumlahBeli * hargaBarang;
        }catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            total = 0;
        }
    }

    public String displayInvoice() {
        return "No Faktur: " + noFaktur + "\n"
                + displayInfo() + "\n"
                + "Jumlah Beli: " + jumlahBeli + "\n"
                + "Total: " + total;
    }
}