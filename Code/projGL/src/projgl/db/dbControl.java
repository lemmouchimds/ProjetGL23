/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projgl.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.ClientDto;
import dto.CompteDto;
import dto.HistoriqueDto;
import projgl.tableType;

/**
 *
 * @author lemmo
 */
public class dbControl {
    final String driver = "com.mysql.cj.jdbc.Driver";
    final String url = "jdbc:mysql://localhost:3300/gl?zeroDateTimeBehavior=CONVERT_TO_NULL";
    final String user = "root";
    final String pass = "abdou0000";
    Connection cnx;

    public dbControl() {
        try {
            Class.forName(driver);
            cnx = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.<init>() : " + e.getMessage());
        }

    }

    public ResultSet getResults(String sql) {
        try {
            PreparedStatement p = cnx.prepareStatement(sql);
            return p.executeQuery();
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.getResults() : " + e.getMessage());
            return null;
        }
    }

    public boolean delete(int id, tableType type) {
        String table = "";
        String idTable = "";
        switch (type) {
            case client:
                table = ClientDto.SQLtableName;
                idTable = ClientDto.SQLidClient;
                break;
            case compte:
                table = CompteDto.SQLtableName;
                idTable = CompteDto.SQLidCompte;
                break;

            case historique:
                table = HistoriqueDto.SQLtableName;
                idTable = HistoriqueDto.SQLidHist;

                break;
            default:
                break;
        }

        String sql = "DELETE FROM " + table + " WHERE " + idTable + " = " + id;
        try {
            PreparedStatement p = cnx.prepareStatement(sql);
            p.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.deleteClient() : " + e.getMessage());
            return false;
        }
    }

    public boolean matExist(int mat) {
        try {
            String sql = "SELECT * FROM " + ClientDto.SQLtableName + " WHERE " + ClientDto.SQLidClient + " = ?";
            PreparedStatement p = cnx.prepareStatement(sql);
            p.setInt(1, mat);
            ResultSet result = p.executeQuery();
            return result.next();
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.matExist() : " + e.getMessage());
            return false;
        }

    }

    // #region client

    public void insertClient(ClientDto clientDto) {
        try {
            String sql = "INSERT INTO client " +
                    "(adress, tel, email, isPhysic, nom, prenom, date, " +
                    "profession, designation, activiter, nrc, nif) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement p = cnx.prepareStatement(sql);
            p.setString(1, clientDto.getAddress());
            p.setString(2, clientDto.getTel());
            p.setString(3, clientDto.getEmail());
            p.setBoolean(4, clientDto.isPhysic);
            p.setString(5, clientDto.getNom());
            p.setString(6, clientDto.getPrenom());
            p.setString(7, clientDto.getDate());
            p.setString(8, clientDto.getProfession());
            p.setString(9, clientDto.getDesignation());
            p.setString(10, clientDto.getActiviter());
            p.setString(11, clientDto.getNrc());
            p.setString(12, clientDto.getNif());
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.insertClient() : " + e.getMessage());
        }
    }

    public void modifyClient(ClientDto clientDto) {
        try {
            String sql = "UPDATE client SET " +
                    "adress = ?, tel = ?, email = ?, isPhysic = ?, nom = ?, prenom = ?, date = ?, " +
                    "profession = ?, designation = ?, activiter = ?, nrc = ?, nif = ? " +
                    "WHERE idClient = ?";

            PreparedStatement p = cnx.prepareStatement(sql);
            p.setString(1, clientDto.getAddress());
            p.setString(2, clientDto.getTel());
            p.setString(3, clientDto.getEmail());
            p.setBoolean(4, clientDto.isPhysic);
            p.setString(5, clientDto.getNom());
            p.setString(6, clientDto.getPrenom());
            p.setString(7, clientDto.getDate());
            p.setString(8, clientDto.getProfession());
            p.setString(9, clientDto.getDesignation());
            p.setString(10, clientDto.getActiviter());
            p.setString(11, clientDto.getNrc());
            p.setString(12, clientDto.getNif());
            p.setInt(13, clientDto.getIdClient());
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.modifyClient() : " + e.getMessage());
        }
    }

