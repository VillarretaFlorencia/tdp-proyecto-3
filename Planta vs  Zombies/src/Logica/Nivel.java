package Logica;

public class Nivel {
    private Entidad[][] nivel = new Entidad[10][6];
    
    public Nivel(){
        for(int x = 0; x<10; x++){
            for(int y = 0; y<6; y++){
                nivel[x][y]= new Celda();
            }
        }
    }

    public void modificar(int x, int y, Entidad ent){
        nivel[x][y] = ent;
    }
    
    public int getColumnas(){
        return nivel[0].length;
    }
    public int getFilas(){
        return nivel.length;
    }
    public Entidad getEntidad(int x, int y){
    return nivel[x][y];
    }
}
