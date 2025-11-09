import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.time.format.DateTimeParseException;
class kehoachtour {
    private String makhtour;
    private String matour;
    private LocalDate ngaydi;
    private LocalDate ngayve;
    private int tongsove;
    public  int soveconlai;
    private int tongchi;
    private int tongan;
    private int tongo;
    private int tongdilai;
    private String mahdv;
    private int tongtienve;
    private tour t;
    public static final DateTimeFormatter df =DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Scanner sc = new Scanner(System.in);


    public int getTongTienTheoCacKhoan() {
        return tongchi + tongan + tongo + tongdilai + tongtienve;
    }

    public int getTongTienTheoNgay() {
        return tongchi + tongan + tongo + tongdilai;
    }

    public long getSoNgay() {
        return ChronoUnit.DAYS.between(ngaydi, ngayve) + 1;
    }

    public kehoachtour() {
    }

    public kehoachtour( String makhtour, LocalDate ngaydi, LocalDate ngayve, int tongsove,
            int soveconlai, int tongchi, int tongan, int tongo, int tongdilai, int tongtienve, String mahdv) {
        this.makhtour = makhtour;
        this.matour = t.getMatour();
        this.ngaydi = ngaydi;
        this.ngayve = ngayve;
        this.tongsove = tongsove;
        this.soveconlai = soveconlai;
        this.tongchi = tongchi;
        this.tongan = tongan;
        this.tongo = tongo;
        this.tongdilai = tongdilai;
        this.tongtienve = tongtienve;
        this.mahdv = mahdv;
    }

    public kehoachtour( String makhtour,String matour, LocalDate ngaydi, LocalDate ngayve, int tongsove,
            int soveconlai, int tongchi, int tongan, int tongo, int tongdilai, int tongtienve,String mahdv) {
        this.makhtour = makhtour;
        this.matour = matour;
        this.ngaydi = ngaydi;
        this.ngayve = ngayve;
        this.tongsove = tongsove;
        this.soveconlai = soveconlai;
        this.tongchi = tongchi;
        this.tongan = tongan;
        this.tongo = tongo;
        this.tongdilai = tongdilai;
        this.tongtienve = tongtienve;
        this.mahdv = mahdv;  
    }
    public kehoachtour(kehoachtour kht) {
        this.makhtour = kht.makhtour;
        this.matour = kht.matour;
        this.ngaydi = kht.ngaydi;
        this.ngayve = kht.ngayve;
        this.tongsove = kht.tongsove;
        this.soveconlai = kht.soveconlai;
        this.tongchi = kht.tongchi;
        this.tongan = kht.tongan;
        this.tongo = kht.tongo;
        this.tongdilai = kht.tongdilai;
        this.tongtienve = kht.tongtienve;
        this.mahdv = kht.mahdv;
        
    }

    public int tinhTongChiPhi() {
        return tongan + tongo + tongdilai + tongchi + tongtienve;
    }

    public String getMakhtour() {
        return makhtour;
    }

    public String getMatour() {
        return matour;
    }

    public LocalDate getNgaydi() {
        return ngaydi;
    }

    public LocalDate getNgayve() {
        return ngayve;
    }

    public int getTongsove() {
        return tongsove;
    }

    public int getSoveconlai() {
        return soveconlai;
    }

    public int getTongchi() {
        return tongchi;
    }

    public int getTongan() {
        return tongan;
    }

    public int getTongo() {
        return tongo;
    }

    public int getTongdilai() {
        return tongdilai;
    }

    public String getMahdv() {
        return mahdv;
    }

    public int getTongtienve() {
        return tongtienve;
    }

    public void setMakhtour(String makhtour) {
        this.makhtour = makhtour;
    }

    public void setMatour(String matour) {
        this.matour = matour;
    }

    public void setNgaydi(LocalDate ngaydi) {
        this.ngaydi = ngaydi;
    }

    public void setNgayve(LocalDate ngayve) {
        this.ngayve = ngayve;
    }

    public void setTongsove(int tongsove) {
        this.tongsove = tongsove;
    }

    public void setSoveconlai(int soveconlai) {
        this.soveconlai = soveconlai;
    }

    public void setTongchi(int tongchi) {
        this.tongchi = tongchi;
    }

    public void setTongan(int tongan) {
        this.tongan = tongan;
    }

    public void setTongo(int tongo) {
        this.tongo = tongo;
    }

    public void setTongdilai(int tongdilai) {
        this.tongdilai = tongdilai;
    }

    public void setMahdv(String mahdv) {
        this.mahdv = mahdv;
    }

    public void setTongtienve(int tongtienve) {
        this.tongtienve = tongtienve;
    }

    
    public void nhap() {
        String mt="^KHT[0-9]{3}$";
        while(true){
            System.out.println("Nhap ma ke hoach tour (co dinh dang KHTXXX, VD: KHT001)");
            makhtour=sc.nextLine();
            if(makhtour.matches(mt)){break;}
            System.out.println("Loi dinh dang, vui long nhap lai.");
        }
        String t="^T[0-9]{3}$";
        while(true){
            System.out.println("Nhap ma tour (co dinh dang TXXX, VD: T001)");
            matour=sc.nextLine();
            if(matour.matches(t)){break;}
            System.out.println("Loi dinh dang, vui long nhap lai.");
        }
        while(true){
        System.out.println("Nhap ngay di (dd/MM/yyyy): ");
        String ndi=sc.nextLine();
        try{
            ngaydi=LocalDate.parse(ndi, df);
            break;
        }catch(DateTimeParseException e){
            System.out.println("Loi dinh dang ngay, vui long nhap lai "+e.getMessage());
        }}
        while(true){
        System.out.println("Nhap ngay ve (dd/mm/yyyy): ");
        String nve=sc.nextLine();
        try{
            ngayve=LocalDate.parse(nve,df);
            if(ngayve.isBefore(ngaydi)){
                System.out.println("Ngay ve phai sau hoac bang ngay di, vui long nhap lai.");
                continue;
            }
            break;
        }catch(DateTimeParseException e)
        {
            System.out.println("Loi dinh dang ngay, vui long nhap lai "+e.getMessage());
        }
        }
        tongsove=nhapsonguyen("Nhap tong so ve: ");
        soveconlai=tongsove;
        tongchi = nhapsonguyen("Nhap tong chi: ");
        tongan = nhapsonguyen("Nhap tong an: ");
        tongo=nhapsonguyen("Nhap tong o: ");
        tongdilai=nhapsonguyen("Nhap tong di lai: ");

        String h="^HDV[0-9]{3}$";
        while(true)
        {System.out.println("Nhap ma huong dan vien: ");
        mahdv = sc.nextLine();
        if(mahdv.matches(h)){break;}
        System.out.println("Nhap sai dinh dang ma huong dan vien, vui long nhap lai.");
        }
        tongtienve=nhapsonguyen("Nhap tong tien ve: ");
    }

    public void xuat() {
        System.out.printf("%-10s %-10s %-12s %-12s %-8s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                makhtour, matour, ngaydi.format(df), ngayve.format(df), tongsove, soveconlai, tongchi, tongan, tongo,
                tongdilai, mahdv, tongtienve);
    }

    private int nhapsonguyen(String message){
        while(true){
            System.out.println(message);
            String input=sc.nextLine();
            try{
                int num=Integer.parseInt(input);
                if(num < 0){
                    System.out.println("Phai nhap gia tri lon hon 0, vui long nhap lai.");
                    continue;
                }
                return num;
            }catch(NumberFormatException e){
                System.out.println("Dinh dang khong hop le, vui long nhap lai.");
            }
        }
    }
}