package sieuthimini.sangheungmin.com.siuthmini.Entity;

public class DanhSachSanPhamEntity {
    private int id_sanpham;
    private int id_loaisanpham;
    private String tenSanPham;
    private int soLuongSanPham;
    private int donGia;
    private String linkAnhSanPham;
    private String moTa;
    private int trangThai;

    public DanhSachSanPhamEntity(int id_sanpham, int id_loaisanpham, String tenSanPham, int soLuongSanPham, int donGia, String linkAnhSanPham, String moTa, int trangThai) {
        this.id_sanpham = id_sanpham;
        this.id_loaisanpham = id_loaisanpham;
        this.tenSanPham = tenSanPham;
        this.soLuongSanPham = soLuongSanPham;
        this.donGia = donGia;
        this.linkAnhSanPham = linkAnhSanPham;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public int getId_loaisanpham() {
        return id_loaisanpham;
    }

    public void setId_loaisanpham(int id_loaisanpham) {
        this.id_loaisanpham = id_loaisanpham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getLinkAnhSanPham() {
        return linkAnhSanPham;
    }

    public void setLinkAnhSanPham(String linkAnhSanPham) {
        this.linkAnhSanPham = linkAnhSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
