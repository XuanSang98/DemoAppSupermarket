package sieuthimini.sangheungmin.com.siuthmini.Entity;

public class LoaiSanPham {
    private int id_loaisanpham;
    private String tenloaisanpham;
    private String linkanhloaisanpham;

    public LoaiSanPham(int id_loaisanpham, String tenloaisanpham, String linkanhloaisanpham) {
        this.id_loaisanpham = id_loaisanpham;
        this.tenloaisanpham = tenloaisanpham;
        this.linkanhloaisanpham = linkanhloaisanpham;
    }

    public int getId_loaisanpham() {
        return id_loaisanpham;
    }

    public void setId_loaisanpham(int id_loaisanpham) {
        this.id_loaisanpham = id_loaisanpham;
    }

    public String getTenloaisanpham() {
        return tenloaisanpham;
    }

    public void setTenloaisanpham(String tenloaisanpham) {
        this.tenloaisanpham = tenloaisanpham;
    }

    public String getLinkanhloaisanpham() {
        return linkanhloaisanpham;
    }

    public void setLinkanhloaisanpham(String linkanhloaisanpham) {
        this.linkanhloaisanpham = linkanhloaisanpham;
    }
}
