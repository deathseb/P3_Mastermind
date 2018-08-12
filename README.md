# P3 - Mastermind

### 2018-08-12 - OFA corrections

* Il faut déclarer dans Eclipse le chemin vers le répertoire contenance les ressources nommé "resources" (en anglais).

cf le screenshot nommé [Screenshot](./resources/docs/screenshots/RunAsConfiguration.png) pour en savoir plus.

* La configuration locale par défaut et fr_FR et s'obtient par la méthode statique nommée Locale.getDefault();

* La structure en package permet de dissocier les vues (ihm ou views), du modèle de données (model) et de la logique du programme (controller).
    ** Ce sera utile pour la suite et notamment le pattern MVC (modèle-vue-controleur)
    
* Le nom des classes héritant d'un objet graphique peuvent commencer par le nom de cet objet graphique afin de les repérer plus facilement.

* Il est mieux pour la classe Mastermind, laquelle contient une méthode public static main(String[] args) d'hériter de JFrame.

* Il faur mettre des commentaires simples et Javadocs autant que possible : ce sera plus facile pour e relire...