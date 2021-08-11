
package dominio;

public class JubiladoDiscapacidad extends Jubilado{
    private double porcentaje;
    private double pensiond;

    public JubiladoDiscapacidad(double porcentaje ,String cedula, String nombres, int aniosAporte) {
        super(cedula, nombres, aniosAporte);
        this.porcentaje=porcentaje;
    }

    @Override
    public void calcularPension() {
        this.pensiond= getPensioni()+(getSALARIOBASE()*this.porcentaje);//pocentaje
        
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public double getPensiond() {
        return pensiond;
    }

    @Override
    public String toString() {
        return "\tJubilado dicapacidad\n"+super.toString()+"\nPorcentaje discapacidad: "+this.porcentaje+"\nPension discapacidad:  "+this.pensiond;
    }
      
}