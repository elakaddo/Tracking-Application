# 📦 Shipment Tracking System

Bienvenue dans l'application **Shipment Tracking** ! Ce projet est une API Spring Boot robuste connectée à une base de données PostgreSQL, le tout orchestré avec Docker pour vous garantir une installation fluide et isolée. 🚀

---

## 🏗️ Architecture du Projet

Le projet s'articule autour de trois services principaux :
* ☕ **Backend** : Application Spring Boot (Java 21).
* 🐘 **Database** : PostgreSQL (version Alpine pour la légèreté).
* 🌐 **Frontend** : Interface utilisateur (actuellement en cours de développement).

---

## 🚀 Comment lancer l'application ?

Vous disposez de deux méthodes pour faire fonctionner le projet selon vos besoins : le mode **Hybride** (idéal pour le développement actif) et le mode **Full Docker** (pour une démonstration complète).

### 🛠️ 1. Mode Développement (Hybride : IDE + Docker)
*C'est le mode recommandé pour modifier le code source. Vous lancez la base de données via Docker et votre code Java directement dans votre IDE (IntelliJ, Eclipse, VS Code).*

1.  **Démarrer uniquement la base de données :**
    Ouvrez votre terminal à la racine du projet et saisissez :
    ```bash
    docker-compose up -d postgres
    ```
    *(Cette commande expose le port `5432` sur votre `localhost`).*

2.  **Configuration Spring :**
    Assurez-vous que votre fichier `src/main/resources/application.properties` pointe bien vers `localhost` :
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/shipment_tracking
    spring.datasource.username=admin
    spring.datasource.password=admin123
    ```

3.  **Lancer l'application :**
    Exécutez la classe `ShipmentApplication.java` depuis votre IDE. L'API sera alors disponible sur : `http://localhost:8080` 🌐

---

### 🐳 2. Mode Full Docker (Conteneurisation totale)
*Utilisez ce mode pour tester l'application dans un environnement de production simulé.*

1.  **Compiler et lancer l'ensemble des services :**
    ```bash
    docker-compose up --build
    ```
    *Note : L'option `--build` garantit que vos dernières modifications de code sont bien intégrées à l'image du conteneur.*

2.  **Accès aux services :**
    * **API Backend** : `http://localhost:8080`
    * **PostgreSQL** : Accessible sur le port `5432` de votre machine.

---

## 🛠️ Outils & Commandes Utiles

| Action | Commande |
| :--- | :--- |
| **Arrêter tous les services** | `docker-compose down` |
| **Réinitialisation totale (Vider la DB)** | `docker-compose down -v` |
| **Consulter les logs du Backend** | `docker logs -f shipment-api` |
| **Accéder à la console SQL (CLI)** | `docker exec -it shipment-postgres psql -U admin -d shipment_tracking` |

---

## ⚙️ Prérequis système
* ☕ **Java 17 ou supérieur**
* 🐳 **Docker & Docker Compose**
* 📦 **Maven** (utilisé pour la gestion des dépendances)

---

## 🗃️ Schéma de la Base de Données
Le projet utilise Hibernate en mode `ddl-auto=update`. Par conséquent, les tables (notamment la table `shipment`) sont générées automatiquement lors du premier démarrage réussi de l'application.

---
✨ *Développé avec rigueur par Elakaddo.* ✨