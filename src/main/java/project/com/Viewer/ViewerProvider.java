package project.com.Viewer;

import project.com.Viewer.Elements.BallViewer;
import project.com.Viewer.Elements.BrickViewer;
import project.com.Viewer.Elements.PaddleViewer;
import project.com.Viewer.Game.GameBackgroundViewer;
import project.com.Viewer.MainMenu.LogoViewer;
import project.com.Viewer.MainMenu.MainMenuBackgroundViewer;
import project.com.Viewer.MainMenu.OptionViewer;

import java.io.IOException;

public class ViewerProvider {
    private final BrickViewer brickViewer;
    private final PaddleViewer paddleViewer;
    private final BallViewer ballViewer;
    private final GameBackgroundViewer gameBackground;
    private final MainMenuBackgroundViewer mainMenuBackground;
    private final TextViewer textViewer;
    private final OptionViewer optionsViewer;
    private final LogoViewer logoViewer;

    public ViewerProvider(ImageLoader imageLoader) throws IOException {
        this.brickViewer = new BrickViewer(imageLoader);
        this.paddleViewer = new PaddleViewer(imageLoader);
        this.ballViewer = new BallViewer(imageLoader);
        this.gameBackground = new GameBackgroundViewer(imageLoader);
        this.mainMenuBackground = new MainMenuBackgroundViewer(imageLoader);
        this.textViewer= new ArkanoidTextViewer();
        this.optionsViewer = new OptionViewer(textViewer);
        this.logoViewer = new LogoViewer(imageLoader);
    }

    public BrickViewer getViewer() {
        return brickViewer;
    }

    public TextViewer getTextViewer() {
        return textViewer;
    }

    public OptionViewer getOptionsViewer() {
        return optionsViewer;
    }

    public LogoViewer getLogoViewer() {
        return logoViewer;
    }

    public BrickViewer getBrickViewer() {
        return brickViewer;
    }

    public PaddleViewer getPaddleViewer() {
        return paddleViewer;
    }

    public BallViewer getBallViewer() {
        return ballViewer;
    }

    public GameBackgroundViewer getGameBackground() {
        return gameBackground;
    }

    public MainMenuBackgroundViewer getMainMenuBackground() {
        return mainMenuBackground;
    }
}