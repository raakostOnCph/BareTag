package DB;

import Logic.Entitet.Bog;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BogMapper
{
    protected static Bog opretBog(Bog bog) throws SQLException
    {

        String sql = "INSERT INTO Bog (Forfatter , Title ) VALUES (?, ?)";

        try (Connection con = ConnectionConfiguration.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            try {
                ps.setString(1, bog.getForfatter());
                ps.setString(2, bog.getTitle());

                ps.executeUpdate();

                ResultSet resultSet = ps.getGeneratedKeys();

                resultSet.next();
                int bogId = resultSet.getInt(1);

                bog.setBogId(bogId);

                return bog;
            } catch (SQLException e) {
                e.printStackTrace();
            }


            return bog;

        }


    }


    public static List<Bog> hentAllebøger() throws SQLException
    {

        List<Bog> bogList = new LinkedList<>();
        String sql = "select *  from Bog";

        try (Connection con = ConnectionConfiguration.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int idBog = resultSet.getInt("idBog");
                String forfatter = resultSet.getString("Forfatter");
                String title = resultSet.getString("Title");


                Bog bog = new Bog(title, forfatter, idBog);
                bogList.add(bog);
            }

        }

        return bogList;


    }

    public static String sletBog(int bogId) throws SQLException
    {
        String sql = "delete from Bog where idBog = ?";

        try (Connection con = ConnectionConfiguration.getConnection(); PreparedStatement ps = con.prepareStatement(sql);

        ) {
            ps.setInt(1, bogId);

            int res = ps.executeUpdate();

            if (res > 0) {

                return "Boget med  id " + "\"" + bogId + "\"" + " er nu blevet slettet";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return "en kunde med navnet " + "\"" + bogId + "\"" + " fandtes ikke i listen";


    }


}


