abstract class Workers {
  private String nombre;
  private String edad;
  private String salario;
  private String numEmpleado;

  public Workers(String nombre, String edad, String salario, String numEmpleado) {
    this.nombre = nombre;
    this.edad = edad;
    this.salario = salario;
    this.numEmpleado = numEmpleado;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getEdad() {
    return this.edad;
  }

  public String getSalario() {
    return this.salario;
  }

  public String getNumEmpleado() {
    return this.numEmpleado;
  }

  public abstract String getQueryValues();
}