    public ClientDto find(int id) {
        String sql = "SELECT * FROM client WHERE idClient = " + id;
        ResultSet rs = getResults(sql);
        try {
            if (rs.next()) {
                return ClientDto.fromResultSet(rs);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.find() : " + e.getMessage());
            return null;
        }

    }

    public List<ClientDto> findAllClient() {
        String sql = "SELECT * FROM client";
        ResultSet rs = getResults(sql);
        List<ClientDto> clients = new ArrayList<ClientDto>();
        try {
            while (rs.next()) {
                ClientDto client = ClientDto.fromResultSet(rs);
                clients.add(client);
            }
            return clients;
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.findAll() : " + e.getMessage());
            return null;
        }

    }

    // #endregion client

    // #region compte

    public void insertCompte(CompteDto compteDto) {
        try {
            String sql = "INSERT INTO compte " +
                    "(idClient, solde, date, type, max) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement p = cnx.prepareStatement(sql);
            p.setInt(1, compteDto.getIdClient());
            p.setDouble(2, compteDto.getSolde());
            p.setDate(3, (Date) compteDto.getDate());
            p.setInt(4, compteDto.getType());
            p.setDouble(5, compteDto.getMax());
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.insertCompte() : " + e.getMessage());
        }
    }

    public void modifyCompte(CompteDto compteDto) {
        try {
            String sql = "UPDATE compte SET " +
                    "idClient = ?, solde = ?, date = ?, type = ?, max = ? " +
                    "WHERE idCompte = ?";

            PreparedStatement p = cnx.prepareStatement(sql);
            p.setInt(1, compteDto.getIdClient());
            p.setDouble(2, compteDto.getSolde());
            p.setDate(3, (Date) compteDto.getDate());
            p.setInt(4, compteDto.getType());
            p.setInt(5, compteDto.getIdCompte());
            p.setFloat(6, compteDto.getMax());
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.modifyCompte() : " + e.getMessage());
        }
    }

    public void modifySolde(int idCompte, double solde) {
        try {
            String sql = "UPDATE compte SET " +
                    "solde = ? " +
                    "WHERE idCompte = ?";

            PreparedStatement p = cnx.prepareStatement(sql);
            p.setDouble(1, solde);
            p.setInt(2, idCompte);
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.modifyCompte() : " + e.getMessage());
        }
    }

    public CompteDto findCompte(int id) {
        String sql = "SELECT * FROM compte WHERE idCompte = " + id;
        ResultSet rs = getResults(sql);
        try {
            if (rs.next()) {
                return CompteDto.fromResultSet(rs);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.findCompte() : " + e.getMessage());
            return null;
        }
    }

    public ArrayList<CompteDto> findAllCompte(int idClient) {
        String sql = "SELECT * FROM compte WHERE idClient = " + idClient;
        ResultSet rs = getResults(sql);
        ArrayList<CompteDto> comptes = new ArrayList<>();
        try {
            while (rs.next()) {
                CompteDto compte = CompteDto.fromResultSet(rs);
                comptes.add(compte);
            }
            return comptes;
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.findAllCompte() : " + e.getMessage());
            return null;
        }
    }

    // #endregion compte

    // #region historique

    public void insertHistorique(HistoriqueDto historiqueDto) {
        try {
            String sql = "INSERT INTO historique " +
                    "(idCompte, date, montant) " +
                    "VALUES (?, ?, ?)";

            PreparedStatement p = cnx.prepareStatement(sql);
            p.setInt(1, historiqueDto.getIdCompte());
            p.setDate(2, (Date) historiqueDto.getDate());
            p.setDouble(3, historiqueDto.getMontant());
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.insertHistorique() : " + e.getMessage());
        }
    }

    public void modifyHistorique(HistoriqueDto historiqueDto) {
        try {
            String sql = "UPDATE historique SET " +
                    "idCompte = ?, date = ?, montant = ? " +
                    "WHERE idHist = ?";

            PreparedStatement p = cnx.prepareStatement(sql);
            p.setInt(1, historiqueDto.getIdCompte());
            p.setDate(2, (Date) historiqueDto.getDate());
            p.setDouble(3, historiqueDto.getMontant());
            p.setInt(4, historiqueDto.getIdHist());
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.modifyHistorique() : " + e.getMessage());
        }
    }

    public HistoriqueDto findHistorique(int id) {
        String sql = "SELECT * FROM historique WHERE idHist = " + id;
        ResultSet rs = getResults(sql);
        try {
            if (rs.next()) {
                return HistoriqueDto.fromResultSet(rs);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.findHistorique() : " + e.getMessage());
            return null;
        }
    }

    public List<HistoriqueDto> findAllHistorique(int idCompte) {
        String sql = "SELECT * FROM historique WHERE idCompte = " + idCompte;
        ResultSet rs = getResults(sql);
        List<HistoriqueDto> historiques = new ArrayList<HistoriqueDto>();
        try {
            while (rs.next()) {
                HistoriqueDto historique = HistoriqueDto.fromResultSet(rs);
                historiques.add(historique);
            }
            return historiques;
        } catch (Exception e) {
            System.out.println("projgl.db.dbControl.findAllHistorique() : " + e.getMessage());
            return null;
        }
    }

    // #endregion historique
}