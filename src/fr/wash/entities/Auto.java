package fr.wash.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Auto implements Serializable{
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private String marque;
		private String modele;
		private Date annee;
		private Date dateCreate;
		private Date dateUpdate;
		
		@ManyToOne
		@JoinColumn(name="idUser")
		private User user;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMarque() {
			return marque;
		}

		public void setMarque(String marque) {
			this.marque = marque;
		}

		public String getModele() {
			return modele;
		}

		public void setModele(String modele) {
			this.modele = modele;
		}

		public Date getAnnee() {
			return annee;
		}

		public void setAnnee(Date annee) {
			this.annee = annee;
		}

		public Date getDateCreate() {
			return dateCreate;
		}

		public void setDateCreate(Date dateCreate) {
			this.dateCreate = dateCreate;
		}

		public Date getDateUpdate() {
			return dateUpdate;
		}

		public void setDateUpdate(Date dateUpdate) {
			this.dateUpdate = dateUpdate;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Auto(String marque, String modele, Date annee, Date dateCreate, Date dateUpdate, User user) {
			super();
			this.marque = marque;
			this.modele = modele;
			this.annee = annee;
			this.dateCreate = dateCreate;
			this.dateUpdate = dateUpdate;
			this.user = user;
		}
		
		public Auto() {
			// TODO Auto-generated constructor stub
		}
		
}
