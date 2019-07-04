package hu.nl.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "REIZIGER", uniqueConstraints = { @UniqueConstraint(columnNames = "REIZIGERID") })
public class Reiziger {

	@Id
	@Column(name = "REIZIGERID", unique = true, nullable = false)
	private int id;

	@Column(name = "VOORLETTERS", length = 10)
	private String voornaam;

	@Column(name = "TUSSENVOEGSEL", length = 10)
	private String tussenvoegsel;

	@Column(name = "ACHTERNAAM")
	private String achternaam;

	@Column(name = "GEBOORTEDATUM")
	private Date gbdatum;

	@OneToMany(targetEntity = OV_Chipkaart.class, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "reiziger")
	private List<OV_Chipkaart> kaarten;

	public Reiziger() {
	}

	public Reiziger(int id, String voornaam, String tussenvoegsel, String achternaam, Date gbdatum) {
		this(id, voornaam, tussenvoegsel, achternaam, gbdatum, null);
	}

	public Reiziger(int id, String voornaam, String tussenvoegsel, String achternaam, Date gbdatum,
			List<OV_Chipkaart> ovChipkaarten) {
		this.id = id;
		this.voornaam = voornaam;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gbdatum = gbdatum;
		this.kaarten = ovChipkaarten;
		System.out.print("\nNieuwe reiziger is seccesvol aangemaakt.");
	}

	public void addOVChipkaart(OV_Chipkaart ovChipkaart) {
		if (!kaarten.contains(ovChipkaart))
			kaarten.add(ovChipkaart);
	}

	public void removeOVChipkaart(OV_Chipkaart ovChipkaart) {
		kaarten.remove(ovChipkaart);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getVolledigeNaam() {
		if (tussenvoegsel.equals(null)) {
			return voornaam + " " + achternaam;
		} else {
			return voornaam + " " + tussenvoegsel + " " + achternaam;
		}
	}

	public Date getGbdatum() {
		return gbdatum;
	}

	public void setGbdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}

	public List<OV_Chipkaart> getOVChipkaarten() {
		return kaarten;
	}

	public void setOVChipkaarten(List<OV_Chipkaart> kaarten) {
		this.kaarten = kaarten;
		System.out.print("\nOV_Chipkaart is toegevoegd.");
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass())
			return false;
		Reiziger reiziger = (Reiziger) object;
		return id == reiziger.id;
	}

	@Override
	public String toString() {
		return "Reiziger{" + "id=" + id + ", voornaam='" + voornaam + '\'' + ", tussenvoegsel='" + tussenvoegsel + '\''
				+ ", achternaam='" + achternaam + '\'' + ", gbdatum=" + gbdatum + '}';
	}
}
