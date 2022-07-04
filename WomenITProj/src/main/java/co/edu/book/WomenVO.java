package co.edu.book;

public class WomenVO {
	private String BookCode;
	private String BookName;
	private String BookWriter;
	private String Bookpublisher;
	private int BookPrice;
	public String getBookCode() {
		return BookCode;
	}
	public void setBookCode(String bookCode) {
		BookCode = bookCode;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getBookWriter() {
		return BookWriter;
	}
	public void setBookWriter(String bookWriter) {
		BookWriter = bookWriter;
	}
	public String getBookpublisher() {
		return Bookpublisher;
	}
	public void setBookpublisher(String bookpublisher) {
		Bookpublisher = bookpublisher;
	}
	public int getBookPrice() {
		return BookPrice;
	}
	public void setBookPrice(int bookPrice) {
		BookPrice = bookPrice;
	}
	
	
	@Override
	public String toString() {
		return "WomenVO [BookCode=" + BookCode + ", BookName=" + BookName + ", BookWriter=" + BookWriter
				+ ", Bookpublisher=" + Bookpublisher + ", BookPrice=" + BookPrice + "]";
	}
	


	
	
	
	
	
}
