import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class dskehoachtour {
    private kehoachtour[] ds;
    private int N;
    private Scanner sc = new Scanner(System.in);

    public dskehoachtour() {
        N = 0;
        ds = new kehoachtour[0];
    }

    public dskehoachtour(kehoachtour[] ds, int N) {
        this.ds = ds;
        this.N = N;
    }

    public dskehoachtour(dskehoachtour dskht) {
        this.ds = dskht.ds;
        this.N = dskht.N;
    }

    public kehoachtour[] getDs() {
        return ds;
    }

    public int getN() {
        return N;
    }

    public void setDs(kehoachtour[] ds) {
        this.ds = ds;
    }

    public void setN(int N) {
        this.N = N;
    }

    public void nhapDsKHT() {
        System.out.print("Nhap so luong ke hoach tour: ");
        N = Integer.parseInt(sc.nextLine());
        ds = new kehoachtour[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Nhap ke hoach tour thu " + (i + 1) + ": ");
            ds[i] = new kehoachtour();
            ds[i].nhap();
        }
        N = ds.length;
    }

    public void xuatDsKHT() {
        System.out.printf("%-10s %-10s %-12s %-12s %-8s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "MaKHT", "MaTour", "Ngay di", "Ngay ve", "Tong ve",
                "Ve con", "Tong chi", "An", "O", "Di lai", "MaHDV","Tong tien ve");
        for (int i = 0; i < N; i++) {
            ds[i].xuat();
        }
    }

    public int timTheoMa(String makhtour) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getMakhtour().equalsIgnoreCase(makhtour)) {
                return i;
            }
        }
        return -1;
    }

    public kehoachtour timKHT(String makhtour) {
        int vt = timTheoMa(makhtour);
        if (vt == -1) {
            return null;
        }
        return ds[vt];
    }

  

    public void themKHTCoTs(kehoachtour k) {
        if (timTheoMa(k.getMakhtour()) != -1) {
            System.out.println("Loi: Ma ke hoach tour '" + k.getMakhtour() + "' da ton tai. Khong the them.");
            return;
        }
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = new kehoachtour(k);
        N++;
        System.out.println(" Da them ke hoach tour (tham so) thanh cong!");
    }

    public void xoaKHTCoTs(String makhtour) {
        int idx = timTheoMa(makhtour);
        if (idx == -1) {
            System.out.println(" Khong tim thay ke hoach tour co ma: " + makhtour);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println(" Da xoa ke hoach tour co ma: " + makhtour);
    }
    
    public void thongketheosove(){
        System.out.println("Nhap vao so ve con lai can thong ke: ");
        int soveconlai = Integer.parseInt(sc.nextLine());
        System.out.println("=== THONG KE KE HOACH THEO SO VE CON LAI ===");
        System.out.printf("%-10s %-10s %-12s %-12s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "MaKHT", "MaTour", "Ngay di", "Ngay ve",
                "Ve con", "Tong chi", "An", "O", "Di lai", "MaHDV");
        for (int i = 0; i < N; i++) {
            if (ds[i].getSoveconlai() >= soveconlai) {
                ds[i].xuat();
            }
        }
    }

    public int  nhapsonguyen(String mess){
        while(true)
        {try{
            System.out.println(mess);
            String input=sc.nextLine();
            int num=Integer.parseInt(input);
            if(num<0){
                System.out.println("Loi nhap gia tri nho hon");
                continue;
            }
            return num;
        }catch(NumberFormatException e){
            System.out.println("Loi dinh dang so, vui long nhap lai.");
        }}
    }

    public LocalDate nhapngay(String mess){
        while(true){
            try{
                System.out.println(mess);
                String input=sc.nextLine();
                LocalDate ngay=LocalDate.parse(input,kehoachtour.df);
                return ngay;
            }catch(DateTimeParseException e){
                System.out.println("Loi dinh dang ngay, vui long nhap lai.");
            }
        }
    }
    
    public void suaKHT(String makhtour) {
        int idx = timTheoMa(makhtour);
        if (idx == -1) {
            System.out.println(" Khong tim thay ke hoach tour co ma: " + makhtour);
            return;
        }

        kehoachtour k = ds[idx];
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN KE HOACH TOUR =====");
            System.out.println("1. Sua ma tour");
            System.out.println("2. Sua ngay di / ngay ve");
            System.out.println("3. Sua Tong so ve");
            System.out.println("4. Sua tong chi / an / o / di lai / tien ve");
            System.out.println("0. Thoat");
            chon = nhapsonguyen("Nhap lua chon");

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma tour moi: ");
                    k.setMatour(sc.nextLine());
                    break;
                case 2:
                    k.setNgaydi(nhapngay("Nhap ngay di:"));
                    while(true)
                    {
                        LocalDate n=nhapngay("Nhap ngay ve");
                        if(n.isBefore(k.getNgaydi())){
                            System.out.println("Loi nhap ngay ve truoc ngay di, vui long nhap lai.");
                            continue;
                        }
                        k.setNgayve(n);
                        break;
                    }
                    break;
                case 3:
                    k.setTongsove(nhapsonguyen("Nhap tong so ve moi: "));
                    break;
                case 4:
                    k.setTongchi(nhapsonguyen("Nhap tong chi moi: "));
                    k.setTongan(nhapsonguyen("Nhap tong an moi: "));
                    k.setTongo(nhapsonguyen("Nhap tong o moi: "));
                    k.setTongdilai(nhapsonguyen("Nhap tong di lai moi: "));
                    k.setTongtienve(nhapsonguyen("Nhap tong tien ve moi: "));
                    break;
                case 0:
                    System.out.println(" Thoat sua thong tin.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = k;
        System.out.println(" Da cap nhat thong tin ke hoach tour co ma: " + makhtour);
    }
    
    
    public void suaKHT() {
        System.out.print("Nhap ma ke hoach tour can sua: ");
        String makhtour = sc.nextLine();
        int idx = timTheoMa(makhtour);
        if (idx == -1) {
            System.out.println(" Khong tim thay ke hoach tour co ma: " + makhtour);
            return;
        }

        kehoachtour k = ds[idx];
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN KE HOACH TOUR =====");
            System.out.println("1. Sua ma tour");
            System.out.println("2. Sua ngay di / ngay ve");
            System.out.println("3. Sua ve con");
            System.out.println("4. Sua tong chi / an / o / di lai / tien ve");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma tour moi: ");
                    k.setMatour(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap ngay di moi: ");
                    k.setNgaydi(LocalDate.parse(sc.nextLine()));
                    System.out.print("Nhap ngay ve moi: ");
                    k.setNgayve(LocalDate.parse(sc.nextLine()));
                    break;
                case 3:
                    System.out.print("Nhap so ve con lai moi: ");
                    k.setSoveconlai(Integer.parseInt(sc.nextLine()));
                    break;
                case 4:
                    System.out.print("Nhap tong chi moi: ");
                    k.setTongchi(Integer.parseInt(sc.nextLine()));
                    System.out.print("Nhap tong an moi: ");
                    k.setTongan(Integer.parseInt(sc.nextLine()));
                    System.out.print("Nhap tong o moi: ");
                    k.setTongo(Integer.parseInt(sc.nextLine()));
                    System.out.print("Nhap tong di lai moi: ");
                    k.setTongdilai(Integer.parseInt(sc.nextLine()));
                    System.out.print("Nhap tong tien ve moi: ");
                    k.setTongtienve(Integer.parseInt(sc.nextLine()));
                    break;
                case 0:
                    System.out.println(" Thoat sua thong tin.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = k;
        System.out.println(" Da cap nhat thong tin ke hoach tour co ma: " + makhtour);
    }
    public void docFile(String file){
        try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        int n=0;
        ds= new kehoachtour[100];
        
        String line;
        while((line = br.readLine())!=null){
            String[] part=line.split("\\|");

            if(part.length>=12){
                String ma=part[0];
                String mat=part[1];
                LocalDate ngaydi=LocalDate.parse(part[2],kehoachtour.df);
                LocalDate ngayve=LocalDate.parse(part[3],kehoachtour.df);
                int tongsove=Integer.parseInt(part[4]);
                int soveconlai= Integer.parseInt(part[5]);
                int tongchi=Integer.parseInt(part[6]);
                int tongan=Integer.parseInt(part[7]);
                int tongo=Integer.parseInt(part[8]);
                int tongdilai=Integer.parseInt(part[9]);
                int tongtienve=Integer.parseInt(part[10]);
                String mahdv=part[11];
                ds[n++]=new kehoachtour( ma, mat, ngaydi, ngayve, tongsove,soveconlai, tongchi, tongan, tongo, tongdilai, tongtienve, mahdv);
            }
        }
        br.close();
            N=n;
            ds=Arrays.copyOf(ds,N);
        System.out.println("Da doc "+N+" ke hoach tour tu file "+file);
        } catch(Exception e){
            System.out.println("Loi khong doc duoc file"+e.getMessage());
            e.printStackTrace();
        }
    }
    public void ghiFile(String file){
        try {
            BufferedWriter bw =new BufferedWriter(new FileWriter(file));
            for(int i=0;i<N;i++){
                kehoachtour k=ds[i];
                String line="";
                
                line=String.join("|",
                k.getMakhtour(),
                k.getMatour(),
                String.valueOf(k.getNgaydi().format(kehoachtour.df)),
                String.valueOf(k.getNgayve().format(kehoachtour.df)),
                String.valueOf(k.getTongsove()),
                String.valueOf(k.getSoveconlai()),
                String.valueOf(k.getTongchi()),
                String.valueOf(k.getTongan()),
                String.valueOf(k.getTongo()),
                String.valueOf(k.getTongdilai()),
                String.valueOf(k.getTongtienve()),
                k.getMahdv());
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Da cap nhat vao file "+file);
        } catch(Exception e){
            System.out.println("Loi ghi fiel "+e.getMessage());
            e.printStackTrace();
        }
    }

    public void capnhatsove(String maKHTour, dshoadon DSHD) {

        int index = this.timTheoMa(maKHTour);
        if (index == -1) {
            System.out.println("Loi cap nhat ve: Khong tim thay ke hoach tour " + maKHTour);
            return;
        }
        kehoachtour kht = this.ds[index];

        int tongVeBan = 0;
        for (int j = 0; j < DSHD.getN(); j++) {
            hoadon hd = DSHD.getDs()[j];
            if (hd.getMakhtour().equalsIgnoreCase(maKHTour)) {
                tongVeBan += hd.getSove();
            }
        }

        int soveconlai = kht.getTongsove() - tongVeBan;
        if (soveconlai < 0) {
             System.out.println(" Lỗi : Tổng vé bán (" + tongVeBan +
                           ") vượt quá số vé có (" + kht.getTongsove() + ").");
        System.out.println(" Tự động điều chỉnh số vé còn lại về 0.");
            soveconlai = 0;
        } 
        kht.setSoveconlai(soveconlai);

        this.ds[index] = kht;
        System.out.println("Da cap nhat so ve cho KHT: " + maKHTour + ". Con lai: " + soveconlai);
    }

    public void thongKeDoanhThuTheoQuy(dshoadon dshd) {
    System.out.println("\n       === THONG KE DOANH THU THEO QUY ===     ");
    int[] doanhThuQuy = new int[4];
    int[] chiPhiQuy = new int[4];
    int[] loiNhuan = new int[4];

    if (dshd == null || dshd.getDs() == null) {
        System.out.println("Khong co du lieu hoa don de thong ke.");
        return;
    }

    for (int i = 0; i < dshd.getN(); i++) {
        hoadon h = dshd.getDs()[i];
        if (h == null) continue;

        int thang = h.getNgaylap().getMonthValue();
        int quy = (thang - 1) / 3;

        doanhThuQuy[quy] += h.getTongtien();

        if (i < N && ds[i] != null) {
            chiPhiQuy[quy] += ds[i].getTongchi()
                            + ds[i].getTongan()
                            + ds[i].getTongo()
                            + ds[i].getTongdilai();
        }

        loiNhuan[quy] = doanhThuQuy[quy] - chiPhiQuy[quy];
    }

    System.out.printf("%-10s %-15s %-15s %-15s\n", "Quy", "Doanh thu", "Tong chi phi", "Loi nhuan");
    for (int i = 0; i < 4; i++) {
        System.out.printf("%-10d %-15d %-15d %-15d\n", (i + 1), doanhThuQuy[i], chiPhiQuy[i], loiNhuan[i]);
    }
}

 
//bỏ 2 cái thống kê theo tháng vs quý cũ vì xuất xấu
   public void thongKeDoanhThuTheoThang(dshoadon dshd) {
    System.out.println("\n      === THONG KE DOANH THU THEO THANG ===       ");

    int[] doanhThuThang = new int[12];
    int[] chiPhiThang = new int[12];
    int[] loiNhuanThang = new int[12];

    if (dshd == null || dshd.getDs() == null) {
        System.out.println("Khong co du lieu hoa don de thong ke.");
        return;
    }

    for (int i = 0; i < dshd.getN(); i++) {
        hoadon h = dshd.getDs()[i];
        if (h == null) continue;

        int thang = h.getNgaylap().getMonthValue(); 
        if (thang < 1 || thang > 12) continue;      

        doanhThuThang[thang - 1] += h.getTongtien(); 

        
        if (i < N && ds[i] != null) {
            chiPhiThang[thang - 1] += ds[i].getTongchi()+ ds[i].getTongan()+ ds[i].getTongo()+ ds[i].getTongdilai();
        }

        loiNhuanThang[thang - 1] = doanhThuThang[thang - 1] - chiPhiThang[thang - 1];
    }

    
    System.out.printf("%-10s %-15s %-15s %-15s\n", "Thang", "Doanh thu", "Tong chi phi", "Loi nhuan");
    for (int i = 0; i < 12; i++) {
        System.out.printf("%-10d %-15d %-15d %-15d\n", 
                          (i + 1), doanhThuThang[i], chiPhiThang[i], loiNhuanThang[i]);
    }
}
}