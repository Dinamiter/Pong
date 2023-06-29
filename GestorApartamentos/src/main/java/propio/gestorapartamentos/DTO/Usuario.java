
package propio.gestorapartamentos.DTO;

/**
 *
 * @author anton
 */
public class Usuario {
    
    
    private int id;
    private String nom;
    private String llinarges;
    private String email;
    private String password;
    private byte idAdmin;

    public Usuario() {
    }

    public Usuario(int id, String nom, String llinarges, String email, String password, byte idAdmin) {
        this.id = id;
        this.nom = nom;
        this.llinarges = llinarges;
        this.email = email;
        this.password = password;
        this.idAdmin = idAdmin;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinarges() {
        return llinarges;
    }

    public void setLlinarges(String llinarges) {
        this.llinarges = llinarges;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(byte idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nom=" + nom + ", llinarges=" + llinarges + ", email=" + email + ", password=" + password + ", idAdmin=" + idAdmin + '}';
    }
    
    
}
