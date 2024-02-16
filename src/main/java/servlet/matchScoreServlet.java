package servlet;

import entity.Matches;
import service.FinishedMatchesPersistenceService;
import service.MatchScoreCalculationService;
import service.OngoingMatchesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns = "/match-score")
public class matchScoreServlet extends HttpServlet {

    private final MatchScoreCalculationService matchScoreCalculationService = new MatchScoreCalculationService();
    private final FinishedMatchesPersistenceService finishedMatchesPersistenceService =
            new FinishedMatchesPersistenceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");

        Matches match = OngoingMatchesService.getCurrentMatch(uuid);

        req.setAttribute("Matches", match);
        req.getRequestDispatcher("/match-score.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        String winId = req.getParameter("winId");


        Matches match = OngoingMatchesService.getCurrentMatch(uuid);

        if (matchScoreCalculationService.isEndMatch(match)) {
            finishedMatchesPersistenceService.saveFinishedMatch(match);
            OngoingMatchesService.deleteCurMatch(uuid);
            getServletContext().getRequestDispatcher("/new-match.jsp").forward(req, resp);

        }

        int valueWinId = Integer.parseInt(winId);
        if (valueWinId == 0) {
            matchScoreCalculationService.addPoint(0, match);
            doGet(req, resp);
//            System.out.println("первый игрок");
        } else if (valueWinId == 1){
            matchScoreCalculationService.addPoint(1, match);
            doGet(req, resp);
//            System.out.println("второй игрок");
        }

    }

}
