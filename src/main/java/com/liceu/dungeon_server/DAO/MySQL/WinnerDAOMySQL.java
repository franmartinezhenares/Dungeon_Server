package com.liceu.dungeon_server.DAO.MySQL;

import com.liceu.dungeon_server.DAO.WinnerDAO;
import com.liceu.dungeon_server.model.Winner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.liceu.dungeon_server.DAO.MySQL.MySqlDatabase.getConnection;

public class WinnerDAOMySQL implements WinnerDAO {
    public static List<Winner> winnersList = new ArrayList<>();

    @Override
    public void insert(Winner winner) {
        try {
            Connection con = getConnection();
            String query = "insert into winners (name, mazeid, time) values (?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, winner.getWinnerName());
            preparedStatement.setInt(2, (int)winner.getMazeSolved());
            preparedStatement.setInt(3, (int) winner.getTime());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                winner.setWinnerId(id);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        winnersList.add(winner);
    }

    @Override
    public List<Winner> getWinnersList() {
        Collections.sort(winnersList);
        return winnersList;
    }
}
