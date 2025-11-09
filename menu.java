import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
public class menu {
    private static Scanner sc = new Scanner(System.in);
    private static dsHDV dshdv = new dsHDV();
    private static dskhachhang dskh = new dskhachhang();
    private static dstour dst = new dstour();
    private static dskehoachtour dskht = new dskehoachtour();
    private static dsctkhtour dsctkht = new dsctkhtour();
    private static dshopdong dshd = new dshopdong();
    private static dshoadon dshoadon = new dshoadon();
    private static dscthoadon dsct = new dscthoadon();
    private static dsdanhgiatour dsdgt = new dsdanhgiatour();
    private static dsnhahang dsnh = new dsnhahang();

    public static void start() {
        loadfile();
        int chon = -1;

        while (chon != 0) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║  CHUONG TRINH QUAN LY TOUR DU LICH     ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("Chon cac chuc nang quan ly duoi day");
            System.out.println("1. Quan ly huong dan vien");
            System.out.println("2. Quan ly khach hang");
            System.out.println("3. Quan ly tour (Tour, Ke hoach, Hop dong)");
            System.out.println("4. Quan ly hoa don (va cap nhat ve)");
            System.out.println("5. Quan ly nha hang");
            System.out.println("6. Quan ly danh gia tour");
            System.out.println("7. Thong ke doanh thu");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Nhap lua chon cua ban: ");
            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1: {
                        quanLyHDV();
                        break;
                    }
                    case 2: {
                        quanLyKhachHang();
                        break;
                    }
                    case 3: {
                        quanLyTour();
                        break;
                    }
                    case 4: {
                        quanLyHoaDon();
                        break;
                    }
                    case 5: {
                        quanLyNhaHang();
                        break;
                    }
                    case 6: {
                        quanLyDanhGiaTour();
                        break;
                    }
                    case 7: {
                        thongKeDoanhThu();
                        break;
                    }
                    case 0:
                        System.out.println("╔════════════════════════════════════════╗");
                        System.out.println("║  Cam on ban da su dung chuong trinh!   ║");
                        System.out.println("╚════════════════════════════════════════╝");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
            }
        }
        sc.close();
    }

    public static void loadfile() {
        dshdv.docFile("dshdv.txt");
        dskh.docFile("dskhachhang.txt");
        dst.docFile("dstour.txt");
        dskht.docFile("dskehoachtour.txt");
        dsctkht.docFile("dsctkhtour.txt");
        dshoadon.docFile("dshoadon.txt");
        dshd.docFile("dshopdong.txt");
        dsct.docFile("dscthoadon.txt");
        dsdgt.docFile("dsdanhgiatour.txt");
        dsnh.docFile("dsnhahang.txt");
    }

    public static void quanLyHDV() {
        int chon;
        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║      QUAN LY HUONG DAN VIEN            ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Nhap danh sach HDV");
            System.out.println("2. Xuat danh sach HDV");
            System.out.println("3. Tim kiem HDV theo ma");
            System.out.println("4. Tim kiem HDV theo ten");
            System.out.println("5. Them HDV moi");
            System.out.println("6. Xoa HDV");
            System.out.println("7. Sua thong tin HDV");
            System.out.println("8. Thong ke theo ma tour");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dshdv.nhapDshdv();
                        dshdv.ghiFile("dshdv.txt");
                        break;
                    case 2:
                        dshdv.xuatDshdv();
                        break;
                    case 3:
                        System.out.print("Nhap ma HDV can tim: ");
                        String maHDV = sc.nextLine();
                        hdv hdv = dshdv.timHDV(maHDV);
                        if (hdv != null) {
                            System.out.println("Tim thay HDV:");
                            System.out.printf("%-10s %-10s %-10s %-10s %-15s %-10s %-15s %-20s%n",
                                    "MaHDV", "MaTour", "Ho", "Ten", "NgaySinh", "GioiTinh", "SoDT", "DiaChi");
                            hdv.xuat();
                        } else {
                            System.out.println("Khong tim thay HDV co ma " + maHDV);
                        }
                        break;
                    case 4:
                        System.out.print("Nhap ten HDV can tim: ");
                        String tenHDV = sc.nextLine();
                        dshdv.timTheoTen(tenHDV);
                        break;
                    case 5:
                        hdv hdvMoi = new hdv();
                        hdvMoi.nhap();
                        dshdv.themHDVCoTs(hdvMoi);
                        dshdv.ghiFile("dshdv.txt");
                        break;
                    case 6:
                        System.out.print("Nhap ma HDV can xoa: ");
                        dshdv.xoaHDVCoTs(sc.nextLine());
                        dshdv.ghiFile("dshdv.txt");
                        break;
                    case 7:
                        dshdv.suaHDV();
                        dshdv.ghiFile("dshdv.txt");
                        break;
                    case 8:
                        dshdv.thongKeTheoMaTour();
                        break;
                    case 0:
                        System.out.println("Quay lai menu chinh...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyKhachHang() {
        int chon;
        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║         QUAN LY KHACH HANG             ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Nhap danh sach khach hang");
            System.out.println("2. Xuat danh sach khach hang");
            System.out.println("3. Tim kiem khach hang theo ma");
            System.out.println("4. Tim kiem khach hang theo ten");
            System.out.println("5. Them khach hang");
            System.out.println("6. Xoa khach hang");
            System.out.println("7. Sua thong tin khach hang");
            System.out.println("8. Thong ke theo ma khach hang");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dskh.nhapds();
                        dskh.ghiFile("dskhachhang.txt");
                        break;
                    case 2:
                        dskh.xuatds();
                        break;
                    case 3:
                        System.out.print("Nhap ma khach hang can tim: ");
                        String makh = sc.nextLine();
                        khachhang kh = dskh.timKhachHang(makh);
                        if (kh != null) {
                            System.out.println("Tim thay khach hang:");
                            System.out.printf("%-10s %-10s %-10s %-15s %-10s %-15s %-20s\n",
                                    "MaKH", "Ho", "Ten", "NgaySinh", "GioiTinh", "SDT", "DiaChi");
                            kh.xuat();
                        } else {
                            System.out.println("Khong tim thay khach hang co ma: " + makh);
                        }
                        break;
                    case 4:
                        System.out.print("Nhap ten khach hang can tim: ");
                        String ten = sc.nextLine();
                        dskh.timKhachTheoTen(ten);
                        break;
                    case 5:
                        khachhang khMoi = new khachhang();
                        khMoi.nhap();
                        dskh.themKhachHang(khMoi);
                        dskh.ghiFile("dskhachhang.txt");
                        break;
                    case 6:
                        System.out.print("Nhap ma khach hang can xoa: ");
                        dskh.xoaKhachHang(sc.nextLine());
                        dskh.ghiFile("dskhachhang.txt");
                        break;
                    case 7:
                        System.out.println("Nhap ma khach hang can sua: ");
                        String mkh = sc.nextLine();
                        dskh.suaKhachHang(mkh);
                        dskh.ghiFile("dskhachhang.txt");
                        break;
                    case 8:
                        dskh.thongKeMaKH();
                        break;
                    case 0:
                        System.out.println("Quay lai menu chinh...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyTour() {
        int chon;
        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║       QUAN LY TOUR DU LICH             ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Quan ly danh sach tour");
            System.out.println("2. Quan ly ke hoach tour");
            System.out.println("3. Quan ly chi tiet ke hoach tour");
            System.out.println("4. Quan ly hop dong");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        quanLyDanhSachTour();
                        break;
                    case 2:
                        quanLyKeHoachTour();
                        break;
                    case 3:
                        quanLyChiTietKeHoachTour();
                        break;
                    case 4:
                        quanLyHopDong();
                        break;
                    case 0:
                        System.out.println("Quay lai menu chinh...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyDanhSachTour() {
        int chon;
        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║      QUAN LY DANH SACH TOUR            ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Xuat danh sach tour (Trong nuoc & Nuoc ngoai)");
            System.out.println("2. Them tour moi");
            System.out.println("3. Sua tour");
            System.out.println("4. Xoa tour");
            System.out.println("5. Tim tour theo ma");
            System.out.println("6. Tim tour theo ten");
            System.out.println("7. Thong ke theo loai tour");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dst.xuatDstour();
                        break;
                    case 2:
                        System.out.println("Chon loai tour: 1 - Trong nuoc, 2 - Nuoc ngoai");
                        int loai = Integer.parseInt(sc.nextLine());
                        tour t;
                        if (loai == 1) {
                            t = new tourtrongnuoc();
                        } else {
                            t = new tournuocngoai();
                        }
                        t.nhap();
                        dst.themTourCoTs(t);
                        dst.ghiFile("dstour.txt");
                        break;
                    case 3:
                        System.out.print("Nhap ma tour can sua: ");
                        String maSua = sc.nextLine();
                        dst.suaTour(maSua);
                        dst.ghiFile("dstour.txt");
                        break;
                    case 4:
                        System.out.print("Nhap ma tour can xoa: ");
                        String maXoa = sc.nextLine();
                        dst.xoaTourCoTs(maXoa);
                        dst.ghiFile("dstour.txt");
                        break;
                    case 5:
                        System.out.print("Nhap ma tour can tim: ");
                        dst.timTheoMaTour(sc.nextLine());
                        break;
                    case 6:
                        System.out.print("Nhap ten tour can tim: ");
                        dst.timTheoTenTour(sc.nextLine());
                        break;
                    case 7:
                        dst.thongKeTheoLoaiTour();
                        break;
                    case 0:
                        System.out.println("Quay lai...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyKeHoachTour() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY KE HOACH TOUR =====");
            System.out.println("1. Nhap ke hoach tour");
            System.out.println("2. Xuat ke hoach tour");
            System.out.println("3. Tim kiem ke hoach tour");
            System.out.println("4. Them ke hoach tour");
            System.out.println("5. Xoa ke hoach tour");
            System.out.println("6. Sua ke hoach tour");
            System.out.println("7. Thong ke theo so ve con lai");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dskht.nhapDsKHT();
                        dskht.ghiFile("dskehoachtour.txt");
                        break;
                    case 2:
                        dskht.xuatDsKHT();
                        break;
                    case 3:
                        System.out.print("Nhap ma ke hoach tour can tim: ");
                        kehoachtour kht = dskht.timKHT(sc.nextLine());
                        if (kht != null) {
                            System.out.println("Tim thay ke hoach tour:");
                            System.out.printf("%-15s %-10s %-12s %-12s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                                    "MaKHT", "MaTour", "Ngay Di", "Ngay Ve", "Tong Ve",
                                    "Ve Con", "Tong Chi", "An", "O", "Di Lai", "MaHDV", "Tien Ve");
                            kht.xuat();
                        } else {
                            System.out.println("Khong tim thay ke hoach tour");
                        }
                        break;
                    case 4:
                        kehoachtour kht1 = new kehoachtour();
                        kht1.nhap();
                        dskht.themKHTCoTs(kht1);
                        dskht.ghiFile("dskehoachtour.txt");
                        break;
                    case 5:
                        System.out.print("Nhap ma ke hoach tour can xoa: ");
                        dskht.xoaKHTCoTs(sc.nextLine());
                        dskht.ghiFile("dskehoachtour.txt");
                        break;
                    case 6:
                        System.out.println("Nhap ma kht can sua: ");
                        String mkht = sc.nextLine();
                        dskht.suaKHT(mkht);
                        dskht.capnhatsove(mkht, dshoadon);
                        dskht.ghiFile("dskehoachtour.txt");
                        break;
                    case 7:
                        dskht.thongketheosove();
                        break;
                    case 0:
                        System.out.println("Quay lai...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyChiTietKeHoachTour() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY CHI TIET KE HOACH TOUR =====");
            System.out.println("1. Nhap chi tiet ke hoach tour");
            System.out.println("2. Xuat chi tiet ke hoach tour");
            System.out.println("3. Tim kiem theo ma chi tiet");
            System.out.println("5. Them chi tiet ke hoach tour");
            System.out.println("6. Xoa chi tiet ke hoach tour");
            System.out.println("7. Sua chi tiet ke hoach tour");
            System.out.println("8. Thong ke theo ma KHT");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dsctkht.nhapds();
                        dsctkht.ghiFile("dsctkhtour.txt");
                        break;
                    case 2:
                        dsctkht.xuatds();
                        break;
                    case 3:
                        System.out.print("Nhap ma CT ke hoach tour can tim: ");
                        ctkhtour ct = dsctkht.timCots(sc.nextLine());
                        if (ct != null) {
                            System.out.println("Tim thay chi tiet ke hoach tour:");
                            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n", "Ma ctkh tour", "Ma KH Tour",
                                    "Ngay Chi", "Tien An", "Tien O", "Tien Di Lai");
                            ct.xuat();
                        } else {
                            System.out.println("Khong tim thay chi tiet ke hoach tour");
                        }
                        break;
                    case 4:
                        DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate ngaychi=null;
                        while (true) {
                            try{System.out.println("Nhap ngay can tim : ");
                            String input=sc.nextLine();
                            ngaychi=LocalDate.parse(input,df);
                            break;
                            }
                            catch(DateTimeParseException e){
                                System.out.println("Nhap ngay sai dinh dang vui long nhap lai: ");
                            }
                        }
                        dsctkht.timTheoNgayChi(ngaychi);;
                        break;
                    case 5:
                        ctkhtour ctMoi = new ctkhtour();
                        ctMoi.nhap();
                        dsctkht.themCots(ctMoi);
                        dsctkht.ghiFile("dsctkhtour.txt");
                        break;
                    case 6:
                        System.out.print("Nhap ma CT ke hoach tour can xoa: ");
                        dsctkht.xoaCots(sc.nextLine());
                        dsctkht.ghiFile("dsctkhtour.txt");
                        break;
                    case 7:
                        System.out.println("Nhap ma chi tiet ke hoach tour can sua");
                        String makht = sc.nextLine();
                        dsctkht.suaKhtour(makht);
                        dsctkht.ghiFile("dsctkhtour.txt");
                        break;
                    case 8:
                        dsctkht.thongKeTheoMa();
                        break;
                    case 0:
                        System.out.println("Quay lai...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyHopDong() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY HOP DONG =====");
            System.out.println("1. Nhap danh sach hop dong");
            System.out.println("2. Xuat danh sach hop dong");
            System.out.println("3. Tim kiem hop dong theo ma");
            System.out.println("4. Tim kiem hop dong theo ma tour");
            System.out.println("5. Them hop dong");
            System.out.println("6. Xoa hop dong");
            System.out.println("7. Sua hop dong");
            System.out.println("8. Thong ke theo ma tour");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dshd.nhapDshopdong();
                        dshd.ghiFile("dshopdong.txt");
                        break;
                    case 2:
                        dshd.xuatDshopdong();
                        break;
                    case 3:
                        System.out.print("Nhap ma hop dong can tim: ");
                        hopdong hd = dshd.timHopDong(sc.nextLine());
                        if (hd != null) {
                            System.out.println("Tim thay hop dong:");
                            System.out.printf("%-15s %-15s %-15s %-15s\n", "Ma HD", "Ma tour", "Ma KH", "Dieu khoan");
                            hd.xuat();
                        } else {
                            System.out.println("Khong tim thay hop dong");
                        }
                        break;
                    case 4:
                        System.out.print("Nhap ma tour can tim: ");
                        dshd.timTheoMaTour(sc.nextLine());
                        break;
                    case 5:
                        hopdong hdMoi = new hopdong();
                        hdMoi.nhap();
                        dshd.themHopDongCots(hdMoi);
                        dshd.ghiFile("dshopdong.txt");
                        break;
                    case 6:
                        System.out.print("Nhap ma hop dong can xoa: ");
                        dshd.xoaHopDongCots(sc.nextLine());
                        dshd.ghiFile("dshopdong.txt");
                        break;
                    case 7:
                        System.out.println("Nhap vao na hop dong can sua: ");
                        String mahd = sc.nextLine();
                        dshd.suaHopDong(mahd);
                        dshd.ghiFile("dshopdong.txt");
                        break;
                    case 8:
                        dshd.thongKeTheoMaTour();
                        break;
                    case 0:
                        System.out.println("Quay lai...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyHoaDon() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY HOA DON =====");
            System.out.println("1. Nhap danh sach hoa don ");
            System.out.println("2. Xuat danh sach hoa don");
            System.out.println("3. Tim kiem hoa don theo ma");
            System.out.println("4. Tim kiem hoa don theo ma khach hang");
            System.out.println("5. Them hoa don ");
            System.out.println("6. Xoa hoa don ");
            System.out.println("7. Sua hoa don ");
            System.out.println("8. Thong ke theo ma khach hang");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dshoadon.nhapDsHD();
                        System.out.println("Canh bao: So ve chua duoc cap nhat.");
                        break;
                    case 2:
                        dshoadon.xuatDsHD();
                        break;
                    case 3:
                        System.out.print("Nhap ma hoa don can tim: ");
                        hoadon hd = dshoadon.timHD(sc.nextLine());
                        if (hd != null) {
                            System.out.println("Tim thay hoa don:");
                            System.out.printf("%-10s %-10s %-10s %-12s %-10d %-15d\n",
                                    "MaHD", "MaKH", "MaKHTour", "NgayLap", "SoVe", "TongTien");
                            hd.xuat();
                        } else {
                            System.out.println("Khong tim thay hoa don");
                        }
                        break;
                    case 4:
                        System.out.print("Nhap ma khach hang can tim: ");
                        dshoadon.timTheoMaKH(sc.nextLine());
                        break;
                    case 5:
                        hoadon hd1 = new hoadon();
                        hd1.nhap();
                        if (dshoadon.timHD(hd1.getMahd()) != null) {
                            System.out.println(" Ma hoa don da ton tai, khong the them!");
                            break;
                        }
                        dshoadon.themHDCoTs(hd1,dskht);
                        dskht.capnhatsove(hd1.getMakhtour(), dshoadon);
                        dshoadon.ghiFile("dshoadon.txt");
                        dskht.ghiFile("dskehoachtour.txt");
                        break;
                    case 6:
                        System.out.print("Nhap ma hoa don can xoa: ");
                        String mahoadon = sc.nextLine();
                        hoadon hd2 = dshoadon.timHD(mahoadon);
                        if (hd2 == null) {
                            System.out.println("Loi: Khong tim thay hoa don.");
                            break;
                        }
                        String maKHT = hd2.getMakhtour();
                        dshoadon.xoaHDCoTs(mahoadon);
                        dskht.capnhatsove(maKHT, dshoadon);
                        dskht.ghiFile("dskehoachtour.txt");
                        dshoadon.ghiFile("dshoadon.txt");
                        break;
                    case 7:
                        System.out.print("Nhap ma hoa don can sua: ");
                        String mhd = sc.nextLine();
                        hoadon hd3 = dshoadon.timHD(mhd);
                        if (hd3 == null) {
                            System.out.println("Loi: Khong tim thay hoa don.");
                            break;
                        }
                        String maKHT_Sua = hd3.getMakhtour();
                        dshoadon.suaHD(mhd, dskht);
                        dskht.capnhatsove(maKHT_Sua, dshoadon);
                        dshoadon.ghiFile("dshoadon.txt");
                        dskht.ghiFile("dskehoachtour.txt");
                        break;
                    case 8:
                        dshoadon.thongKeTheoMaKH();
                        break;
                    case 0:
                        System.out.println("Quay lai...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyNhaHang() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY NHA HANG =====");
            System.out.println("1. Xuat danh sach nha hang");
            System.out.println("2. Them nha hang");
            System.out.println("3. Sua nha hang");
            System.out.println("4. Xoa nha hang");
            System.out.println("5. Tim nha hang theo ma");
            System.out.println("6. Tim nha hang theo Ma KHTour");
            System.out.println("7. Thong ke nha hang theo Ma KHTour");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon: ");
            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dsnh.xuatDsNH();
                        break;
                    case 2:
                        dsnh.themNHKhongTs();
                        dsnh.ghiFile("dsnhahang.txt");
                        break;
                    case 3:
                        dsnh.suaNH();
                        dsnh.ghiFile("dsnhahang.txt");
                        break;
                    case 4:
                        dsnh.xoaNHKhongTs();
                        dsnh.ghiFile("dsnhahang.txt");
                        break;
                    case 5:
                        System.out.print("Nhap ma nha hang can tim: ");
                        nhahang n = dsnh.timNH(sc.nextLine());
                        if (n != null)
                            n.xuat();
                        else
                            System.out.println("Khong tim thay.");
                        break;
                    case 6:
                        System.out.print("Nhap ma KHTour: ");
                        dsnh.timTheoMaKHTour(sc.nextLine());
                        break;
                    case 7:
                        dsnh.thongKeTheoMaKHTour();
                        break;
                    case 0:
                        System.out.println("Quay lai...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void quanLyDanhGiaTour() {
        int chon;
        do {
            System.out.println("\n===== QUAN LY DANH GIA TOUR =====");
            System.out.println("1. Xuat danh sach danh gia");
            System.out.println("2. Them danh gia");
            System.out.println("3. Sua danh gia");
            System.out.println("4. Xoa danh gia");
            System.out.println("5. Tim danh gia theo Ma KHTour");
            System.out.println("6. Thong ke sao trung binh theo Ma KHTour");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon: ");
            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dsdgt.xuatDsDG();
                        break;
                    case 2:
                        danhgiatour dg = new danhgiatour();
                        dg.nhap();
                        dsdgt.themDGCoTs(dg);
                        dsdgt.ghiFile("dsdanhgiatour.txt");
                        break;
                    case 3:
                        dsdgt.suaDG();
                        dsdgt.ghiFile("dsdanhgiatour.txt");
                        break;
                    case 4:
                        System.out.print("Nhap ma danh gia can xoa: ");
                        dsdgt.xoaDGCoTs(sc.nextLine());
                        dsdgt.ghiFile("dsdanhgiatour.txt");
                        break;
                    case 5:
                        System.out.print("Nhap ma KHTour: ");
                        dsdgt.timTheoMaKHTour(sc.nextLine());
                        break;
                    case 6:
                        dsdgt.thongKeTheoMaKHTour();
                        break;
                    case 0:
                        System.out.println("Quay lai...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

    public static void thongKeDoanhThu() {
        int chon;
        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║        THONG KE                        ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.println("1. Thong ke doanh thu theo thang");
            System.out.println("2. Thong ke doanh thu theo quy");
            System.out.println("3. Thong ke ti le hoa don nam 2025");
            System.out.println("0. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1:
                        dskht.thongKeDoanhThuTheoThang(dshoadon);
                        break;
                    case 2:
                        dskht.thongKeDoanhThuTheoQuy(dshoadon);
                        break;
                    case 3:

                        dskhachhang dsKH = new dskhachhang();
                        dsKH.thongketisuathoadon2025(dshoadon);

                        break;
                    case 0:
                        System.out.println("Quay lai...");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                chon = -1;
            }
        } while (chon != 0);
    }

}