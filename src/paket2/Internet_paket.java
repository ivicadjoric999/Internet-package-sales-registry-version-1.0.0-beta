/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paket2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ivica Djoric
 */
public class Internet_paket {

    private final StringProperty ime = new SimpleStringProperty(this, "ime", "");
    private final StringProperty prezime = new SimpleStringProperty(this, "prezime", "");
    private final StringProperty adresa = new SimpleStringProperty(this, "adresa", "");
    private final StringProperty brzina = new SimpleStringProperty(this, "brzina", "");
    private final StringProperty protok = new SimpleStringProperty(this, "protok", "");
    private final StringProperty ugovor = new SimpleStringProperty(this, "ugovor", "");
    private final IntegerProperty indefikacioni_broj = new SimpleIntegerProperty(this, "indefikacioni_broj", 0);

    public Internet_paket() {
    }

    public Internet_paket(String ime, String prezime, String Adresa, String brzina, String protok, String ugovor, Integer idenfikacioni_broj) {
        this.ime.set(ime);
        this.prezime.set(prezime);
        this.brzina.set(brzina);
        this.protok.set(protok);
        this.ugovor.set(ugovor);
        this.indefikacioni_broj.set(idenfikacioni_broj);
        this.adresa.set(Adresa);

    }

    public String getAdresa() {
        return adresa.get();
    }

    public void setAdresa(String ime) {
        this.adresa.set(ime);
    }

    public StringProperty adresaProperty() {
        return adresa;
    }

    public String getIme() {
        return ime.get();
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public StringProperty imeProperty() {
        return ime;
    }

    public String getPrezime() {
        return prezime.get();
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public StringProperty preziProperty() {
        return prezime;
    }

    public void setBrzina(String brzina) {
        this.brzina.set(brzina);
    }

    public String getBrzina() {
        return brzina.get();
    }

    public StringProperty brzProperty() {
        return brzina;
    }

    public void setprotok(String protok) {
        this.protok.set(protok);
    }

    public String getprotok() {
        return protok.get();
    }

    public StringProperty protokProperty() {
        return protok;
    }

    public void setUgovor(String ugovor) {
        this.ugovor.set(ugovor);
    }

    public String getUgovor() {
        return ugovor.get();
    }

    public StringProperty ugovorProperty() {
        return ugovor;
    }

    public void setIndefikacioni_broj(int indfk) {
        indefikacioni_broj.set(indfk);
    }

    public Integer getIdenfikacioni_broj() {
        return indefikacioni_broj.get();
    }

    public IntegerProperty idenfikacioni_brojProperty() {
        return indefikacioni_broj;
    }
}


