/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

/**
 *
 * @author Andy.Mertens
 */
public enum Maat{
    centimeter(1),
    decimeter(10), 
    meter(100);
    
    private final int value;

    private Maat(int number) {
        value = number;
    }

    public int getValue() {
        return this.value;
    }

}
