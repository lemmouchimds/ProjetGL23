/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.ResultSet;
import java.util.Date;

import projgl.db.dbControl;

/**
 *
 * @author lemmo
 */
public class CompteDto {
    private int idCompte;
    private int idClient;
    private Date date;
    private double solde;
    private int type;
    private float max;

    final static public String SQLtableName = "compte";
    final static public String SQLidCompte = "idCompte";
    final static public String SQLidClient = "idClient";
    final static public String SQLdate = "date";
    final static public String SQLsolde = "solde";
    final static public String SQLtype = "type";
    final static public String SQLmax = "max";

    // Constructors
    public CompteDto() {
        // Default constructor
    }

    public CompteDto(int idCompte, int idClient, Date date, double solde, int type, float max) {
        this.idCompte = idCompte;
        this.idClient = idClient;
        this.date = date;
        this.solde = solde;
        this.type = type;
        this.max = max;
    }

    public static CompteDto fromResultSet(ResultSet resultSet) {
        try {
            int idCompte = resultSet.getInt(SQLidCompte);
            int idClient = resultSet.getInt(SQLidClient);
            Date date = resultSet.getDate(SQLdate);
            double solde = resultSet.getDouble(SQLsolde);
            int type = resultSet.getInt(SQLtype);
            float max = resultSet.getFloat(SQLmax);

            return new CompteDto(idCompte, idClient, date, solde, type, max);

        } catch (Exception e) {
            return null;
        }
    }

    // #region Getters & Setters

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

    /**
     * @return the idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
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
     * @return the solde
     */
    public double getSolde() {
        return solde;
    }

    /**
     * @param solde the solde to set
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the max
     */
    public float getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(float max) {
        this.max = max;
    }

    // #endregion

    public boolean debiter(double montant) {
        dbControl db = new dbControl();

        switch (type) {
            case 1:
                if (this.solde - montant < 0) {

                    return false;
                } else {
                    this.solde -= montant;
                    db.modifySolde(this.idCompte, this.solde);
                    return true;
                }
                
                case 2:
                if (this.solde - montant < -this.max) {
                    return false;
                } else {
                    this.solde -= montant;
                    db.modifySolde(this.idCompte, this.solde);
                    return true;
                }
                case 3:
                if (this.solde - montant < 0) {
                    return false;
                } else {
                    this.solde -= montant;
                    db.modifySolde(this.idCompte, this.solde);
                    return true;
                }
            default:
                return false;
        }

    }

    public void crediter(double montant) {
        this.solde += montant;
        dbControl db = new dbControl();
        db.modifySolde(this.idCompte, this.solde);
    }
}
