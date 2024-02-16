import dao.PlayersDAO;
import entity.Matches;
import entity.Players;

public class MAIN {
    public static void main(String[] args) {
        Players player1 = new Players("Кеша");
        Players player2 = new Players("Владик");

        PlayersDAO playersDAO = new PlayersDAO();

        playersDAO.create(player1);
        playersDAO.create(player2);

        System.out.println(playersDAO.getByName("Кеша"));
        System.out.println(playersDAO.getByName("132"));

        Matches matches = new Matches(player1, player2);
//        matches.getMatchScore()
    }
}
