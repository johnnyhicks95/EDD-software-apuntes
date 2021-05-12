public class Circulo extends Figura{
    double radio, area;
    
    public Circulo( double radio){
        this.radio = radio;
    }

    @Override
    String calcularArea() {
        // double pi = Math.PI;
        area = Math.PI * Math.pow( this.radio, 2);
        return "Área del círculo es: " + area;
    }
}
