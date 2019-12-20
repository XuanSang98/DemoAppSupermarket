package sieuthimini.sangheungmin.com.siuthmini.Entity;

public class LinkAnh_Entity {
    private int id_linkanh;
    private int id_sanpham;
    private String anh1;
    private String anh2;
    private String anh3;
    private String anh4;

    public LinkAnh_Entity(int id_linkanh, int id_sanpham, String anh1, String anh2, String anh3, String anh4) {
        this.id_linkanh = id_linkanh;
        this.id_sanpham = id_sanpham;
        this.anh1 = anh1;
        this.anh2 = anh2;
        this.anh3 = anh3;
        this.anh4 = anh4;
    }

    public int getId_linkanh() {
        return id_linkanh;
    }

    public void setId_linkanh(int id_linkanh) {
        this.id_linkanh = id_linkanh;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public String getAnh1() {
        return anh1;
    }

    public void setAnh1(String anh1) {
        this.anh1 = anh1;
    }

    public String getAnh2() {
        return anh2;
    }

    public void setAnh2(String anh2) {
        this.anh2 = anh2;
    }

    public String getAnh3() {
        return anh3;
    }

    public void setAnh3(String anh3) {
        this.anh3 = anh3;
    }

    public String getAnh4() {
        return anh4;
    }

    public void setAnh4(String anh4) {
        this.anh4 = anh4;
    }
}
