import java.util.ArrayList;
import java.util.Scanner;

//Inheritance dan Abstraction
abstract class Rakyat {
    private String nama;
    private String alamat;
    private String kelamin;
    private String ttl;

    public Rakyat(String nama, String alamat, String kelamin, String ttl) {
        this.nama = nama;
        this.alamat = alamat;
        this.kelamin = kelamin;
        this.ttl = ttl;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getKelamin() {
        return kelamin;
    }

    public String getTtl() {
        return ttl;
    }

    // abstrak turunan
    public abstract void tampilData();
}

// Encapsulation
class Pasien extends Rakyat {
    private String nik;
    private String nomorBPJS;

    public Pasien(String nama, String alamat, String kelamin, String ttl, String nik, String nomorBPJS) {
        super(nama, alamat, kelamin, ttl);
        this.nik = nik;
        this.nomorBPJS = nomorBPJS;
    }

    public String getNIK() {
        return nik;
    }

    public String getNomorBPJS() {
        return nomorBPJS;
    }

    // metode abstrak dari kelas dasar dan Polymorphism
    @Override
    public void tampilData() {
        System.out.println("Data Pasien:");
        System.out.println("Nama: " + getNama());
        System.out.println("Alamat: " + getAlamat());
        System.out.println("Kelamin: " + getKelamin());
        System.out.println("TTL: " + getTtl());
        System.out.println("NIK: " + getNIK());
        System.out.println("Nomor BPJS: " + getNomorBPJS());
    }
}

// Encapsulation
class Poli {
    private String nama;
    private String dokter;
    private String jadwal;
    private String jam;
    private ArrayList<Antrian> antrianList;

    public Poli(String nama, String dokter, String jadwal, String jam) {
        this.nama = nama;
        this.dokter = dokter;
        this.jadwal = jadwal;
        this.jam = jam;
        this.antrianList = new ArrayList<>();
    }

    public String getNamaPoli() {
        return nama;
    }

    public String getDokter() {
        return dokter;
    }

    public String getJadwal() {
        return jadwal;
    }
    public String getJam(){
        return jam;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public ArrayList<Antrian> getAntrianList() {
        return antrianList;
    }

    public void tambahAntrian(Antrian antrian) {
        antrianList.add(antrian);
    }


    public void tampilDataPoli() {
        System.out.println("Nama Poli: " + getNamaPoli());
        System.out.println("Nama Dokter: " + getDokter());
        System.out.println("Hari Praktek: " + getJadwal());
        System.out.println("Jam praktek: "+getJam());
    }
}

// Encapsulation
class Antrian {
    private Pasien pasien;
    private Poli poli;
    private int nomor;

    public Antrian(Pasien pasien, Poli poli, int nomor) {
        this.pasien = pasien;
        this.poli = poli;
        this.nomor = nomor;
    }

    public void tampilDataAntrian() {
        System.out.println("Nomor Antrian: " + nomor);
        pasien.tampilData();
        poli.tampilDataPoli();
    }
}

class Admin {
    private ArrayList<Poli> daftarPoli;
    private ArrayList<Antrian> daftarAntrian;
    private Scanner input;

    public Admin() {
        this.daftarPoli = new ArrayList<>();
        this.daftarAntrian = new ArrayList<>();
        this.input = new Scanner(System.in);
    }

    public void tambahPoli() {
        System.out.println("=== TAMBAH POLI ===");
        System.out.print("Masukkan nama poli: ");
        String nama = input.nextLine();
        System.out.print("Masukkan nama dokter: ");
        String dokter = input.nextLine();
        System.out.print("Masukkan jadwal praktek: ");
        String jadwal = input.nextLine();
        System.out.print("masukkan jam: ");
        String jam = input.nextLine();
        Poli poli = new Poli(nama, dokter, jadwal,jam);
        daftarPoli.add(poli);
        System.out.println("Poli berhasil ditambahkan.");
    }

