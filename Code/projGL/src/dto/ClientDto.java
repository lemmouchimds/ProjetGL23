/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.ResultSet;

/**
 *
 * @author lemmo
 */
public class ClientDto {
    private int idClient;
    private String address;
    private String tel;
    private String email;
    public boolean isPhysic;
    private String nom;
    private String prenom;
    private String date;
    private String profession;
    private String designation;
    private String activiter;
    private String nrc;
    private String nif;

    final static public String SQLtableName = "client";
    final static public String SQLidClient = "idClient";
    final static public String SQLaddress = "adress";
    final static public String SQLtel = "tel";
    final static public String SQLemail = "email";
    final static public String SQLisPhysic = "isPhysic";
    final static public String SQLnom = "nom";
    final static public String SQLprenom = "prenom";
    final static public String SQLdate = "date";
    final static public String SQLprofession = "profession";
    final static public String SQLdesignation = "designation";
    final static public String SQLactiviter = "activiter";
    final static public String SQLnrc = "nrc";
    final static public String SQLnif = "nif";

    // Constructors
    public ClientDto() {
        // Default constructor
    }

    public ClientDto(int idClient, String address, String tel, String email, boolean isPhysic,
            String nom, String prenom, String date, String profession,
            String designation, String activiter, String nrc, String nif) {
        this.idClient = idClient;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.isPhysic = isPhysic;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.profession = profession;
        this.designation = designation;
        this.activiter = activiter;
        this.nrc = nrc;
        this.nif = nif;
    }

    public static ClientDto fromResultSet(ResultSet rs) {
        try {
            ClientDto client = new ClientDto();
            client.setIdClient(rs.getInt(ClientDto.SQLidClient));
            client.setAddress(rs.getString(ClientDto.SQLaddress));
            client.setTel(rs.getString(ClientDto.SQLtel));
            client.setEmail(rs.getString(ClientDto.SQLemail));
            client.setIsPhysic(rs.getBoolean(ClientDto.SQLisPhysic));
            client.setNom(rs.getString(ClientDto.SQLnom));
            client.setPrenom(rs.getString(ClientDto.SQLprenom));
            client.setDate(rs.getString(ClientDto.SQLdate));
            client.setProfession(rs.getString(ClientDto.SQLprofession));
            client.setDesignation(rs.getString(ClientDto.SQLdesignation));
            client.setActiviter(rs.getString(ClientDto.SQLactiviter));
            client.setNrc(rs.getString(ClientDto.SQLnrc));
            client.setNif(rs.getString(ClientDto.SQLnif));
            return client;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the isPhysic
     */
    public boolean isIsPhysic() {
        return isPhysic;
    }

    /**
     * @param isPhysic the isPhysic to set
     */
    public void setIsPhysic(boolean isPhysic) {
        this.isPhysic = isPhysic;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * @param profession the profession to set
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the activiter
     */
    public String getActiviter() {
        return activiter;
    }

    /**
     * @param activiter the activiter to set
     */
    public void setActiviter(String activiter) {
        this.activiter = activiter;
    }

    /**
     * @return the nrc
     */
    public String getNrc() {
        return nrc;
    }

    /**
     * @param nrc the nrc to set
     */
    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(String nif) {
        this.nif = nif;
    }
}
