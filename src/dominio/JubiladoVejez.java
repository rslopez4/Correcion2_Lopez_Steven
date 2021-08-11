package dominio;


public class JubiladoVejez extends Jubilado{
    private double pensionv;

    public JubiladoVejez(String cedula, String nombres, int aniosAporte) {
        super(cedula, nombres, aniosAporte);
    }

    @Override
    public void calcularPension() {
        this.pensionv= getPensioni()+(getSALARIOBASE()*0.15);
    }

    @Override
    public String toString() {
        return "\tJubilados por vejez\n"+super.toString()+"\nPension Vejez: "+this.pensionv;
    } 
    
}