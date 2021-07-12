package model;

public abstract class TaiKhoanNganHang {
    private int idTaiKhoan;
    private String maNganHang;
    private String tenChuTaiKhoan;
    private String ngayTao;

    public TaiKhoanNganHang(int id, String maNganHang, String tenChuTaiKhoan, String ngayTao) {
        this.idTaiKhoan = id;
        this.maNganHang = maNganHang;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.ngayTao = ngayTao;
    }

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getMaNganHang() {
        return maNganHang;
    }

    public void setMaNganHang(String maNganHang) {
        this.maNganHang = maNganHang;
    }

    public String getTenChuTaiKhoan() {
        return tenChuTaiKhoan;
    }

    public void setTenChuTaiKhoan(String tenChuTaiKhoan) {
        this.tenChuTaiKhoan = tenChuTaiKhoan;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return "" + idTaiKhoan +
                ',' + maNganHang +
                "," + tenChuTaiKhoan +
                "," + ngayTao;
    }

    public abstract void showInfo();
}
