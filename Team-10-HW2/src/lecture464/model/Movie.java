package lecture464.model;

public class Movie {
	private int id;
	private String name;
	private String description;
	private String thumbnail;
	private String rating;
	
	public Movie(int id, String name, String description, String thumbnail, String rating) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.thumbnail = thumbnail;
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

	public Movie() {
		super();
	}
	
	
}
