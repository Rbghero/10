package ru.netology.poster;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {

    @Test
    public void shouldAddNewFilmsWhenNoFilms() {
        Manager manager = new Manager();
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");

        String[] expected = {"film1", "film2", "film3"};
        String[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewFilmsToExistingFilms() {
        Manager manager = new Manager();
        String[] films = new String[]{"film1", "film2", "film3", "film4"};
        manager.setFilms(films);
        manager.addFilm("film5");
        manager.addFilm("film6");
        manager.addFilm("film7");

        String[] expected = {"film1", "film2", "film3", "film4", "film5", "film6", "film7"};
        String[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        Manager manager = new Manager();
        String[] films = new String[]{"film1", "film2", "film3", "film4", "film5"};
        manager.setFilms(films);

        String[] expected = {"film1", "film2", "film3", "film4", "film5"};
        String[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAllFilmsWhenEmptyArray() {
        Manager manager = new Manager();

        String[] expected = {};
        String[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindLastFilmsWhenEmptyArray() {
        Manager manager = new Manager();

        String[] expected = {};
        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindLastWhenDefaultLimit() {
        Manager manager = new Manager();
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        manager.addFilm("film4");
        manager.addFilm("film5");
        manager.addFilm("film6");
        manager.addFilm("film7");
        manager.addFilm("film8");
        manager.addFilm("film9");
        manager.addFilm("film10");

        String[] expected = {
                "film10",
                "film9",
                "film8",
                "film7",
                "film6",
                "film5",
                "film4",
                "film3",
                "film2",
                "film1"
        };

        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindLastWhenLessThanDefaultLimit() {
        Manager manager = new Manager();
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        manager.addFilm("film4");
        manager.addFilm("film5");
        manager.addFilm("film6");

        String[] expected = {"film6", "film5", "film4", "film3", "film2", "film1"};
        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhenLessThanDefaultLimitBoundary() {
        Manager manager = new Manager();
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        manager.addFilm("film4");
        manager.addFilm("film5");
        manager.addFilm("film6");
        manager.addFilm("film7");
        manager.addFilm("film8");
        manager.addFilm("film9");

        String[] expected = {
                "film9",
                "film8",
                "film7",
                "film6",
                "film5",
                "film4",
                "film3",
                "film2",
                "film1"
        };

        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhenMoreThanDefaultLimit() {
        Manager manager = new Manager();
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        manager.addFilm("film4");
        manager.addFilm("film5");
        manager.addFilm("film6");
        manager.addFilm("film7");
        manager.addFilm("film8");
        manager.addFilm("film9");
        manager.addFilm("film10");
        manager.addFilm("film11");
        manager.addFilm("film12");
        manager.addFilm("film13");

        String[] expected = {
                "film13",
                "film12",
                "film11",
                "film10",
                "film9",
                "film8",
                "film7",
                "film6",
                "film5",
                "film4"
        };

        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhenMoreThanDefaultLimitBoundary() {
        Manager manager = new Manager();
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        manager.addFilm("film4");
        manager.addFilm("film5");
        manager.addFilm("film6");
        manager.addFilm("film7");
        manager.addFilm("film8");
        manager.addFilm("film9");
        manager.addFilm("film10");
        manager.addFilm("film11");

        String[] expected = {
                "film11",
                "film10",
                "film9",
                "film8",
                "film7",
                "film6",
                "film5",
                "film4",
                "film3",
                "film2"
        };

        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithCustomLimit() {
        Manager manager = new Manager(5);
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        manager.addFilm("film4");
        manager.addFilm("film5");

        String[] expected = {"film5", "film4", "film3", "film2", "film1"};
        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithLessThanCustomLimit() {
        Manager manager = new Manager(5);
        manager.addFilm("film1");
        manager.addFilm("film2");

        String[] expected = {"film2", "film1"};
        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithLessThanCustomLimitBoundary() {
        Manager manager = new Manager(5);
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        manager.addFilm("film4");

        String[] expected = {"film4", "film3", "film2", "film1"};
        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithMoreThanCustomLimit() {
        Manager manager = new Manager(5);
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        manager.addFilm("film4");
        manager.addFilm("film5");
        manager.addFilm("film6");
        manager.addFilm("film7");

        String[] expected = {"film7", "film6", "film5", "film4", "film3"};
        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithMoreThanCustomLimitBoundary() {
        Manager manager = new Manager(5);
        manager.addFilm("film1");
        manager.addFilm("film2");
        manager.addFilm("film3");
        manager.addFilm("film4");
        manager.addFilm("film5");
        manager.addFilm("film6");

        String[] expected = {"film6", "film5", "film4", "film3", "film2"};
        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }
}