package Estados;

public class EstadoNoche extends Estado{
	protected String imagen;
	
	public EstadoNoche() {
		imagen = null;
	}
	
	public String getImage() {
		return imagen;
	}
	public void setImage(String i) {
		imagen = i;
	}
}
