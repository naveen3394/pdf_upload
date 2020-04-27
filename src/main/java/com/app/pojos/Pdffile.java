package com.app.pojos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="pdf")

public class Pdffile {
		
		
			private Integer pdfId;
			private byte[] pdf;
			private String authName;
			private String bookName;
			
			public Pdffile() {
				// TODO Auto-generated constructor stub
			}
			public Pdffile(byte[] pdf, String authName,String bookName) {
				super();
				this.pdf = pdf;
				this.authName = authName;
				this.bookName=bookName;
			}


			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name = "pdfId")
			public Integer getPdfId() {
				return pdfId;
			}
			public void setPdfId(Integer pdfId) {
				this.pdfId = pdfId;
			}
			
			
			
			
			@Lob
			@Column(name = "pdf")
			public byte[] getpdf() {
				return pdf;
			}
			public void setpdf(byte[] pdf) {
				this.pdf = pdf;
			}
	
		public void setAuthName(String authName) {
			this.authName = authName;
		}
		public String getAuthName() {
			return authName;
		}
	
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getBookName() {
			return bookName;
		}
		@Override
		public String toString() {
			return "Pdffile [pdfId=" + pdfId + ", authName=" + authName + ", bookName=" + bookName + "]";
		}
		
		
		
}
