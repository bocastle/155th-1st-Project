package bitStore.domain;

public class DiscardProduct {
	private String pName; //��ǰ��
	private int pNo; //��ǰ ��ȣ
	private int price; //��ǰ ����
	private String exprtDate; //�������
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getExprtDate() {
		return exprtDate;
	}
	public void setExprtDate(String exprtDate) {
		this.exprtDate = exprtDate;
	}
	@Override
	public String toString() {
		return "DiscardProduct [pName=" + pName + ", pNo=" + pNo + ", price=" + price + ", exprtDate=" + exprtDate
				+ "]";
	}
}
