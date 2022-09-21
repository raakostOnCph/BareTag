import DB.Facade;
import Logic.Entitet.Bog;
import Logic.util.UI;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException
    {

        List<Bog> bogList = new LinkedList<>();

        while (true) {

            switch (UI.getString("hvad ønsker du")) {

                case "opret bog":
                    Bog bog = new Bog(UI.getString("angiv title"), UI.getString("angiv forfatter"));
                     bogList.add(Facade.opretBog(bog));
                     break;
                case "udskriv bøger":
                    bogList = Facade.hentBøger();
                    UI.udskriv(bogList);
                    break;
                case "hent bøger":
                   bogList = Facade.hentBøger();
                   break;
                case "slet bog":
                    System.out.println(Facade.sletBog(UI.getInt("skriv bogId")));


            }



        }






    }


}
