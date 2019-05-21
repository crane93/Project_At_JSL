package Dto;

public class Novel {
	private int novelNumber;
	private int lineNumber;
	private String title;
	private String contents;
	private String id;
	private int getLikeNumber;
	private int getViewNumber;
	private String nickname;
	
	public Novel(int novelNumber) {
		this.novelNumber = novelNumber;
	}
	
	public Novel(int novelNumber, String title) {
		this.novelNumber = novelNumber;
		this.title = title;
	}
	
	public Novel(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
	
	public Novel(int novelNumber, String title, int getLikeNumber, int getViewNumber) {
		this.novelNumber = novelNumber;
		this.title = title;
		this.getLikeNumber = getLikeNumber;
		this.getViewNumber = getViewNumber;
	}
	
	public Novel(int novelNumber, int lineNumber, String title, String contents, String id, int getLikeNumber, int getViewNumber) {
		this.novelNumber = novelNumber;
		this.lineNumber = lineNumber;
		this.title = title;
		this.contents = contents;
		this.id = id;
		this.getLikeNumber = getLikeNumber;
		this.getViewNumber = getViewNumber;
	}
	
	public Novel(int novelNumber, int lineNumber, String title, String contents, String id, int getLikeNumber, int getViewNumber, String nickname) {
		this.novelNumber = novelNumber;
		this.lineNumber = lineNumber;
		this.title = title;
		this.contents = contents;
		this.id = id;
		this.getLikeNumber = getLikeNumber;
		this.getViewNumber = getViewNumber;
		this.nickname = nickname;
	}
	
	public int getNovelNumber() {
		return novelNumber;
	}
	public void setNovelNumber(int novelNumber) {
		this.novelNumber = novelNumber;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGetLikeNumber() {
		return getLikeNumber;
	}
	public void setGetLikeNumber(int getLikeNumber) {
		this.getLikeNumber = getLikeNumber;
	}
	public int getGetViewNumber() {
		return getViewNumber;
	}
	public void setGetViewNumber(int getViewNumber) {
		this.getViewNumber = getViewNumber;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
