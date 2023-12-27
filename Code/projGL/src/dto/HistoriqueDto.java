/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author lemmo
 */
public class HistoriqueDto {
    private int idHist;
    private Date date;
    private double montant;
    private int idCompte;

    final static public String SQLtableName = "historique";
    final static public String SQLidHist = "idHist";
    final static public String SQLdate = "date";
    final static public String SQLmontant = "montant";
    final static public String SQLidCompte = "idCompte";


    // Constructors
    public HistoriqueDto() {
        // Default constructor
    }

    public HistoriqueDto(int idHist, Date date, double montant, int idCompte) {
        this.idHist = idHist;
        this.date = date;
        this.montant = montant;
        this.idCompte = idCompte;
    }

    public static HistoriqueDto fromResultSet(ResultSet resultSet) {
        try {
            int idHist = resultSet.getInt(SQLidHist);
            Date date = resultSet.getDate(SQLdate);
            double montant = resultSet.getDouble(SQLmontant);
            int idCompte = resultSet.getInt(SQLidCompte);

            return new HistoriqueDto(idHist, date, montant, idCompte);

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @return the idHist
     */
    public int getIdHist() {
        return idHist;
    }

    /**
     * @param idHist the idHist to set
     */
    public void setIdHist(int idHist) {
        this.idHist = idHist;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the montant
     */
    public double getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * @return the idCompte
     */
    public int getIdCompte() {
        return idCompte;
    }

    /**
     * @param idCompte the idCompte to set
     */
    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }
}
