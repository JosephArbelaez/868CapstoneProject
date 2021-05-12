package com.example.C868CapstoneProject.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Charge")
public class Charge {
	
	@Id
	@SequenceGenerator(
			name = "charge_sequence",
			sequenceName = "charge_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = SEQUENCE,
			generator = "charge_sequence"
	)
	@Column(
		name = "charge_id",
		updatable = false
	)
	private Long id;
	
	@Column(
			name = "type",
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String type;
	
	@Column(
			name = "price",
			nullable = true,
			columnDefinition = "DECIMAL(5, 2)"
	)
	private double price;
	
	@Column(
			name = "description",
			nullable = true,
			columnDefinition = "TEXT"
	)
	private String description;

	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	public Charge() {
		
	}

	public Charge(String type, double price, String description) {
		super();
		this.type = type;
		this.price = price;
		this.description = description;
	}

	public Charge(String type, double price, String description, Person p) {
		super();
		this.type = type;
		this.price = price;
		this.description = description;
		this.person = p;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Person getPatron() {
		return person;
	}

	public void setPatron(Person p) {
		this.person = p;
	}

	@Override
	public String toString() {
		return "Charge [id=" + id + ", type=" + type + ", price=" + price + ", description=" + description + "]";
	}
	
}
