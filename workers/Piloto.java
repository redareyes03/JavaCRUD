package workers;

public class Piloto extends Workers {
  private int numPiloto;
  private int victorias;
  private String nacionalidad;

  public Piloto(String nombre, int edad, float salario, String numEmpleado, int numPiloto, int victorias,
      String nacionalidad) {
    super(nombre, edad, salario, numEmpleado);
    this.numPiloto = numPiloto;
    this.victorias = victorias;
    this.nacionalidad = nacionalidad;
  }

  public int getNumPiloto() {
    return this.numPiloto;
  }

  public int getVictorias() {
    return this.victorias;
  }

  public String getNacionalidad() {
    return this.nacionalidad;
  }

  @Override
  public String getQueryValues() {
    return "(edad, nombre, salario, numEmpleado, numPiloto, victorias, nacionalidad) values (" +
        this.getEdad() + ", " +
        "'" + this.getNombre() + "' , " +
        this.getSalario() + ", " +
        this.getNumEmpleado() + ", " +
        this.getNumPiloto() + ", " +
        this.getVictorias() + ", " +
        "'" + this.getNacionalidad() + "' );";
  }
}