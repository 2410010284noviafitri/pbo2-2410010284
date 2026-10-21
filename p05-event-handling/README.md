# Pertemuan 5: Event Handling (P05)

Repositori ini berisi tugas dan Latihan Mandiri Pemrograman Berorientasi Objek 2 (PBO 2) untuk topik **Event Handling** pada Java Swing menggunakan NetBeans dan Maven.

---

## 1. Tabel Pengamatan Praktikum 2

| No | Tindakan | Event yang Tercatat |
| :--- | :--- | :--- |
| **1** | Arahkan kursor ke tombol, lalu jauhkan | `MouseEvent` (kursor masuk/keluar area tombol) |
| **2** | Klik tombol **Klik saya** | `ActionEvent` (tombol diklik) |
| **3** | Centang lalu hapus centang **Aktifkan fitur** | `ItemEvent` (status centang berubah) |
| **4** | Ganti pilihan dari **Pagi** menjadi **Malam** | `ItemEvent` (perubahan item yang dipilih) |
| **5** | Klik isian, lalu ketik kata **"abc"** | `FocusEvent` (fokus kursor), `KeyEvent` (input karakter a, b, c) |
| **6** | Klik tombol setelah mengetik di isian | `FocusEvent` (isian kehilangan fokus), `ActionEvent` (tombol diklik) |

---

## 2. Jawaban Eksperimen

### Eksperimen Praktikum 3 (Konversi Suhu)
1. **Pesan tercetak setelah `if` dihapus:**  
   Pesan tercetak dua kali karena mendeteksi dua kondisi perubahan status (`DESELECTED` dan `SELECTED`).
2. **Keterlambatan hasil pada `keyPressed`:**  
   Event `keyPressed` dipicu *sebelum* karakter baru selesai dimasukkan ke dalam komponen teks, sehingga `getText()` membaca teks lama.
3. **Hasil tanpa `try-catch` saat diisi huruf:**  
   Program mengalami error eksepsi `NumberFormatException` di jendela Output karena huruf tidak dapat diubah menjadi tipe data numerik (`Double`).

### Eksperimen Praktikum 4 (Kalkulator Sederhana)
1. **Dua kali pesan & penanganan tombol:**  
   Pesan tercetak dua kali karena ada dua listener aktif bersamaan (GUI Builder + Lambda). Tombol sebaiknya hanya menggunakan satu cara penanganan event agar aksi tidak dieksekusi ganda.
2. **Perubahan untuk Operator Modulus (`%`):**  
   - **Tab Design:** Menambahkan komponen tombol baru dengan teks `%`.  
   - **Tab Source:** Menambahkan kondisi baru pada ekspresi switch/if: `case '%' -> a % b;`.
3. **Kursor kembali ke isian pertama:**  
   Karena method `hapus` memanggil perintah `angka1Field.requestFocusInWindow();` yang mengarahkan kursor kembali secara otomatis ke isian pertama.

---

## 3. Peta Event - Form Anggota Perpustakaan

Tabel pemetaan event handling untuk Latihan Mandiri `FormAnggota`:

| Komponen | Menu Events | Aksi / Deskripsi |
| :--- | :--- | :--- |
| **Kotak Centang Setuju** (`setujuCheck`) | `Item` $\rightarrow$ `itemStateChanged` | Tombol **Daftar** hanya aktif jika kotak centang dicentang. |
| **Tombol Batal** (`batalButton`) | `Action` $\rightarrow$ `actionPerformed` | Mengosongkan seluruh isian form dan mengembalikan fokus kursor ke isian NPM. |
| **Tombol Daftar** (`daftarButton`) | `Action` $\rightarrow$ `actionPerformed` | Menampilkan ringkasan data yang diisi menggunakan dialog `JOptionPane`. |
| **Isian NPM** (`npmField`) | `Key` $\rightarrow$ `keyReleased` | Menampilkan indikator jumlah digit NPM secara dinamis (misal: "8 dari 10 digit"). |
| **Form** (`JFrame` di Navigator) | `Window` $\rightarrow$ `windowClosing` | Menampilkan dialog konfirmasi `JOptionPane` sebelum jendela ditutup. |

---

## 4. Tangkapan Layar (Screenshots)

Berikut adalah lampiran tangkapan layar pengujian aplikasi Latihan Mandiri *Form Anggota Perpustakaan*:

1. **Jendela Properties Bagian Events (Tombol Daftar):**  
   ![Properties Event Tombol Daftar](images5/SSTabPropertiesEvent.png)

2. **Dialog Ringkasan Pendaftaran (`JOptionPane`):**  
   ![Ringkasan Pendaftaran](images5/SSRingkasanDaftar.png)

3. **Dialog Konfirmasi Keluar Aplikasi (`Window Closing`):**  
   ![Konfirmasi Keluar](images5/SSKonfirmasiKeluar.png)

---

## 5. Deklarasi Penggunaan AI

Aplikasi dan dokumen README ini dikembangkan dengan bantuan AI (**Gemini**) untuk keperluan:
- Konsultasi logika event handling Java Swing.
- Pengecekan sintaks dan pemecahan masalah Git repository.
- Penyusunan format laporan dan tabel pemetaan event.
