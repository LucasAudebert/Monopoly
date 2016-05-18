package Data;

public class ResultatLoyer extends Resultat {
	private int loyer;
	private String nomProprio;

        public int getLoyer() {
            return loyer;
        }

        public void setLoyer(int loyer) {
            this.loyer = loyer;
        }

        public String getNomProprio() {
            return nomProprio;
        }

        public void setNomProprio(String nomProprio) {
            this.nomProprio = nomProprio;
        }

	public ResultatLoyer(int l, String nomP) {
		throw new UnsupportedOperationException();
	}
}