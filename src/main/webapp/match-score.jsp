<jsp:useBean id="Matches" scope="request" type="entity.Matches"/>
<%@ page isELIgnored="false" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>match-score</title>
</head>
<body>

    <h2>Таблица с именами игроков и текущим счетом</h2>
    <table border="1">
        <tr>
            <th>Игрок</th>
            <th>Sets</th>
            <th>Games</th>
            <th>Points</th>
        </tr>
        <tr>
            <td>${Matches.player1.name}</td>
            <td>${Matches.matchScore.sets[0]}</td>
            <td>${Matches.matchScore.games[0]}</td>
            <td>${Matches.matchScore.points[0]}</td>
        </tr>
        <tr>
            <td>${Matches.player2.name}</td>
            <td>${Matches.matchScore.sets[1]}</td>
            <td>${Matches.matchScore.games[1]}</td>
            <td>${Matches.matchScore.points[1]}</td>
        </tr>
    </table>

    <form method="post">
<%--        <input type="button" value="Игрок 1 выиграл текущее очко" name="player1">--%>
<%--        <br>--%>
<%--        <input type="button" value="Игрок 2 выиграл текущее очко" name="player2">--%>

        <button name="winId" value="0" type="submit">Player 1 wins point!</button>
        <br>
        <button name="winId" value="1" type="submit">Player 2 wins point!</button>
    </form>
<%--    <form method="post">--%>
<%--        <input type="submit" value="Игрок 2 выиграл текущее очко" name="player2">--%>
<%--    </form>--%>

</body>
</html>