/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookingsystem;

import bookingsystem.*;
import java.awt.Label;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Student.admin
 */
public class WelcomeNi {

    public static void main(String[] args) {
        LoadingPage ho = new LoadingPage();   // Home is name of the jFrame
        LandingPage lp = new LandingPage();   // Home is name of the jFrame
        ho.setVisible(true);

        try {
            for (int x = 0; x <= 100; x++) {
                Thread.sleep(50);

                ho.Label.setText(Integer.toString(x) + "%");
                ho.jProgBar.setValue(x);
            }
            {

            }
        } catch (Exception e) {
        }
        ho.setVisible(false);
        lp.setVisible(true);
    }
}
