public class GestorFiguras {
    Figura[] figuras;
    final int CANT_FIGURAS = 5;

    GestorFiguras(){
        figuras = new Figura[this.CANT_FIGURAS];
    }

    boolean insertar(Figura figura){
        boolean insertado = false;
        int pos = 0;
        while (!insertado && pos < this.figuras.length){
            if ( this.figuras[ pos ] == null ){
                this.figuras[ pos ] = figura;
                return true;
            }
            pos ++;
        }
        return false;
    }

    public void imprimeAreaFiguras(){
        // String msg= "Área es igual:";
        for (Figura figura : this.figuras) {
            if (figura != null) {
                System.out.println(figura.calcularArea());;
            }
        }
    }

}
