package hello;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.Driver;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class Greeting {
    private final long id;
    private final String content;

    public Greeting() {
    	this.id = 0;
    	this.content = "x";
    }
    
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The name of the user", required = true)
    public String getContent() {
        return content;
    }
    
    public String testConn() {
		String msg = "no";
    	try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			msg = "Where is your PostgreSQL JDBC Driver? "+ "Include in your library path!";
			e.printStackTrace();
			return msg;
		}
	
		Connection connection = null;
		try {
			String POSTGRESQL_SERVICE_HOST = System.getenv("POSTGRESQL_SERVICE_HOST");
			String POSTGRESQL_SERVICE_PORT = System.getenv("POSTGRESQL_SERVICE_PORT");
			String dbname = System.getenv("dbname");
			String dbuser = System.getenv("dbuser");
			String dbpassword = System.getenv("dbpassword");
			connection = DriverManager.getConnection(
					"jdbc:postgresql://" + POSTGRESQL_SERVICE_HOST + ":" + POSTGRESQL_SERVICE_PORT + "/" + dbname, 
					dbuser,dbpassword);
		} catch (SQLException e) {
			msg = "Connection Failed! Check output console";
			e.printStackTrace();
			return msg;
 
		}

		if (connection != null) {
			msg = "You made it, take control your database now!";
			try {
				Statement stmt = connection.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("SELECT Lname FROM Customers WHERE Snum = 2001");
	            while ( rs.next() ) {
	                String lastName = rs.getString("Lname");
	                System.out.println(lastName);
	            }
	            connection.close();
			}catch (Exception e) {
				msg = "Cannot select from your database now!";
			}
		} else {
			msg = "Failed to make connection!";
		}
		return msg;
    }
    /*
    public static void main(String[] args) {
    	System.out.println("xxxxxxxxxxx");
    	new Greeting().testConn();
	}
	*/
}
