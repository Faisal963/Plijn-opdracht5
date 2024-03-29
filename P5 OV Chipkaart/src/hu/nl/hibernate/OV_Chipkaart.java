package hu.nl.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.sql.Date;

@Entity
@Table(name = "OV_CHIPKAART", uniqueConstraints = { @UniqueConstraint(columnNames = "KAARTNUMMER") })
public class OV_Chipkaart {

	@Id
	@Column(name = "KAARTNUMMER", unique = true, nullable = false, length = 10)
	private int kaartNummer;

	@Column(name = "GELDIGTOT")
	private Date geldigTot;

	@Column(name = "KLASSE", length = 1)
	private int klasse;

	@Column(name = "SALDO", length = 16, precision = 2)
	private float saldo;

	@ManyToOne(targetEntity = Reiziger.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "REIZIGERID")
	private Reiziger reiziger;

	public OV_Chipkaart() {
	}

	public OV_Chipkaart(int kaartNummer, Date geldigTot, int klasse, float saldo) {
		this(kaartNummer, geldigTot, klasse, saldo, null);
	}

	public OV_Chipkaart(int kaartNummer, Date geldigTot, int klasse, float saldo, Reiziger reiziger) {
		this.kaartNummer = kaartNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reiziger = reiziger;
		System.out.print("\nNieuwe OV_Chipkaart is seccesvol aangemaakt.");
	}

	public int getKaartNummer() {
		return kaartNummer;
	}

	public Date getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(Date geldigTot) {
		this.geldigTot = geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Reiziger getReiziger() {
		return reiziger;
	}

	public void setReiziger(Reiziger reiziger) {
		this.reiziger = reiziger;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass())
			return false;
		OV_Chipkaart kaart = (OV_Chipkaart) object;
		return kaartNummer == kaart.kaartNummer;
	}

	@Override
	public String toString() {
		return "OV_Chipkaart{" + "kaartNummer=" + kaartNummer + ", geldigTot=" + geldigTot + ", klasse=" + klasse
				+ ", saldo=" + saldo + '}';
	}
}
