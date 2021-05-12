public class App {
    public static void main(String[] args) throws Exception {
        GestorFiguras gestFig = new GestorFiguras();

        // gestFig.figuras[0] = new Cuadrado(3);
        // gestFig.figuras[1] = new Rectangulo(3, 4);
        // gestFig.figuras[2] = new Circulo(4.5);

        gestFig.insertar( new Cuadrado(3) );
        gestFig.insertar( new Rectangulo(3, 4) );
        gestFig.insertar( new Circulo(4.5) );

        System.out.println("Áreas:");
        gestFig.imprimeAreaFiguras();
    }
}
