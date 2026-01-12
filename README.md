# 📋 Projet de Gestion des Machines et Salles

## 📌 Aperçu du Projet
Application Java utilisant **JPA/Hibernate** pour la gestion d'un parc de machines informatiques et de leurs salles d'affectation. Le système permet de suivre l'inventaire, les dates d'achat et la localisation des équipements.

## 🏗️ Architecture des Entités

### 🖥️ Entité `Machine`
**Description** : Représente un équipement informatique (ordinateur, serveur, etc.)

**Attributs** :
- `id` : Identifiant unique auto-généré
- `ref` : Référence unique de la machine
- `dateAchat` : Date d'acquisition
- `salle` : Relation vers la salle d'affectation

**Requêtes disponibles** :
- Recherche par plage de dates (JPQL)
- Recherche par plage de dates (SQL natif)

### 🏢 Entité `Salle`
**Description** : Représente un espace physique hébergeant des machines

**Attributs** :
- `id` : Identifiant unique auto-généré
- `code` : Code d'identification de la salle
- `machines` : Liste des machines présentes

## 🔄 Relations entre Entités

```
Une SALLE → Contient → Plusieurs MACHINES
Une MACHINE → Est située dans → Une seule SALLE
```

**Type de relation** : Bidirectionnelle One-to-Many / Many-to-One

## 🗄️ Structure de la Base de Données

### Table `salles`
| Colonne | Type | Description |
|---------|------|-------------|
| id | INT | Clé primaire auto-incrémentée |
| code | VARCHAR | Code unique de la salle |

### Table `machine`
| Colonne | Type | Description |
|---------|------|-------------|
| id | INT | Clé primaire auto-incrémentée |
| ref | VARCHAR | Référence de la machine |
| date_achat | DATE | Date d'achat |
| salle_id | INT | Clé étrangère vers salles(id) |

## ⚙️ Configuration Technique

**Technologies** :
- Java Persistence API (JPA)
- Hibernate ORM
- Base de données relationnelle

**Annotations JPA utilisées** :
- `@Entity`, `@Id`, `@GeneratedValue`
- `@ManyToOne`, `@OneToMany`
- `@NamedQuery`, `@NamedNativeQuery`
- `@Temporal`, `@Table`

## 📊 Fonctionnalités Principales

1. **Gestion des Machines**
   - Création et suppression
   - Recherche par période d'achat
   - Affectation à une salle

2. **Gestion des Salles**
   - Création de nouveaux espaces
   - Consultation du parc machine par salle
   - Gestion des relations

3. **Recherche et Filtrage**
   - Recherche temporelle (machines achetées entre deux dates)
   - Requêtes optimisées (JPQL et SQL natif)

## 🎯 Cas d'Utilisation

### Scénario typique :
1. Ajouter une nouvelle salle ("LAB_INFORMATIQUE_3")
2. Enregistrer de nouvelles machines avec leurs dates d'achat
3. Affecter les machines à la salle créée
4. Consulter le parc machine par période d'acquisition
5. Exporter les données pour inventaire

## 🔧 Prérequis d'Installation

**Environnement requis** :
- JDK 8 ou supérieur
- Maven ou équivalent
- Base de données compatible JPA (MySQL, PostgreSQL, etc.)
- Serveur d'application avec support JPA

**Dépendances principales** :
- `javax.persistence-api`
- `hibernate-core`
- Driver de base de données

## 📁 Structure du Projet

```
src/
├── main/
│   ├── java/
│   │   └── entities/
│   │       ├── Machine.java
│   │       └── Salle.java
│   └── resources/
│       └── META-INF/
│           └── persistence.xml
```

## 💡 Bonnes Pratiques Implémentées

✅ **Documentation complète** des entités  
✅ **Requêtes nommées** pour les opérations fréquentes  
✅ **Relations bi-directionnelles** correctement configurées  
✅ **Stratégie de fetch** adaptée (EAGER pour les salles)  
✅ **Gestion des dates** spécifique (DATE seulement)  

## 🚀 Démonstration

<img width="954" height="539" alt="Hibernate1" src="https://github.com/user-attachments/assets/68173eb4-6517-4f27-8955-7e7ec669ad9d" />


<img width="959" height="539" alt="Hibernate2" src="https://github.com/user-attachments/assets/91f0bfda-7059-483b-813f-e64239ef4506" />


<img width="959" height="539" alt="Hibernate4" src="https://github.com/user-attachments/assets/ec389726-e48c-440e-9f87-9c7a0a20914f" />

**Auteurs** 

Réalisé par : Ettouyjer yasmine.

Encadré par : Pr.Mohamed Lechgar.
