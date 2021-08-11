package dominio;

import java.security.AuthProvider;


public class JubiladoPatronal extends Jubilado implements Finanzas{
    private double inflacion;
    private int tipoE;
    private double pensionp;

    public JubiladoPatronal(double inflacion,int tipoE,String cedula, String nombres, int aniosAporte) {
        super(cedula, nombres, aniosAporte);
        this.inflacion=inflacion;
        this.tipoE=tipoE;
    }

    @Override
    public void calcularPension() {
        this.pensionp=getPensioni()+(getSALARIOBASE()*inflacion);
    }
    @Override
    public void bonoSueldo(){
        
        if(this.tipoE==1){
            this.pensionp=this.pensionp*1.05;
        }else{
            this.pensionp=this.pensionp*1.10;
        }
    }

    @Override
    public String toString() {
       return "\tJubilado Patronal\n"+super.toString()+"\nPension patronal:"+this.pensionp;
    }
    
    
}