package smokefree.dataservice;

//        import io.micronaut.spring.tx.annotation.Transactional;

        import javax.inject.Inject;
        import javax.inject.Singleton;
        import javax.sql.DataSource;
        import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;

        import com.mysql.cj.jdbc.MysqlDataSource;
        import io.micronaut.context.annotation.Bean;
        import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class PetService {

//    @Inject
    private MysqlDataSource dataSource;

    private Connection connection = null;
//    public PetService(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    PetService() {
        dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("lm");
        dataSource.setURL("jdbc:mysql://localhost:3306/test");
    }

    private Connection getConnection() {
        try {
            if (connection == null || !connection.isValid(5))
                connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
//    @Transactional
    public String save(String title) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String result = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select name from dimitri where id='1';");
            rs.next();
            result = rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
//                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}