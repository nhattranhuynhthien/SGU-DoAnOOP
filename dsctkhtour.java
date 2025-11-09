import java.util.Scanner;
import java.util.Arrays;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.time.format.DateTimeParseException;

class dsctkhtour {
    private ctkhtour[] ds;
    private int N = 0;
    Scanner sc = new Scanner(System.in);

    
    public dsctkhtour() {
        ds = new ctkhtour[100];
        N = 0;
    }

    public dsctkhtour(ctkhtour[] ds, int n) {
        this.ds = ds;
        this.N = n;
    }

    public dsctkhtour(dsctkhtour dsct) {
        this.ds = Arrays.copyOf(dsct.ds, N);
        this.N = dsct.N;
    }

    public ctkhtour[] getDs() {
        return ds;
    }

    public int getN() {
        return N;
    }

    public void setDs(ctkhtour[] ds) {
        this.ds = ds;
    }

    public void setN(int n) {
        this.N = n;
    }
   
    public void nhapds() {
        System.out.print("Nhap so luong chi tiet ke hoach tour: ");
        N = Integer.parseInt(sc.nextLine()); 
        ds = new ctkhtour[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Nhap chi tiet ke hoach tour thu " + (i + 1) + ":");
            ds[i] = new ctkhtour();
            ds[i].nhap();
        }
    }

    public void xuatds() {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n","Ma ctkh tour", "Ma KH Tour", "Ngay Chi", "Tien An", "Tien O", "Tien Di Lai");
        for (int i = 0; i < N; i++) {
            ds[i].xuat();
        }
    }


    public int timTheoMa(String mact) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getMact().equals(mact)) {
                return i;
            }
        }
        return -1;
    }
    
    public void timTheoNgayChi(LocalDate ngaychi) { 
        boolean found = false;
        System.out.println("\n=== KET QUA TIM KIEM THEO NGAY CHI: " + ngaychi.format(kehoachtour.df) + " ===");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n","Ma ctkh tour", "Ma KH Tour", "Ngay Chi", "Tien An", "Tien O", "Tien Di Lai");

        for (int i = 0; i < N; i++) {
            if (ds[i].getNgaychi().equals(ngaychi)) { 
                ds[i].xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println(" Khong tim thay ke hoach tour nao co ngay chi: " + ngaychi.format(kehoachtour.df));
        }
    }

    public ctkhtour timCots(String mact) {
        int idx = timTheoMa(mact);
        if (idx != -1)
            return ds[idx];
        return null;
    }


    public void themCots(ctkhtour k) {
        if (timTheoMa(k.getMact()) != -1) {
            System.out.println("Loi: Ma chi tiet KHT '" + k.getMact() + "' da ton tai. Khong the them.");
            return;
        }
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = new ctkhtour(k);
        N++;
        System.out.println(" Da them ke hoach tour moi (co tham so).");
    }

    public void xoaCots(String makhtour) { 
        int idx = timTheoMa(makhtour); 
        if (idx == -1) {
            System.out.println(" Khong tim thay ke hoach tour de xoa!");
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println(" Da xoa ke hoach tour co ma: " + makhtour);
    }

    public void thongKeTheoMa() {
        if (N == 0) {
            System.out.println(" Danh sach ke hoach tour rong!");
            return;
        }
        System.out.print("Nhap ma ke hoach tour can thong ke: ");
        String makhtour = sc.nextLine();
        int ta=0;
        int to=0;
        int td=0;
        int tien=0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (ds[i].getMakhtour().equalsIgnoreCase(makhtour)) {
                ta+=ds[i].getTienan();
                to+=ds[i].getTieno();
                td+=ds[i].getTiendilai();
                count++;
            }
        }
        if (count == 0) {
            System.out.println(" Khong tim thay ke hoach tour co ma: " + makhtour);
        } else {
            tien=ta+to+td;
            System.out.println(" Ma ke hoach tour '" + makhtour + "' co " + count + " chi tiet.");
            System.out.println("Tong tien chi phi cho toan bo ke hoach tour nay la "+tien);
        }
    }

    private int nhapSoNguyen(String message) {
        while(true){
            System.out.println(message);
            try {
                int num = Integer.parseInt(sc.nextLine());
                 if(num < 0){
                    System.out.println("Phai nhap gia tri lon hon 0, vui long nhap lai.");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le.");
            }
        }
    }

    public void suaKhtour(String mact) {
        int idx = timTheoMa(mact); 

        if (idx == -1) {
            System.out.println(" Khong tim thay ke hoach tour co ma: " + mact);
            return;
        }

        ctkhtour k = ds[idx];
        int chon;
        do {
            System.out.println("\n=== CHON MUC CAN SUA ===");
            System.out.println("1. Ngay chi");
            System.out.println("2. Tien an");
            System.out.println("3. Tien o");
            System.out.println("4. Tien di lai");
            System.out.println("0. Thoat sua");
            System.out.print("Nhap lua chon: ");
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                chon = -1; 
            }

            switch (chon) {
                case 1:
                    while(true){
                        System.out.print("Nhap ngay chi moi (dd/MM/yyyy): ");
                        String ngay = sc.nextLine();
                        try {
                            LocalDate ngaymoi = LocalDate.parse(ngay, kehoachtour.df);
                            k.setNgaychi(ngaymoi);
                            System.out.println(" Da sua ngay chi!");
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Sai dinh dang ngay!");
                        }
                    }
                    break;
                case 2:
                    int tienan = nhapSoNguyen("Nhap tien an moi: "); 
                    k.setTienan(tienan);
                    System.out.println(" Da sua tien an!");
                    break;
                case 3:
                    int tieno = nhapSoNguyen("Nhap tien o moi: "); 
                    k.setTieno(tieno);
                    System.out.println(" Da sua tien o!");
                    break;
                case 4:
                    int tiendilai = nhapSoNguyen("Nhap tien di lai moi: "); 
                    k.setTiendilai(tiendilai);
                    System.out.println(" Da sua tien di lai!");
                    break;
                case 0:
                    System.out.println("Thoat sua thong tin.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    public void docFile(String file){
        try {
            BufferedReader br=new BufferedReader(new FileReader(file));
            int n=0;
            ds=new ctkhtour[1000];
            String line="";

            while((line=br.readLine())!=null){
                String[] part=line.split("\\|");
                
                if(part.length>=6){ 
                    String mact=part[0];
                    String makhtour=part[1];
                    LocalDate ngaychi=LocalDate.parse(part[2], kehoachtour.df);
                    int tienan=Integer.parseInt(part[3]);
                    int tieno=Integer.parseInt(part[4]);
                    int tiendilai=Integer.parseInt(part[5]);

                    ds[n++]=new ctkhtour(mact,makhtour,ngaychi,tienan,tieno, tiendilai);
                }
            }
            N=n;
            ds=Arrays.copyOf(ds,N);
            br.close();
            System.out.println("Da doc "+N+" chi tiet ke hoach tour tu file "+file);
        }
        catch(Exception e){
            System.out.println("Loi doc file "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void ghiFile(String file){
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter(file));
            for(int i=0;i<N;i++){
                ctkhtour c=ds[i];
                String line="";

                line=String.join("|",
                c.getMact(),
                c.getMakhtour(),
                c.getNgaychi().format(kehoachtour.df),
                String.valueOf(c.getTienan()),
                String.valueOf(c.getTieno()),
                String.valueOf(c.getTiendilai()));
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Da cap nhat vao file "+file);
        }
        catch(Exception e){
            System.out.println("Loi ghi file "+e.getMessage());
            e.printStackTrace();
        }
    }
}