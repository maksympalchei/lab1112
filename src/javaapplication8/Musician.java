/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaapplication8;

/**
 * Інтерфейс музикантів, у якому прописані основні дії, які б мав виконувати кожен музикант
 * @author korjk
 */
public interface Musician {
    void playinstrument();
    void displayInfo();
    void addInstrument(Instrument instrument);
}
