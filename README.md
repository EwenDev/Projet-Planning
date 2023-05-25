<div align="center">
  <h1>PROJET PLANNING</h1>
  <img src="https://img.shields.io/badge/Java-000000?style=for-the-badge&logo=intellijidea&logoColor=white"/>
  <img src="https://img.shields.io/badge/JavaFX-1572B6?style=for-the-badge&logo=css3&logoColor=white"/>
</div>

## À propos

Ce projet de développement/IHM avait pour but de réaliser une application permettant de réaliser des réservations sur un planning depuis une interface graphique JavaFX.

## Contenu

Ce projet contient :
- Un répertoire [/src/main/java](src/main/java/) dans lequel sont rangés les composantes d'une architecture MVC

  - [/modele](src/main/java/modele/) contient toutes les classes java permettant de faire fonctionner les réservations dans le planning.
  - [/vue](src/main/java/vue/) contient toutes les classes qui gèrent l'interface graphique, contenant trois composantes qui gèrent respectivement : l'affichage du mois en cours, le formulaire pour faire une réservation, le tableau avec le planning de la semaine selectionner. Le répertoire contient également d'autres classes non utilisées dans la version finale de l'application.
  - [/controleur](src/main/java/controleur/) contient la classe qui met en relation la vue et le modèle avec la gestion des inputs utilisateur.
  - [/outils](src/main/java/outils/) contient la classe de lecture et d'écriture dans un fichier de sauvegarde

- Un répertoire [/sauvegarde](sauvegarde) contenant le fichier de sauvegarde du planning de l'application, géré dans la classe [LectureEcriture](src/main/java/outils/LectureEcriture.java)

- Un répertoire [/css](css) contenant le fichier css permettant de mettre en forme l'application JavaFX

- Un répertoire [/docs](docs) contenant la [JavaDoc](docs/index.html) de l'application

- Un diagramme des classes disponible en [.png](DIAGRAMME-DES-CLASSES.png) et en [.uml](DIAGRAMME.uml) (IntelliJ)

## Fonctionnalités

Cette application a pour but la gestion d'un planning de réservations. 

Elle permet donc de créer des réservations à partir d'un formulaire en GridPane JavaFX permettant d'entrer un intitulé de réservation, un niveau et une plage horaire. 

Ces réservations sont directement disponibles dans le tableau TableView de JavaFX qui affiche les réservations de la semaine selectionnée sur le TilePane affichant le calendrier du mois sélectionné avec les boutons juste au-dessus. 

Toutes les réservations sont enregistrées dans un fichier et pourront être visibles lors d'une nouvelle exécution de l'application.

Pour plus de précisions sur les classes et les méthodes de l'application, rendez-vous sur la [documentation](docs/index.html) générée par la JavaDoc.

## Comment utiliser ?

Pour lancer l'application, il suffit d'exécuter le fichier java [Projet2Application.java](src/main/java/vue/Projet2Application.java) et l'application se lancera.

Une fois une l'application, selectionnez une date sur le calendrier à gauche, et changez de mois en cliquant sur les boutons au dessus de calendrier.

Une fois la date selectionnée, remplissez le formulaire en veillant à respecter les conditions validité (deux réservations ne peuvent pas se chevaucher, une réservation fait obligatoirement plus d'une heure, tous les champs doivent être remplis).

Les réservations du planning sont visibles dans le tableau à droite où, en selectionnant un jour sur le calendrier, vous pourrez voir toutes les réservations de la semaine courante.

## Crédits
Projet réalisé par :
- [Ewen GILBERT](https://github.com/EwenDev)

Ce projet a été réalisé dans le cadre des cours lors du second semestre de BUT Informatique à l'IUT de Vélizy.