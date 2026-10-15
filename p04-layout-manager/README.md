# Tugas Praktikum PBO 2 - Pertemuan 4: Layout Manager dan Desain Form

- **Nama:** Novia Fitri
- **NPM:** 2410010284
- **Mata Kuliah:** Pemrograman Berbasis Objek 2 (PBO 2)

---

## 1. Studio Desain: Form Anggota Perpustakaan

### **Tahap 1: Sketsa Form di Kertas**
![Sketsa Form](images/sketsa_pbo4.jpeg)

---

### **Tahap 2: Tabel Rancangan**

| Bagian | Panel | Layout |
| :--- | :--- | :--- |
| **Jendela** | `FormAnggotaPerpustakaan` (JFrame) | BorderLayout |
| **Header** | `headerPanel` | BoxLayout (Y_AXIS) |
| **Isi form** | `isiPanel` (dibungkus `formPanel`) | BorderLayout & GridBagLayout |
| **Tombol** | `tombolPanel` | FlowLayout (Right) |

---

## 2. Tangkapan Layar (Screenshots) Form Anggota Perpustakaan

### **A. Ukuran Awal**
![Ukuran Awal](images/FormUkuranAwal.png)

### **B. Saat Dilebarkan**
![Saat Dilebarkan](images/FormSaatdiLebarkan.png)

### **C. Tampilan Tab Design & Navigator NetBeans**
![Navigator](images/TabDesignNavigatorFormAngg.png)

---

## 3. Jawaban Eksperimen

### **Jawaban Eksperimen Praktikum 2 (Galeri Layout):**
1. **FlowLayout Center:** Tombol berpindah ke tengah. Saat ukuran jendela diperkecil, tombol yang tidak muat berpindah ke baris bawah dan setiap barisnya tetap rata tengah. Di kode `initComponents()`, parameter orientasi `FlowLayout.LEFT` berubah menjadi `FlowLayout.CENTER`.
2. **GridLayout Rows 0, Columns 2:** Terbentuk 5 baris. Karena nilai `Rows` diatur `0`, jumlah baris dihitung secara otomatis berdasarkan 9 tombol dibagi 2 kolom (menghasilkan 4,5 lalu dibulatkan ke atas menjadi 5 baris). Baris terakhir hanya berisi 1 tombol.
3. **BoxLayout Maximum Size 32767:** Tombol melebar hingga memenuhi lebar panel (sebelumnya hanya selebar teks tombol). Hal ini terjadi karena `BoxLayout` menyesuaikan dengan ukuran maksimum komponen. Penambahan *Vertical Strut* menambahkan jarak ruang kosong secara vertikal di antara tombol.

### **Jawaban Eksperimen Praktikum 4 (Form Biodata):**
1. **Weight X namaField 0.0:** `namaField` tetap ikut melebar. Hal ini terjadi karena komponen isian lain pada kolom yang sama masih memiliki nilai `Weight X` sebesar `1.0`, sehingga lebar kolom mengikuti bobot (*weight*) terbesar. Isian baru akan berhenti melebar jika seluruh komponen pada kolom tersebut diubah nilai `Weight X`-nya menjadi `0.0`.
2. **Direction formPanel dari North ke Center:** `formPanel` akan tertarik memenuhi tinggi `isiPanel`, sehingga baris form tidak lagi menempel di bagian atas dan akan bergeser/tersebar saat tinggi jendela ditambah. Jika diatur ke `North`, posisi baris form tetap menempel di atas dan sisa ruang kosong berada di bagian bawah.
3. **Tanpa setMinimumSize:** Jendela aplikasi dapat diperkecil melebihi batas ideal hingga komponen di dalamnya tidak muat. Komponen yang mengecil terlebih dahulu adalah *Text Area* (Alamat), baru kemudian label teks mulai terpotong. Penggunaan `setMinimumSize` berfungsi mencegah ukuran jendela dikecilkan melebihi ukuran awal agar tampilan form tetap rapi.

---

## 4. Tahap 4: Saling Menilai (Peer Review)

| No | Pemeriksaan | Ya atau Belum |
| :---: | :--- | :---: |
| 1 | Label singkat, jelas, dan sejajar | Ya |
| 2 | Isian dikelompokkan dengan judul bagian | Ya |
| 3 | Placeholder dipakai untuk isian yang punya format | Ya |
| 4 | Komponen sesuai jenis data | Ya |
| 5 | Tombol utama menonjol dan berada di kanan bawah | Ya |
| 6 | Jarak antar komponen konsisten | Ya |
| 7 | Form tetap rapi saat jendela dilebarkan dan ditinggikan | Ya |
| 8 | Tampilan dibuat dengan JFrame Form dan layout manager, bukan Null Layout atau Absolute Layout | Ya |

- **Saran Perbaikan dari Teman:** Form sudah sangat rapi dan responsif saat dilebarkan. Sebaiknya perhatikan konsistensi margin/padding tepi agar ruang kosong kiri dan kanan terlihat seimbang saat dijalankan di layar beresolusi tinggi.

---

## 5. Deklarasi Penggunaan AI
- **Alat AI yang digunakan:** Gemini (Google)
- **Keperluan:** Membantu memahami konsep penggunaan Layout Manager (BorderLayout, GridBagLayout, BoxLayout) serta penataan dokumentasi laporan praktikum.
