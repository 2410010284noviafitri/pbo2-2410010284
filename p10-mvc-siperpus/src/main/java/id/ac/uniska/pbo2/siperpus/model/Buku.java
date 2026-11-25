package id.ac.uniska.pbo2.siperpus.model;

/** Data satu judul buku. Nilai id 0 berarti buku belum pernah disimpan. */
public record Buku(int id, String kode, String judul, String penulis, int tahun, int stok) {

    /** Salinan buku dengan id baru, dipakai setelah buku disimpan. */
    public Buku denganId(int idBaru) {
        return new Buku(idBaru, kode, judul, penulis, tahun, stok);
    }

    /** Salinan buku dengan stok baru, dipakai saat buku dipinjam atau dikembalikan. */
    public Buku denganStok(int stokBaru) {
        return new Buku(id, kode, judul, penulis, tahun, stokBaru);
    }
}