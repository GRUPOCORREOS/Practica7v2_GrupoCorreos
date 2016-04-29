
public class Equipo {

    private String nombre="";
    private String apellido1="";
    private String titulacion1="";
    private String apellido2="";
    private String titulacion2="";
    private String telecontacto="";
    private String emailcontacto="";

    public Equipo(String nombre, String apellido1, String titulacion1, String apellido2, String titulacion2, String telecontacto, String emailcontacto){

        this.nombre=nombre;
        this.apellido1=apellido1;
        this.titulacion1=titulacion1;
        this.apellido2=apellido2;
        this.titulacion2=titulacion2;
        this.telecontacto=telecontacto;
        this.emailcontacto=emailcontacto;

    }

    public String imprimir (){

        String cadena="\""+nombre+"\","+"\"" + apellido1+"\","+"\""+titulacion1+"\","+"\"" +apellido2+"\","+ "\""+titulacion2+"\","+"\""+telecontacto+"\",\""+emailcontacto+"\"";
        return cadena;

    }

}
