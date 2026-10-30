# Pertemuan 7: Tabel, Menu, dan Navigasi (P07)

---

## 1. Jawaban Eksperimen Praktikum 5

1. **Ketik huruf pada isian NPM. Apa yang terjadi dan baris mana di npmFieldKeyTyped yang menyebabkannya?:**  
   Saat diketik huruf tidak ada muncul apa apa dalam kotak isian, ini disebabkan karena di `npmFieldKeyTyped` terdapat kode `if (!Character.isDigit(evt.getKeyChar()) || penuh) { evt.consume(); }` itu lah yang menyebabkan huruf tidak masuk ke kotak isian.
        
2. **Isi email dengan `siti@`, lalu tekan Tab:**  
   Pesan kesalahan muncul saat fokus keluar dari isian (`event focusLost`), bukan pada saat pengguna sedang mengetik.

3. **Klik isian Nama tanpa mengetik, lalu tekan Tab. Mengapa tidak ada pesan kesalahan?:**  
   Tidak ada pesan apapun karena `focusLost` hanya memeriksa jika isian tidak kosong (`!isBlank()`). Isian kosong baru diperiksa saat Daftar diklik.

4. **Centang persetujuan, lalu klik Daftar dengan form kosong, isian mana yang mendapat fokus:**  
   Fokus ke NPM, karena itu kesalahan pertama yang ada di urutan pemeriksaan.

5. **Tekan tombol Alt bersama huruf N. Isian mana yang mendapat fokus, dan properti apa yang mengaturnya?:**  
   Diatur oleh properti `displayedMnemonic` pada label Nama (dan terhubung ke isian lewat `labelFor`).

6. **Isi beberapa isian, lalu klik Batal dan pilih No. Apakah data tetap ada?:**  
   Data tetap ada, karena `batal()` melakukan `return` sebelum `kosongkan()`.

---

## 2. Tautan Video Demo Mini Proyek
Link Video Demo P07: [Google Drive - Video Demo P07](https://drive.google.com/file/d/1ncDpa8Cc7y4GlKYWxIA74l2tDSlwJJqw/view?usp=sharing) *(Durasi: 2 menit 59 detik, memperlihatkan sekilas tab Design, jendela Navigator, serta seluruh fitur pada tabel)*

---

## 3. Deklarasi Penggunaan AI
- **Aplikasi yang digunakan:** Gemini
- **Deklarasi Penggunaan:** Membantu menyusun struktur format laporan README serta merapikan dokumentasi jawaban eksperimen praktikum P07.
