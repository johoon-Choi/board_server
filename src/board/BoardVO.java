package board;

public class BoardVO {
	private	Integer	num;
	private String	title;
	private	String	content;
	private	String	author;
	
	{
		num	 	= -1;
		title	= null;
		content = null;
		author	= null;
	}
	
	public BoardVO() {		
		num	 	= -1;
		title	= null;
		content = null;
		author	= null;
	}

	public BoardVO(Integer num, String title, String content, String author) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "\t [BoardVO]" 
				+ "\n\t num = " + num 
				+ "\n\t title = " + title 
				+ "\n\t content = " + content 
				+ "\n\t author = " + author 
				+ "\n";
	}
}
