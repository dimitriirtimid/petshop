package smokefree;

import lombok.experimental.Delegate;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class SmokefreeConnection implements Connection {

    private interface Close {
        void close() throws SQLException;
    }

    @Delegate(excludes = Close.class)
    private final Connection connection;

    public SmokefreeConnection(Connection connection) {
        this.connection = connection;
    }

    public void close() throws SQLException {
        try {
            connection.close();
        }
        catch (Exception e) {
            log.debug("Quietly caught: " + e);
            // Just be quiet !
        }
    }
}
