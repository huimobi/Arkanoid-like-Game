package project.com.Viewer;

import project.com.Viewer.Elements.*;
import project.com.Viewer.Game.GameBackgroundViewer;
import project.com.Viewer.Game.HighScoreViewer;
import project.com.Viewer.Game.RoundViewer;
import project.com.Viewer.Info.*;
import project.com.Viewer.Game.ScoreViewer;
import project.com.Viewer.MainMenu.LogoViewer;
import project.com.Viewer.MainMenu.MainMenuBackgroundViewer;
import project.com.Viewer.MainMenu.OptionViewer;
import project.com.Viewer.Sprite.ImageLoader;
import project.com.Viewer.Text.ArkanoidTextViewer;
import project.com.Viewer.Text.TextViewer;

import java.io.IOException;

public class ViewerProvider {
    private final BrickViewer brickViewer;
    private final PaddleViewer paddleViewer;
    private final BallViewer ballViewer;
    private final LivesViewer livesViewer;
    private final GameBackgroundViewer gameBackground;
    private final MainMenuBackgroundViewer mainMenuBackground;
    private final TextViewer textViewer;
    private final OptionViewer optionsViewer;
    private final LogoViewer logoViewer;
    private final RoundViewer roundViewer;
    private final InformationsViewer informationsViewer;
    private final WordInfoViewer wordInfoViewer;
    private final LeftViewer leftViewer;
    private final RightViewer rightViewer;
    private final ESCViewer escViewer;
    private final EnterViewer enterViewer;
    private final ScoreViewer scoreViewer;
    private final PowerUpViewer powerUpViewer;
    private final HighScoreViewer highScoreViewer;


    public ViewerProvider(ImageLoader imageLoader) throws IOException {
        this.brickViewer = new BrickViewer(imageLoader);
        this.paddleViewer = new PaddleViewer(imageLoader);
        this.ballViewer = new BallViewer(imageLoader);
        this.gameBackground = new GameBackgroundViewer(imageLoader);
        this.mainMenuBackground = new MainMenuBackgroundViewer(imageLoader);
        this.textViewer= new ArkanoidTextViewer();
        this.optionsViewer = new OptionViewer(textViewer);
        this.logoViewer = new LogoViewer(imageLoader);
        this.informationsViewer = new InformationsViewer(textViewer);
        this.wordInfoViewer = new WordInfoViewer(imageLoader);
        this.leftViewer = new LeftViewer(imageLoader);
        this.rightViewer = new RightViewer(imageLoader);
        this.escViewer = new ESCViewer(imageLoader);
        this.enterViewer = new EnterViewer(imageLoader);
        this.scoreViewer=new ScoreViewer(textViewer);
        this.highScoreViewer=new HighScoreViewer(textViewer);
        this.powerUpViewer= new PowerUpViewer(imageLoader);
        this.livesViewer=new LivesViewer(imageLoader);
        this.roundViewer=new RoundViewer(textViewer);
    }

    public BrickViewer getViewer() {
        return brickViewer;
    }

    public TextViewer getTextViewer() {
        return textViewer;
    }

    public RoundViewer getRoundViewer() {
        return roundViewer;
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

    public LivesViewer getLivesViewer() {
        return livesViewer;
    }

    public ScoreViewer getScoreViewer() {
        return scoreViewer;
    }

    public HighScoreViewer getHighScoreViewer() { return highScoreViewer; }

    public PowerUpViewer getPowerUpViewer() {
        return powerUpViewer;
    }

    public InformationsViewer getInfosViewer() {return informationsViewer;}

    public WordInfoViewer getWordInfoViewer() {return wordInfoViewer;}

    public LeftViewer getLeftViewer() {return leftViewer;}

    public RightViewer getRightViewer() {return rightViewer;}

    public ESCViewer getEscViewer() {return escViewer;}

    public EnterViewer getEnterViewer() {return enterViewer;}
}