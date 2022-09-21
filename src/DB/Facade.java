package DB;

import Logic.Entitet.Bog;

import java.sql.SQLException;
import java.util.List;

public class Facade
{



    public static Bog opretBog(Bog bog ) throws SQLException
    {

        return BogMapper.opretBog(bog);
    }

    public static List<Bog> hentBøger() throws SQLException
    {
       return BogMapper.hentAllebøger();
    }

    public static String sletBog(int  bogId) throws SQLException
    {
        return BogMapper.sletBog(bogId);
    }


}
