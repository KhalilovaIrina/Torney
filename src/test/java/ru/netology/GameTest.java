package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Rocket", 1);
    Player player2 = new Player(2, "Galaxy", 2);
    Player player3 = new Player(3, "Space", 2);
    Player player4 = new Player(4, "Negative", -1);
    Player player5 = new Player(5, "Space", 4);

    @Test
    public void shouldFindIfWinnerFirst() {
        game.register(player1);
        game.register(player2);
        game.register(player3);


        int expected = 1;
        int actual = game.round("Galaxy", "Rocket");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindIfWinnerSecond() {
        game.register(player1);
        game.register(player2);
        game.register(player3);


        int expected = 2;
        int actual = game.round("Rocket", "Galaxy");

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldFindIfEquals() {
        game.register(player1);
        game.register(player2);
        game.register(player3);


        int expected = 0;
        int actual = game.round("Galaxy", "Space");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindIfOneNoRegister() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Rocket", "Space"));
    }

    @Test
    public void shouldFindIfNoOneRegister() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Настоящий детектив", "Черная весна"));
    }

    @Test
    public void shouldTrowIfAlreadyExist() {
        game.register(player1);
        game.register(player3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> game.register(player5));
    }

    @Test
    public void shouldRegisterWithZeroIfStrenghtNegative() {
        game.register(player1);
        game.register(player2);
        game.register(player4);


        int expected = 1;
        int actual = game.round("Galaxy", "Negative");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWinnerIfEmpty() {

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Galaxy", "Rocket"));
    }

    @Test
    public void shouldFindWinnerIfOne() {
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Galaxy", "Rocket"));
    }

}
