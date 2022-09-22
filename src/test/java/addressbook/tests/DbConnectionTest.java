package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.testng.annotations.Test;

import java.sql.*;

public class DbConnectionTest {

    @Test
    public void testDbConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT group_name, group_id FROM group_list");
            Groups groups = new Groups();
            while (rs.next()){
                groups.add(new GroupData().withName(rs.getString("group_name")).withId(rs.getInt("group_id")));
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println(groups);
        } catch (SQLException e){
            System.out.println("SQLExeption " + e.getMessage());
        }
    }
}
