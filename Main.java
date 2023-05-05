public class Main {
  public static void main(String[] args) {
    DataBase db = DataBase.getConnection();

    String nombre, nacionalidad, edad, victorias, salario, numEmpleado, numPiloto, departamento, seccion, area;

    // TODO hacer el menu para seleccionar que se desea hacer (crear, leer,
    // actualizar, borrar)

    // Cada dato se asignaría usando la función reqString de la clase InputUtils
    nombre = InputUtils.reqString("Nombre: ");
    edad = InputUtils.reqString("Edad: ");
    salario = InputUtils.reqString("Salario: ");
    numEmpleado = InputUtils.reqString("# de empleado: ");
    numPiloto = InputUtils.reqString("# de piloto: ");
    victorias = InputUtils.reqString("# de victorias: ");
    nacionalidad = InputUtils.reqString("Nacionalidad: ");

    // Si selecciona Crear => Crear Piloto. Se crearía de la siguiente forma
    Piloto piloto = new Piloto(nombre, edad, salario, numEmpleado, numPiloto, victorias, nacionalidad);

    try {
      db.create("pilotos", piloto.getQueryValues());
    } catch (ErrorOperation e) {
      System.out.println(e);
    }
  }
}
