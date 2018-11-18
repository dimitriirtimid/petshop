package smokefree;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.axonframework.common.jdbc.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;

public class SmokefreeConnectionProvider implements ConnectionProvider {

    private final MysqlDataSource dataSource;
//    private Connection connection = null;

    public SmokefreeConnectionProvider()    {
        dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("lm");
        dataSource.setURL("jdbc:mysql://localhost:3306/axon");
    }
    @Override
    public Connection getConnection() throws SQLException {
//        if (connection == null || !connection.isValid(5))
//            connection = dataSource.getConnection();
//        return connection;

//        return new SmokefreeConnection(dataSource.getConnection());

        return dataSource.getConnection();
    }
}
