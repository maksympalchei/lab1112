/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

/**
 * Клас музикантів
 * @author korjk
 */
import java.util.ArrayList;
import java.util.List;

public class MusicPlayer implements Musician {

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the instruments
     */
    public List<Instrument> getInstruments() {
        return instruments;
    }

    /**
     * @param instruments the instruments to set
     */
    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }
    private String name;
    private List<Instrument> instruments;

    public MusicPlayer(String name) {
        this.name = name;
        this.instruments = new ArrayList<>();
    }

    @Override
    public void addInstrument(Instrument instrument) {
        getInstruments().add(instrument);
    }
    @Override
    public void playinstrument() {
        System.out.println("Музикант " + getName() + " грає:");
        for (Instrument instrument : getInstruments()) {
            instrument.play();
        }
    }
    @Override
    public void displayInfo() {
        System.out.println("Ім'я музиканта: " + getName());
        System.out.println("Інструменти, на яких вміє грати:");
        for (Instrument instrument : getInstruments()) {
            System.out.println("- " + instrument.getClass().getSimpleName());
        }
    }
}