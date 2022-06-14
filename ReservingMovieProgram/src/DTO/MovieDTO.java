package DTO;
public class MovieDTO {
	private int roomNumber;
	private String movieName;
	private String moviePosterSrc;

	public MovieDTO() {
		super();
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMoviePosterSrc() {
		return moviePosterSrc;
	}
	public void setMoviePosterSrc(String moviePosterSrc) {
		this.moviePosterSrc = moviePosterSrc;
	}
}
