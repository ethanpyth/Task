# Task

Task is an application that helps me to have a better understanding of the Room database and MVVM architecture. Here is a briefing of what I learned when I was creating this application

## Room

Room est une librairie de jetpack qui permet la persistence des données et qui se met au dessus de SQLite, ainsi nous avons les avantages liés à SQLite tout en écrivant un code simple.

***************MVVM(Model View ViewModel)*************** est un motif de conception architectural utilisé pour organiser ou structure une application.

### Room utilise le MVVM

Toutes les applications utilisant la librairie Room sont construites suivant l’architecture MVVM, qui est comme suit: 

- ************view :************ incluent tout le code concernant le UI
- **********************ViewModel :********************** responsable de la logique métier et des données sur les vues
- ****************Model :**************** qui concernent les données relatifs à l’application

### Création de la base de données ROOM

Room utilise un ensemble d’annotations de classes et interfaces pour créer et configurer une base de données SQL. Il requiert trois choses principales :

- une classe de base de données : il définit une base de données, le nom et le numéro de version. Il permet également de recupérer une instance de base de données
- les classes de données pour les tables : toutes les données sont stockées dans des tables, ces tables sont définies au moyen de classes de données, comportant des annotations pour spécifier le nom de la table ainsi que les colonnes.
- les interfaces pour l’accès aux données : l’intéraction avec chaque table se fait au moyen d’une interface, qui spécifie les méthodes d’accès aux données dont l’application a besoin.

ces trois élements sont utilisés pour génerer tout le code nécessaire à la création et l’accèssibilité à la base de données.

#### Définition des tables

la définition de table se fait au moyen des annotations de classes de données, qui doit comporter des propriétés pour chaque colonne et les annotations pour définir la configuration de la table.

Le nom de la table est défini en ajoutant l’annotation `@Entity` à la classe de données 

La clé primaire est défini avec l’annotation `@PrimaryKey` 

Les noms des colonnes sont définis avec l’annotation `@ColumnInfo` , il n’est à spécifié que si nous voulons définir un nom de colonne différent du nom de la propriété de la classe de données, dans le cas contraire le nom de la colonne sera le meme que le nom de la propriété de la classe de données.

### Utilisation d’une interface pour les opérations sur les données

L’accès aux données est défini en créant une interface annoté, communement appelé un *DAO(Data Access Object)* qui comportera toutes les méthodes dont l’application a besoin pour effectuer un *CRUD.*

l’annotation `@Dao` permet définir une interface d’accès aux données d’une table.

| annotation de méthodes | spécification de l’annotation | exemple  |
| --- | --- | --- |
| @Insert | permet de génerer tout le code nécessaire à l’enregistrement de nouvelles données.
Peut faire l’enregistrement d’une ou plusieurs entrées dans la base de données | @Insert
fun insert(task: Task) |
| @Update | permet de mettre à jour une ligne dans la base de données | @Update
fun update(task: Task) |
| @Delete | permet de supprimer une entrée spécifique de la base de données | @Delete
fun Delete(task: Task) |
| @Query | permet d’écrire une requete sql spécifique  |  |

### Création de la base de données

La base de données est défini au moyen d’une classe abstraite, qui va specifier le nom ainsi que le numéro de version. Elle doit également etre marquée par l’annotation `@Database` qui permet de spécifier que c’est la base de données, cette annotation comporte trois arguments:

- ***************entities*************** qui spécifie n’importe quel classe qui définit les tables à ajouter à la base de données
- *********************version********************* qui est un entier spécifiant la version de la base de données
- ************************************exportSchema************************************ qui spécifie à room d’importer le schéma de la base de données d’un dossier

### Ajouter les propriétés pour chaque DAO

Il est nécessaire de spécifier les interfaces ayant l’annotation `@Dao` qui sera utilisé pour l’accès aux données. Pour cela il faut ajouter une propriété pour chaque interface
