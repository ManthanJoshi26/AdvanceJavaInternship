package classes;

import java.sql.*;

public class Insert {

    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "root1234");
            Statement st = connection.createStatement();

//            PreparedStatement stmt=connection.prepareStatement("insert into books values(?,?,?)");
//            stmt.setInt(1,106);
//            stmt.setString(2,"Balagurusamy");
//            stmt.setFloat(3,(float) 185.75);
//
//            int i = stmt.executeUpdate();
//            if (i==1) System.out.println("Insert operation successful");
//
//            PreparedStatement up=connection.prepareStatement("UPDATE `books` SET name=? WHERE bid=?");
//            up.setString(1,"E Balagurusamy");
//            up.setInt(2,105);
//
//            int j=up.executeUpdate();
//            if(j==1) System.out.println("Update Operation Successful");
//

//            PreparedStatement del=connection.prepareStatement("delete from books where bid=? ");
//            del.setInt(1,106);
//
//            int k=del.executeUpdate();
//            if(k==1) System.out.println("Delete Operation Successful");
//
          ResultSet rs2 = st.executeQuery("select * from books");

            System.out.println("------------------------------------------------------------------------------------------------");
            while (rs2.next()) {
                System.out.println(rs2.getInt(1) + "|" + rs2.getString(2) + "|" + rs2.getFloat(3));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


