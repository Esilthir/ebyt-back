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
	private Date date;
	@Column
	private String place;
	@Column
	private String genre;
	@Column
	private String description;
	@Column
	private int places_max_nb;
	@Column
	private int price;
	@Column
	private int places_nb_price;

	public Concert() {}

	public Concert(String artist, Date date, String place, String genre, String description, int places_max_nb,
			int price, int places_nb_price) {
		this.artist = artist;
		this.date = date;
		this.place = place;
		this.genre = genre;
		this.description = "";
		this.places_max_nb = 0;
		this.price = 0;
		this.places_nb_price = 0;
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

	public int getPlaces_max_nb() {
		return places_max_nb;
	}

	public void setPlaces_max_nb(int places_max_nb) {
		this.places_max_nb = places_max_nb;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPlaces_nb_price() {
		return places_nb_price;
	}

	public void setPlaces_nb_price(int places_nb_price) {
		this.places_nb_price = places_nb_price;
	}
	
	
}