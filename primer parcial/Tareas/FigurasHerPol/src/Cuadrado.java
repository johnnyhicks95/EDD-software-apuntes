public class Cuadrado extends Figura {
    double lado;
    
    Cuadrado( double lado ){
        this.lado = lado;
    }

    @Override
    String calcularArea() {
        return "Área del cuadrado es: "+ this.lado * this.lado;
    }
}