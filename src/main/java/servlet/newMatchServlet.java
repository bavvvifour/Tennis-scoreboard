package servlet;

import dao.MatchesDAO;
import dao.PlayersDAO;
import entity.Matches;
import entity.Players;
import service.OngoingMatchesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/new-match")
public class newMatchServlet extends HttpServlet {
    private final PlayersDAO playersDAO = new PlayersDAO();
    private final MatchesDAO matchesDAO = new MatchesDAO();
    private final OngoingMatchesService ongoingMatchesService = new OngoingMatchesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/new-match.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String player1 = req.getParameter("player1");
        String player2 = req.getParameter("player2");
//        String btn = req.getParameter("btn");

        if (playersDAO.getByName(player1) == null) {
            playersDAO.create(new Players(player1));
        }
        if (playersDAO.getByName(player2) == null) {
            playersDAO.create(new Players(player2));
        }

        Players playerFirst = playersDAO.getByName(player1);
        Players playerSecond = playersDAO.getByName(player2);

        Matches match = new Matches(playerFirst, playerSecond);
        matchesDAO.create(match);
        UUID uuid = UUID.randomUUID();

        ongoingMatchesService.addNewMatch(uuid, match);

        resp.sendRedirect("/match-score?uuid=" + uuid);
    }

}
