package Data;

public class Resultat {
	
        private Carreau carreau;
        private Joueur joueur;
        private String actionJoueur;
        
        public Resultat(){
            
        }
        
        public Carreau getCarreau() {
            return carreau;
        }

        public void setCarreau(Carreau carreau) {
            this.carreau = carreau;
        }

        public Joueur getJoueur() {
            return joueur;
        }

        public void setJoueur(Joueur joueur) {
            this.joueur = joueur;
        }

        public String getActionJoueur() {
            return actionJoueur;
        }

        public void setActionJoueur(String actionJoueur) {
            this.actionJoueur = actionJoueur;
        }
        
        
}