package model;

public class TaiKhoanTietKiem extends TaiKhoanNganHang{
    private int soTienGui;
    private String ngayGui;
    private float laiSuat;
    private int thoiHan;

    public TaiKhoanTietKiem(int id, String maNganHang, String tenChuTaiKhoan, String ngayTao, int soTienGui, String ngayGui, float laiSuat, int thoiHan) {
        super(id, maNganHang, tenChuTaiKhoan, ngayTao);
        this.soTienGui = soTienGui;
        this.ngayGui = ngayGui;
        this.laiSuat = laiSuat;
        this.thoiHan = thoiHan;
    }

    public int getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(int soTienGui) {
        this.soTienGui = soTienGui;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.ngayGui = ngayGui;
    }

    public float getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(float laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(int thoiHan) {
        this.thoiHan = thoiHan;
    }

    @Override
    public String toString() {
        return super.toString() + "," + soTienGui + "," + ngayGui + "," + laiSuat + "," + thoiHan;
    }

    @Override
    public void showInfo() {
        System.out.println("\tID: " + super.getIdTaiKhoan() +
                "\tMã ngân hàng: " + super.getMaNganHang() +
                "\tChủ tài khoản: " + super.getTenChuTaiKhoan() +
                "\tNgày tạo: "+ super.getNgayTao() +
                "\n\t\t\tSố tiền gửi: " + this.getSoTienGui() +
                "\tNgày gửi: " + this.getNgayGui() +
                "\tLãi suất: " + this.getLaiSuat() +
                "\tThời hạn: " + this.getThoiHan());
    }
}