    public void cetakDetailTransaksi() {
        System.out.println("=== CETAK DETAIL TRANSAKSI ===");
        if(daftarAntrian.size()>0){
            for (Antrian antrian : daftarAntrian) {
                antrian.tampilDataAntrian();
                System.out.println("=====================");
            }
        }else {
            System.out.println("belum adayang sakit....");
        }
    }

    public void tambahJadwalPraktekDokter() {
        System.out.println("=== TAMBAH JADWAL PRAKTEK DOKTER ===");
        if (daftarPoli.size()>0) {
            for (Poli poli : daftarPoli) {
                poli.getDokter();
                poli.tampilDataPoli();
                System.out.print("Masukkan jadwal praktek baru untuk " + poli.getNamaPoli() + ": ");
                String jadwal = input.nextLine();
                poli.setJadwal(jadwal);
                System.out.println("Jadwal praktek dokter berhasil ditambahkan.");
            }
        }else {
            System.out.println("belum kamu buat min poli nya....");
        }
    }

    public void updateJadwalPraktekDokter() {
        System.out.println("=== UPDATE JADWAL PRAKTEK DOKTER ===");
        if (daftarPoli.size()>0) {
            for (Poli poli : daftarPoli) {
                poli.tampilDataPoli();
                System.out.print("Masukkan jadwal praktek baru untuk " + poli.getNamaPoli() + ": ");
                String jadwal = input.nextLine();
                poli.setJadwal(jadwal);
                System.out.println("Jadwal praktek dokter berhasil diupdate..");
            }
        }else{
            System.out.println("belum ada..min admin");
        }
    }

    public void setDaftarAntrian(ArrayList<Antrian> daftarAntrian) {
        this.daftarAntrian = daftarAntrian;
    }

    public void setDaftarPoli(ArrayList<Poli> daftarPoli) {
        this.daftarPoli = daftarPoli;
    }
}

class Aplikasi {
    private ArrayList<Pasien> daftarPasien;
    private ArrayList<Poli> daftarPoli;
    private ArrayList<Antrian> daftarAntrian;
    private Admin admin;
    private Scanner input;

    public Aplikasi() {
        this.daftarPasien = new ArrayList<>();
        this.daftarPoli = new ArrayList<>();
        this.daftarAntrian = new ArrayList<>();
        this.admin = new Admin();
        this.input = new Scanner(System.in);
    }

