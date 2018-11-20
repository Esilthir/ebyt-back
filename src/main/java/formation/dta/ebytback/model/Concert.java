package formation.dta.ebytback.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "concert")
public class Concert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String artist;
	@Column
	private String name;
	@Column
	private Date date;
	@Column
	private String place;
	@Column
	private String genre;
	@Column
	private String description;
	@Column
	private Integer nbMaxPlaces;
	@Column
	private Double price;
	@Column
	private Integer nbBoughtPlace;
	@Column
	private boolean active;
	@Column
	private String urlVideo;
	@Column
	private String urlPic;
	@Column
	private String urlPicRec;

	public Concert() {}

	public Concert(String name, String artist, Date date, String place, String genre, String description, Integer nbMaxPlaces,
			Double price) {
		this.name = name;
		this.artist = artist;
		this.date = date;
		this.place = place;
		this.genre = genre;
		this.description = description;
		this.nbMaxPlaces = nbMaxPlaces;
		this.price = price;
		this.nbBoughtPlace = 0;
		this.active = true;
	}
	
	public Concert(String name, String artist, Date date, String place, String genre, String description, Integer nbMaxPlaces,
			Double price, String urlVideo, String urlPic, String urlPicRec) {
		this(name, artist, date, place, genre, description, nbMaxPlaces, price);
		this.urlPic = urlPic;
		this.urlPicRec = urlPicRec;
		this.urlVideo = urlVideo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNbMaxPlaces() {
		return nbMaxPlaces;
	}

	public void setNbMaxPlaces(Integer nbMaxPlaces) {
		this.nbMaxPlaces = nbMaxPlaces;
	}

	public Integer getNbBoughtPlace() {
		return nbBoughtPlace;
	}

	public void setNbBoughtPlace(Integer nbBoughtPlace) {
		this.nbBoughtPlace = nbBoughtPlace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public String getUrlPic() {
		return urlPic;
	}

	public void setUrlPic(String urlPic) {
		this.urlPic = urlPic;
	}

	public String getUrlPicRec() {
		return urlPicRec;
	}

	public void setUrlPicRec(String urlPicRec) {
		this.urlPicRec = urlPicRec;
	}
	
	
	
}