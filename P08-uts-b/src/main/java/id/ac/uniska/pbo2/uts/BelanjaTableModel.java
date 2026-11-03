//Nama: Novia Fitri | NPM:2410010284
package id.ac.uniska.pbo2.uts;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BelanjaTableModel extends AbstractTableModel {

    private static final String[] KOLOM = {"Nama Barang", "Kategori", "Harga", "Jumlah", "Subtotal"};
    private final List<Barang> daftarBarang = new ArrayList<>();

    @Override
    public int getRowCount() { return daftarBarang.size(); }

    @Override
    public int getColumnCount() { return KOLOM.length; }

    @Override
    public String getColumnName(int kolom) { return KOLOM[kolom]; }

    @Override
    public Class<?> getColumnClass(int kolom) {
        return switch (kolom) {
            case 0 -> String.class;
            case 1 -> Kategori.class;
            case 4 -> Long.class;
            default -> Integer.class;
        };
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        Barang b = daftarBarang.get(baris);
        return switch (kolom) {
            case 0 -> b.nama();
            case 1 -> b.kategori();
            case 2 -> b.harga();
            case 3 -> b.jumlah();
            default -> b.subtotal();
        };
    }

    public void tambah(Barang barang) {
        daftarBarang.add(barang);
        int baris = daftarBarang.size() - 1;
        fireTableRowsInserted(baris, baris);
    }

    public boolean sudahAda(String nama) {
        for (Barang b : daftarBarang) {
            if (b.nama().equalsIgnoreCase(nama.trim())) return true;
        }
        return false;
    }

    public long getTotal() {
        long total = 0;
        for (Barang b : daftarBarang) total += b.subtotal();
        return total;
    }

    public long getDiskon() { return getTotal() >= 100000 ? getTotal() / 10 : 0; }

    public long getBayar() { return getTotal() - getDiskon(); }
    
    public static String rupiah(long angka) {
    return "Rp" + String.format(java.util.Locale.US, "%,d", angka).replace(',', '.');
}
}