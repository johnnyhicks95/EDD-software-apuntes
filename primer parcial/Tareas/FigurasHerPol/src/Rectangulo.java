public class Rectangulo extends Figura {
    
    double ancho, alto;

    public Rectangulo( double ancho, double alto ) {
        this.ancho = ancho;
        this.alto  = alto;
    }

    @Override
    String calcularArea() {
        return "Área del reactángulo es: " + this.ancho * this.alto;
    }
}
