package Data;

public class ResultatAchat extends Resultat {
	private boolean peutAcheter;
	private int prixCarreau;

        public boolean isPeutAcheter() {
            return peutAcheter;
        }

        public void setPeutAcheter(boolean peutAcheter) {
            this.peutAcheter = peutAcheter;
        }

        public int getPrixCarreau() {
            return prixCarreau;
        }

        public void setPrixCarreau(int prixCarreau) {
            this.prixCarreau = prixCarreau;
        }

	public ResultatAchat(boolean pA, String nomC, int prixC) {
		throw new UnsupportedOperationException();
	}
}