    public void tampilMenuUtama() {
        System.out.println("=== PUSKESMAS ===");
        System.out.println("1. Pasien Baru");
        System.out.println("2. Ambil Antrian");
        System.out.println("3. Lihat Jadwal Praktek Dokter");
        System.out.println("4. Login Admin");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    public void tampilMenuAdmin() {
        System.out.println("=== MENU ADMIN ===");
        System.out.println("1. Tambah Poli");
        System.out.println("2. Cetak Detail Transaksi");
        System.out.println("3. Tambah Jadwal Praktek Dokter");
        System.out.println("4. Update Jadwal Praktek Dokter");
        System.out.println("5. lihat jadwal");
        System.out.println("0. Kembali");
        System.out.print("Pilih menu: ");
    }

    public void tambahPasien() {
        System.out.println("=== PASIEN BARU ===");
        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan alamat: ");
        String alamat = input.nextLine();
        System.out.print("Masukkan kelamin: ");
        String kelamin = input.nextLine();
        System.out.print("Masukkan TTL: ");
        String ttl = input.nextLine();
        System.out.print("Masukkan NIK: ");
        String nik = input.nextLine();
        System.out.print("Masukkan nomor BPJS (jika ada): ");
        String bpjs = input.nextLine();
        Pasien pasien = new Pasien(nama, alamat, kelamin, ttl, nik, bpjs);
        daftarPasien.add(pasien);
        System.out.println("Pasien berhasil ditambahkan.");
    }

    public void ambilAntrian() {
        System.out.println("=== AMBIL ANTRIAN ===");
        if (daftarPoli.size()>0){
            Pasien pasien = cariPasien();
            if (pasien != null) {
                tampilPoli();
                System.out.print("Pilih (nomor) poli yang dituju: ");
                int pilih = input.nextInt();
                input.nextLine();
                if (pilih > 0 && pilih <= daftarPoli.size()) {
                    Poli poli = daftarPoli.get(pilih - 1);
                    int nomor = daftarAntrian.size() + 1;
                    Antrian antrian = new Antrian(pasien, poli, nomor);
                    daftarAntrian.add(antrian);
                    poli.tambahAntrian(antrian);
                    System.out.println("Antrian berhasil diambil.");
                    System.out.println("Nomor antrian Anda: " + nomor);
                } else {
                    System.out.println("Pilihan poli tidak ada..ges");
                }
            } else {
                System.out.println("Pasien tidak ditemukan.");
            }
        }else {
            System.out.println("maaf gan poli blm di tambah admin");
        }

    }

    public Pasien cariPasien() {
        System.out.println("=== CARI PASIEN ===");
        System.out.print("Masukkan NIK atau nomor BPJS: ");
        String keyword = input.nextLine();
        for (Pasien pasien : daftarPasien) {
            if (pasien.getNIK().equals(keyword) || pasien.getNomorBPJS().equals(keyword)) {
                return pasien;
            }
        }
        return null;
    }

    public void tampilPoli() {
        System.out.println("=== DAFTAR POLI ===");
        for (int i = 0; i < daftarPoli.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPoli.get(i).getNamaPoli());
        }

    }

    public void lihatJadwalPraktekDokter() {
        System.out.println("=== LIHAT JADWAL PRAKTEK DOKTER ===");
        if (daftarPoli.size()>0){
            for (Poli poli : daftarPoli) {
                poli.tampilDataPoli();
                System.out.println("==============================");
            }
        }else {
            System.out.println("tidak ada data...belum ditambah admin");
        }
    }

    public void Jalan() {
        boolean exit = false;
        boolean login = false;
        while (!exit) {
            tampilMenuUtama();
            int pilih = input.nextInt();
            input.nextLine();
            switch (pilih) {
                case 1:
                    tambahPasien();
                    break;
                case 2:
                    ambilAntrian();
                    break;
                case 3:
                    lihatJadwalPraktekDokter();
                    break;
                case 4:
                    login = loginAdmin();
                    if (login) {
                        admin.setDaftarAntrian(daftarAntrian);
                        admin.setDaftarPoli(daftarPoli);
                        boolean kembali = false;
                        while (!kembali) {
                            tampilMenuAdmin();
                            int pilihAdmin = input.nextInt();
                            input.nextLine();
                            switch (pilihAdmin) {
                                case 1:
                                    admin.tambahPoli();
                                    break;
                                case 2:
                                    admin.cetakDetailTransaksi();
                                    break;
                                case 3:
                                    admin.tambahJadwalPraktekDokter();
                                    break;
                                case 4:
                                    admin.updateJadwalPraktekDokter();
                                    break;
                                case 5:
                                    lihatJadwalPraktekDokter();
                                    break;
                                case 0:
                                    kembali = true;
                                    break;
                                default:
                                    System.out.println("Pilihan menu admin tidak valid.");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Username atau password salah.");
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan menu utama tidak valid.");
                    break;
            }
        }
    }

    public boolean loginAdmin() {
        System.out.println("=== LOGIN ADMIN ===");
        System.out.print("Masukkan username: ");
        String username = input.nextLine();
        System.out.print("Masukkan password: ");
        String password = input.nextLine();
        return username.equals("admin") && password.equals("admin");
    }

    public static void main(String[] args) {
        Aplikasi aplikasi = new Aplikasi();
        aplikasi.Jalan();
    }
}
