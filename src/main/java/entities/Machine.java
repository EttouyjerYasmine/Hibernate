package entities;

import java.util.Date;
import javax.persistence.*;

/**
 * Entité JPA représentant une Machine dans le système.
 * Une machine est caractérisée par une référence, une date d'achat
 * et est située dans une salle spécifique.
 */
@Entity
// Requête nommée en JPQL (Java Persistence Query Language) pour rechercher les machines par plage de dates
@NamedQuery(
        name = "findBetweenDate",
        query = "from Machine where dateAchat between :d1 and :d2"
)
// Requête nommée en SQL natif pour les mêmes fonctionnalités (alternative à JPQL)
@NamedNativeQuery(
        name = "findBetweenDateNative",
        query = "select * from machine where dateAchat between :d1 and :d2",
        resultClass = Machine.class
)
public class Machine {

    // Identifiant unique généré automatiquement par la base de données
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Référence de la machine (ex: numéro de série, code unique)
    private String ref;

    // Date d'achat de la machine
    // @Temporal précise que seul la partie date (sans l'heure) doit être persistée
    @Temporal(TemporalType.DATE)
    private Date dateAchat;

    // Relation Many-to-One : plusieurs machines peuvent se trouver dans une même salle
    // Une machine appartient à une seule salle
    @ManyToOne
    private Salle salle;

    // ===================== CONSTRUCTEURS =====================

    /**
     * Constructeur complet avec tous les attributs.
     *
     * @param id Identifiant de la machine
     * @param ref Référence de la machine
     * @param salle Salle où se trouve la machine
     * @param dateAchat Date d'achat de la machine
     */
    public Machine(int id, String ref, Salle salle, Date dateAchat) {
        this.id = id;
        this.ref = ref;
        this.salle = salle;
        this.dateAchat = dateAchat;
    }

    /**
     * Constructeur avec référence, date et salle (sans ID).
     * L'ID sera généré automatiquement par la base de données.
     *
     * @param ref Référence de la machine
     * @param dateAchat Date d'achat de la machine
     * @param salle Salle où se trouve la machine
     */
    public Machine(String ref, Date dateAchat, Salle salle) {
        this.ref = ref;
        this.dateAchat = dateAchat;
        this.salle = salle;
    }

    /**
     * Constructeur par défaut requis par JPA.
     * Utilisé par le framework lors de l'instanciation des entités.
     */
    public Machine() {
        // Constructeur vide nécessaire pour JPA
    }

    // ===================== GETTERS & SETTERS =====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}