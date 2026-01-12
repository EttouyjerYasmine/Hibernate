package entities;

import java.util.List;
import javax.persistence.*;

/**
 * Entité JPA représentant une Salle dans le système.
 * Une salle est identifiée par un code unique et peut contenir
 * plusieurs machines. Cette entité est mappée sur la table "salles"
 * dans la base de données.
 */
@Entity
// Spécifie le nom de la table dans la base de données
@Table(name = "salles")
public class Salle {

    /**
     * Identifiant unique de la salle.
     * Généré automatiquement par la base de données (auto-increment).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Code unique identifiant la salle.
     * Exemple : "A101", "B203", "LaboInfo1"
     */
    private String code;

    /**
     * Relation One-to-Many avec l'entité Machine.
     * Une salle peut contenir plusieurs machines.
     *
     * mappedBy = "salle" : indique que la relation est gérée par
     * l'attribut "salle" dans la classe Machine.
     *
     * FetchType.EAGER : les machines sont chargées immédiatement
     * avec la salle (contrairement au LAZY qui charge à la demande).
     */
    @OneToMany(mappedBy = "salle", fetch = FetchType.EAGER)
    private List<Machine> machines;

    // ===================== CONSTRUCTEURS =====================

    /**
     * Constructeur par défaut requis par JPA/Hibernate.
     * Utilisé lors de la désérialisation des entités.
     */
    public Salle() {
        // Constructeur vide nécessaire pour JPA/Hibernate
    }

    /**
     * Constructeur complet avec tous les attributs.
     *
     * @param id Identifiant de la salle
     * @param code Code de la salle
     * @param machines Liste des machines présentes dans la salle
     */
    public Salle(int id, String code, List<Machine> machines) {
        this.id = id;
        this.code = code;
        this.machines = machines;
    }

    /**
     * Constructeur simplifié pour créer une salle avec seulement son code.
     * Utile pour les tests ou les créations rapides sans liste de machines.
     *
     * @param code Code de la salle
     */
    public Salle(String code) {
        this.code = code;
    }

    // ===================== GETTERS & SETTERS =====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }
}