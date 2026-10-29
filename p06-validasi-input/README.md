# Pertemuan 6: Validasi Input dan Kegunaan (P06)

---

## 1. Jawaban Eksperimen (Praktikum 4)

1. **Ketik huruf pada isian NPM. Apa yang terjadi dan baris mana di npmFieldKeyTyped yang menyebabkannya?**:                                     Saat di ketik huruf tidak ada muncul apa apa dalam kotak isian, ini di sebabkan  karena di npmFieldKeyTyped terdapat kode " if (!Character.isDigit(evt.getKeyChar()) || penuh) { 
        evt.consume();" itu lah yang menyebabkan huruf tidak masuk ke kotak isian.
        
2. **Isi email dengan `siti@`, lalu tekan Tab:**  
   Pesan kesalahan muncul saat fokus keluar dari isian (`event focusLost`), bukan pada saat pengguna sedang mengetik.

3. **Klik isian Nama tanpa mengetik, lalu tekan Tab. Mengapa tidak ada pesan kesalahan?:**  
   Tidak ada pesan apapun karena focusLost hanya memeriksa jika isian tidak kosong (!isBlank()). Isian kosong baru diperiksa saat Daftar diklik.

4. **Centang persetujuan, lalu klik Daftar dengan form kosong, isian mana yang mendapat fokus:**  
   Fokus ke NPM, karena itu kesalahan pertama yang ada di urutan pemeriksaan.

5. **Tekan tombol Alt bersama huruf N. Isian mana yang mendapat fokus, dan properti apa yang mengaturnya?:**  
 Diatur oleh properti displayedMnemonic pada label Nama (dan terhubung ke isian lewat labelFor).

6. **Isi beberapa isian, lalu klik Batal dan pilih No. Apakah data tetap ada?:** 
   Data tetap ada, karena batal() melakukan return sebelum kosongkan().

---

## 2. Tangkapan Layar (Screenshots)

Berikut adalah lampiran tangkapan layar pengujian aplikasi *Form Anggota Perpustakaan*:

1. **Form dengan Pesan Kesalahan:**  
   ![Form Dengan Kesalahan](SS_FormDenganKesalahan.png)

2. **Jendela Navigator (Hierarki Label Pesan):**  
   ![Tab Design Navigator](SS_TabDesignNavigator.png)

---

## 3. Lembar Peer Review & Tabel Perbaikan

### A. Lampiran Foto / Pindaian Lembar Peer Review
Berikut adalah dua foto/pindaian lembar *peer review* yang diterima dari teman peninjau:
1. ![Lembar Peer Review 1](peer_review_sheet_1.jpg)
2. ![Lembar Peer Review 2](peer_review_sheet_2.jpg)

### B. Tabel Singkat Temuan, Perbaikan, dan Commit
| No | Temuan dari Teman | Perbaikan yang Dilakukan | Commit yang Memuat Perbaikan |
| :--- | :--- | :--- | :--- |
| **1** | Status ringkasan kesalahan di bawah form sudah jelas dan mudah dipahami. | Mempertahankan status dan pesan merah pada bagian bawah form. | `P06: Validasi input dan umpan balik` |
| **2** | Input NPM dan nomor HP sudah dibatasi dengan baik hanya angka. | Memastikan event `keyTyped` berjalan optimal mengonsumsi karakter non-angka. | `P06: Validasi input dan umpan balik` |
| **3** | Pesan kesalahan pada email kurang spesifik memperlihatkan format contoh. | Menambahkan format contoh yang jelas (`nama@contoh.com` dan `08xxxxxxxxxx`). | `P06: Perbaikan pesan error validator` |

---

## 4. Pertanyaan Refleksi

1. **Mengapa aturan validasi dipisahkan ke kelas Validator?**  
   Agar aturan validasi terpisah dari logika tampilan (GUI), sehingga kode lebih bersih dan mudah diuji secara mandiri (misalnya menggunakan JUnit di pertemuan selanjutnya).

2. **Mengapa isian kosong tidak langsung ditandai merah saat dilewati?**  
   Untuk menjaga kenyamanan pengguna (menghindari pengalaman interaksi yang terlalu mengintimidasi saat pengguna baru mulai bernavigasi melewati form). Validasi kosong secara serentak dilakukan saat tombol Daftar ditekan.

3. **Sebutkan tiga heuristik Nielsen yang diterapkan:**  
   - *Pencegahan kesalahan* (membatasi input NPM/HP hanya angka).
   - *Visibilitas status sistem* (menampilkan jumlah isian yang perlu diperbaiki).
   - *Kendali dan kebebasan pengguna* (konfirmasi saat membatalkan pengisian form).

4. **Mengapa pesan kesalahan tidak boleh hanya berupa warna merah?**  
   Karena sebagian pengguna mungkin mengalami kondisi buta warna, sehingga pesan teks yang jelas dan spesifik di bawah isian sangat diperlukan.

5. **Temuan peer review yang paling bermanfaat:**  
   Memastikan konsistensi aksesibilitas seperti `labelFor` dan penekanan tombol cepat (`mnemonic`) agar form dapat dioperasikan secara efisien menggunakan papan ketik (*keyboard*).

---

## 5. Deklarasi Penggunaan AI

- **Aplikasi yang digunakan:** Gemini AI
- **Deklarasi Penggunaan:** Membantu menyusun laporan praktikum `README.md`, merapikan format jawaban eksperimen praktikum, menyusun tabel ringkasan peer review, serta memandu langkah-langkah Git.
