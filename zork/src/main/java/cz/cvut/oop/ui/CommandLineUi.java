package cz.cvut.oop.ui;

import cz.cvut.oop.game.Game;
import cz.cvut.oop.game.GameImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 *  Represents command line ui view
 */
public class CommandLineUi {
    private static final Logger log = LoggerFactory.getLogger(CommandLineUi.class);
    private static final CommandLineUi INSTANCE = new CommandLineUi();
    private final Game game;

    private CommandLineUi() {
        this.game = new GameImpl();
    }

    public static CommandLineUi getInstance() {
        return INSTANCE;
    }

    public void start() {
        log.info("application started");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(this.game.welcomeMessage());
            while (this.game.isFinished()) {
                System.out.print("> ");
                System.out.println(this.game.processTextCommand(scanner.nextLine()));
            }
            System.out.println(this.game.endMessage());
        }
    }
}

