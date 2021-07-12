package model;

public class TaiKhoanThanhToan extends TaiKhoanNganHang{
    private String soThe;
    private int tienTrongTaiKhoan;

    public TaiKhoanThanhToan(int id, String maNganHang, String tenChuTaiKhoan, String ngayTao, String soThe, int tienTrongTaiKhoan) {
        super(id, maNganHang, tenChuTaiKhoan, ngayTao);
        this.soThe = soThe;
        this.tienTrongTaiKhoan = tienTrongTaiKhoan;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public int getTienTrongTaiKhoan() {
        return tienTrongTaiKhoan;
    }

    public void setTienTrongTaiKhoan(int tienTrongTaiKhoan) {
        this.tienTrongTaiKhoan = tienTrongTaiKhoan;
    }

    @Override
    public String toString() {
        return super.toString() + "," + soThe + "," + tienTrongTaiKhoan;
    }

    @Override
    public void showInfo() {
        System.out.println("\tID: " + super.getIdTaiKhoan() +
                            "\tMã ngân hàng: " + super.getMaNganHang() +
                            "\tChủ tài khoản: " + super.getTenChuTaiKhoan() +
                            "\tNgày tạo: "+ super.getNgayTao() +
                            "\n\t\t\tSố thẻ: " + this.getSoThe() +
                            "\tSố tiền trong thẻ: " + this.getTienTrongTaiKhoan());
    }

}
