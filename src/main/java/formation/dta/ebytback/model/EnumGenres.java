package formation.dta.ebytback.model;

import java.util.ArrayList;
import java.util.List;

public enum EnumGenres
{
	

	POP("POP"),
	ROCK("ROCK"),
	METAL("METAL"),
	CLASSIQUE("CLASSIQUE"),
	ELECTRO("ELECTRO"),
	VARIETE("VARIETE"),
	ANNEES80("ANNES 80"),
	PUNK("PUNK"),
	BLUES("BLUES"),
	JAZZ("JAZZ"),
	ACOUSTIQUE("ACOUSTIQUE");
	
	private String genre;
	
	private EnumGenres(String s)
	{
		this.genre = s;
	}

	public String getGenre()
	{
		return this.genre.toString();
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public static List<String> getAllGenres()
	{
		List<String> list = new ArrayList<String>();
		for(EnumGenres genre: EnumGenres.values()) {
			list.add(genre.getGenre());
		}
		return list;
	}
}