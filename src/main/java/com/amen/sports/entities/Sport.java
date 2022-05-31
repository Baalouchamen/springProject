package com.amen.sports.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Sport {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Long idSport;
@NotNull
@Size (min = 4,max = 20)
private String nomSport;

@Min(value = 1)
public int nbrjoueur;

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateCreation;
@ManyToOne
private Type type;

public Sport() {
super();
}
public Sport(String nomSport, Date dateCreation,  int nbrjoueur,Type type) {
super();
this.nomSport = nomSport;
this.nbrjoueur = nbrjoueur;
this.dateCreation = dateCreation;
this.type = type;
}
public Long getIdSport() {
return idSport;
}
public void setIdSport(Long idSport) {
this.idSport = idSport;
}
public String getNomSport() {
return nomSport;
}
public void setNomSport(String nomSport) {
this.nomSport = nomSport;
}
public int getnbrjoueur() {
return nbrjoueur;
}
public void setnbrjoueur(int nbrjoueur) {
this.nbrjoueur = nbrjoueur;
}
public Date getDateCreation() {
return dateCreation;
}
public void setDateCreation(Date dateCreation) {
this.dateCreation = dateCreation;
}
public Type getType() {
	return type;
}
public void setType(Type type) {
	this.type = type;
}

@Override
public String toString() {
return "Sport [idSport=" + idSport + ", nomSport=" + nomSport + ", nombre de joueur=" + nbrjoueur + ", dateCreation=" + dateCreation + "]";

}
}