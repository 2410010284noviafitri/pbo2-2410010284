//Nama: Novia Fitri | NPM:2410010284

package id.ac.uniska.pbo2.uts;

/**
 *
 * @author user
 */
public enum Kategori {
    ALAT_TULIS("Alat Tulis"), MAKANAN("Makanan"),
    MINUMAN("Minuman"), LAINNYA("Lainnya");

    private final String label;
    Kategori(String label) { this.label = label; }
    @Override public String toString() { return label; }
    
}
