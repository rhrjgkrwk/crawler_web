package vo;

public class ChartVO {
	private String rank;
	private String artist;
	private String song;
	public ChartVO() {
		// TODO Auto-generated constructor stub
	}
	public ChartVO(String rank, String artist, String song) {
		super();
		this.rank = rank;
		this.artist = artist;
		this.song = song;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
}
