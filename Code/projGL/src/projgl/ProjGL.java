/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projgl;

import dto.ClientDto;
import projgl.db.dbControl;
import screens.Auth;

/**
 *
 * @author lemmo
 */
public class ProjGL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Auth screen = new Auth();
        screen.setVisible(true);
    }

}
