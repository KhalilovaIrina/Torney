package ru.netology;
import java.util.HashMap;

public class Game {
    private HashMap<String, Integer> map = new HashMap<>();

    public void register(Player player) {
        String tmpName = player.getName();
        for (String tmp : map.keySet()) {
            if (tmpName == tmp) {
                throw new AlreadyExistsException(
                        "Объект с данным именем уже зарегистрирован: " + tmpName
                );
            }
        }
        map.put(player.getName(), player.getStrength());

    }

    public int round(String playerName1, String playerName2) {
        if (map.containsKey(playerName1) == false | map.containsKey(playerName2) == false) {
            throw new NotRegisteredException(
                    "В игре могут принимать участие только зарегистрированные пользователи"
            );
        }

        int v = map.get(playerName1);
        int v2 = map.get(playerName2);

        if (v > v2) {
            return 1;
        } else if (v < v2) {
            return 2;
        } else {
            return 0;
        }
    }


}

