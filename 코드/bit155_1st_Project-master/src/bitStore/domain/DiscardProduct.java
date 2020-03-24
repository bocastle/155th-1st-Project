package bitStore.domain;

public class DiscardProduct {
	private String pName; //상품명
	private int pNo; //상품 번호
	private int price; //상품 가격
	private String exprtDate; //유통기한
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
