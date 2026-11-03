//Nama: Novia Fitri | NPM:2410010284

package id.ac.uniska.pbo2.uts;

/**
 *
 * @author user
 */
public record Barang(String nama, Kategori kategori, int harga, int jumlah) {
    public long subtotal() { return (long) harga * jumlah; }
}
