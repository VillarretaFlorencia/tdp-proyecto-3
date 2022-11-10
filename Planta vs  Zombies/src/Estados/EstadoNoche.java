package Estados;

public class EstadoNoche extends Estado{
	protected String imagen;
	
	public EstadoNoche(String i) {
		imagen = i;
	}
	
	public String getImage() {
		return imagen;
	}
}
