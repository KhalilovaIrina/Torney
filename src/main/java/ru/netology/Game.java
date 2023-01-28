package ru.netology;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        String tmpName = player.getName();
        if (findByName(tmpName) != null) {
            throw new AlreadyExistsException(
                    "Объект с данным именем уже зарегистрирован: " + tmpName
            );
        } else {
            players.add(player);
        }
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null | player2 == null) {
            throw new NotRegisteredException(
                    "В игре могут принимать участие только зарегистрированные пользователи");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }


}

