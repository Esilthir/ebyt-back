package formation.dta.ebytback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinTable(name="item_concert",  joinColumns=@JoinColumn(name="concert_id"), inverseJoinColumns=@JoinColumn(name="item_id"))
	private Concert concert;
	
	@Column
	private Integer quantite;
	
	@ManyToOne
	private Commande commandeId;
	
	

}
