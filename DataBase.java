import java.sql.*;

public class DataBase {

  private static DataBase instance = null;
  private String url = "jdbc:postgresql://localhost:5432/Formula1";
  private String user = "postgres";
  private String password = "337799";
  private Connection connection = null;

  private DataBase() {
    try {
      connection = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static DataBase getConnection() {
    if (instance == null) {
      instance = new DataBase();
    }
    return instance;
  }

  public void create(String dbName, String values) throws ErrorOperation {
    String query = "insert into " + dbName + values;
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      statement.execute();
    } catch (Exception e) {
      throw new ErrorOperation("Error al crear registro");
    }
  }

  public ResultSet findOne(String dbName, String numEmpleado) throws ErrorOperation {
    String query = "select * from " + dbName + " where numEmpleado = " + numEmpleado;
    ResultSet data = null;
    try {
      PreparedStatement statement = connection.prepareStatement(query);
      data = statement.executeQuery();
    } catch (Exception e) {
      throw new ErrorOperation("Error al buscar el registro con el pk " + numEmpleado);
    }
    return data;
  }
}

class ErrorOperation extends Exception {
  public ErrorOperation(String msg) {
    super(msg);
  }
}