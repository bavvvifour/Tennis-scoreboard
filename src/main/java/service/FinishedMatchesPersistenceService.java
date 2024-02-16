package service;

import dao.MatchesDAO;
import entity.Matches;

public class FinishedMatchesPersistenceService {
    private MatchesDAO matchDAO = new MatchesDAO();

    public void saveFinishedMatch(Matches match) {
        matchDAO.create(match);
    }
}
