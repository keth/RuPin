package is.ru.honn.rupin.data;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * User: kristjant08@ru.is
 * Kristján Eldjárn Þóroddsson
 * Date: 18.11.2012
 * Time: 00:33
 */
public class FollowRowMapper implements ParameterizedRowMapper<String>{



    public String mapRow(ResultSet resultSet, int i) throws SQLException

  {

    return resultSet.getString("follows");

  }

}
