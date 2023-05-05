import workers.*;

public class Main {
  public static void main(String[] args) {
    DataBase db = DataBase.getConnection();

    String nombre, nacionalidad, numEmpleado, departamento, seccion, area;
    int edad, numPiloto, victorias;
    float salario;

    nombre = InputUtils.reqString("Nombre: ");
    edad = InputUtils.reqInt("Edad: ");
    salario = InputUtils.reqFloat("Salario: ");
    numEmpleado = InputUtils.reqString("# de empleado: ");
    numPiloto = InputUtils.reqInt("# de piloto: ");
    victorias = InputUtils.reqInt("# de victorias: ");
    nacionalidad = InputUtils.reqString("Nacionalidad: ");

    Piloto piloto = new Piloto(nombre, edad, salario, numEmpleado, numPiloto, victorias, nacionalidad);

    try {
      db.create("pilotos", piloto.getQueryValues()); // CREAR piloto
      db.findOne("pilotos", numEmpleado); // BUSCAR piloto por numEmpleado
    } catch (ErrorOperation e) {
      System.out.println(e);
    }
  }
}
