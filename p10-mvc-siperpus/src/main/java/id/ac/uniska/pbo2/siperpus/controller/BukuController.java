package id.ac.uniska.pbo2.siperpus.controller;

import id.ac.uniska.pbo2.siperpus.dao.BukuDao;
import id.ac.uniska.pbo2.siperpus.model.Buku;
import id.ac.uniska.pbo2.siperpus.view.PanelBuku;
import java.util.List;

/**
 * Menghubungkan PanelBuku (view) dengan BukuDao (model).
 * View tidak tahu cara data disimpan, dan DAO tidak tahu data ditampilkan di mana.
 */
public class BukuController {

    private final BukuDao dao;
    private final PanelBuku view;

    public BukuController(BukuDao dao, PanelBuku view) {
        this.dao = dao;
        this.view = view;
        view.getTambahButton().addActionListener(e -> tambah());
        view.getUbahButton().addActionListener(e -> ubah());
        view.getHapusButton().addActionListener(e -> hapus());
        view.getCariButton().addActionListener(e -> muatData());
        view.getCariField().addActionListener(e -> muatData());
        muatData();
    }

    /** Mengambil data dari DAO lalu meminta view menampilkannya. */
    public void muatData() {
        String kata = view.getKataKunci();
        List<Buku> data = kata.isEmpty() ? dao.semua() : dao.cari(kata);
        view.tampilkanData(data);
    }

    private void tambah() {
        Buku isian = null;
        while (true) {
            isian = view.tampilkanDialog("Tambah Buku", isian);
            if (isian == null) {
                return; // dibatalkan pengguna
            }
            if (dao.cariKode(isian.kode()) == null) {
                break;
            }
            // Dialog dibuka lagi dengan isian sebelumnya agar pengguna tidak mengetik ulang
            view.tampilkanKesalahan("Kode " + isian.kode() + " sudah dipakai buku lain.");
        }
        dao.tambah(isian);
        muatData();
        view.tampilkanInfo("Buku \"" + isian.judul() + "\" berhasil ditambahkan.");
    }

    private void ubah() {
        Buku lama = view.getBukuTerpilih();
        if (lama == null) {
            return;
        }
        Buku isian = lama;
        while (true) {
            isian = view.tampilkanDialog("Ubah Buku", isian);
            if (isian == null) {
                return;
            }
            Buku pemilikKode = dao.cariKode(isian.kode());
            if (pemilikKode == null || pemilikKode.id() == lama.id()) {
                break;
            }
            view.tampilkanKesalahan("Kode " + isian.kode() + " sudah dipakai buku lain.");
        }
        dao.ubah(isian);
        muatData();
        view.tampilkanInfo("Buku \"" + isian.judul() + "\" berhasil diubah.");
    }

    private void hapus() {
        Buku buku = view.getBukuTerpilih();
        if (buku == null) {
            return;
        }
        if (view.konfirmasi("Hapus buku \"" + buku.judul() + "\"?")) {
            dao.hapus(buku.id());
            muatData();
            view.tampilkanInfo("Buku \"" + buku.judul() + "\" berhasil dihapus.");
        }
    }
    
   
}