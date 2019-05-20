package prodavnicaMuzike;

import java.util.Date;
import java.util.LinkedList;

public class Album {
	private String naziv;
	private String izvodjac;
	private Date datum;
	private LinkedList<Numera> lista;
	
	public Album(String naziv, String izvodjac, Date datum) {
		this.naziv=naziv;
		this.izvodjac=izvodjac;
		this.datum=datum;
		
	}
	

	
	public void dodajNumeru(Numera n) {
		lista.add(n);
		
	}
	
	public void dodajNumeruITrajanje(String name, String trajanje) {
		Numera n= new Numera(name, trajanje);
		lista.add(n);
	}
	
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getIzvodjac() {
		return izvodjac;
	}
	public void setIzvodjac(String izvodjac) {
		this.izvodjac = izvodjac;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public LinkedList<Numera> getLista() {
		return lista;
	}
	public void setLista(LinkedList<Numera> lista) {
		this.lista = lista;
	}
	
	
	public Numera getNumera(int index) {
		Numera n= lista.get(index);
		return n;
		}
	
	public Numera getNumeraPoImenu(String s){
		for(int i=0;i<this.lista.size();i++) {
		if (s.contentEquals(lista.get(i).getNaziv())){
			return lista.get(i);
		  }
		}
		Numera n=null;
		return n;
	}



	@Override
	public String toString() {
		return "Album [naziv=" + naziv + ", izvodjac=" + izvodjac + ", datum=" + datum + ", lista=" + lista + "]";
	}
	
	}

	

