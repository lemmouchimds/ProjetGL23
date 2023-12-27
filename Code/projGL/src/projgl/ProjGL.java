/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projgl;

import dto.ClientDto;
import projgl.db.dbControl;

/**
 *
 * @author lemmo
 */
public class ProjGL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            dbControl db = new dbControl();
            var v = db.find(2);
            v.setAddress(null);
            
            System.out.println(v.getAddress());
            
            if(db.matExist(2))
            {
                System.out.println("ouiiiii");
                
            }
            else
            {
                System.out.println("noooon");
            }
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
