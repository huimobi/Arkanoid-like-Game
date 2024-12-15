package project.com.Viewer.Screen;

import com.googlecode.lanterna.TextColor;
import project.com.Model.*;
import project.com.Viewer.Elements.*;
import project.com.Viewer.Game.GameBackgroundViewer;
import project.com.Viewer.Game.HighScoreViewer;
import project.com.Viewer.Game.RoundViewer;
import project.com.Viewer.Game.ScoreViewer;
import project.com.Viewer.ViewerProvider;
import project.com.gui.GUI;

import java.io.IOException;
import java.util.ArrayList;

public class GameViewer extends Viewer<Level> {
    private final PaddleViewer paddleViewer;
    private final BrickViewer brickViewer;
    private final BallViewer ballViewer;
    private final LivesViewer livesViewer;
    private final GameBackgroundViewer gameBackgroundViewer;
    private final RoundViewer roundViewer;
    private final ScoreViewer scoreViewer;
    private final HighScoreViewer highScoreViewer;
    private final PowerUpViewer powerUpViewer;


    public GameViewer(Level model, ViewerProvider viewerProvider) {
            super(model,viewerProvider);
            this.paddleViewer = viewerProvider.getPaddleViewer();
            this.ballViewer = viewerProvider.getBallViewer();
            this.brickViewer = viewerProvider.getBrickViewer();
            this.gameBackgroundViewer = viewerProvider.getGameBackground();
            this.livesViewer = viewerProvider.getLivesViewer();
            this.roundViewer=viewerProvider.getRoundViewer();
            this.scoreViewer=viewerProvider.getScoreViewer();
            this.highScoreViewer=viewerProvider.getHighScoreViewer();
            this.powerUpViewer=viewerProvider.getPowerUpViewer();
    }


    @Override
        public void draw(GUI gui) throws IOException {
            gui.clear();
            gameBackgroundViewer.draw(gui);
            drawElement(gui, getModel().getBall(),getViewerProvider().getBallViewer());
            drawElement(gui, getModel().getPaddle(), getViewerProvider().getPaddleViewer());
            livesViewer.draw(getModel().getPaddle(),gui);
            roundViewer.draw(getModel(),gui);
            scoreViewer.draw(getModel(),gui);
            highScoreViewer.draw(getModel(), gui);

            drawPowerUps(gui);
            drawBricks(gui);
            drawStrings(gui);
            gui.refresh();
        }


    private void drawBricks(GUI gui) throws IOException {
    ArrayList<Brick> bricks= getModel().getBricks();
    for(Brick brick:bricks){
        drawElement(gui,brick,brickViewer);}
    }

    private void drawPowerUps(GUI gui) throws IOException{
        ArrayList<PowerUp> powerUps=getModel().getPowerUps();
        for(PowerUp powerUp:powerUps){
            drawElement(gui,powerUp,powerUpViewer);
        }
    }
    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) throws IOException {
        viewer.draw(element, gui);
    }

    private void drawStrings(GUI gui) throws IOException {
        String score="score";
        String highScore="highScore";
        String round="round";
        getViewerProvider().getTextViewer().draw(score,new Position((gui.getWidth()-(score.length()*7)+180)/2,(gui.getHeight()-7)/4),"#00ff00",gui);
        getViewerProvider().getTextViewer().draw(highScore,new Position((((gui.getWidth()-(highScore.length()*7)+180)/2)),gui.getHeight()/2),"#00ff00",gui);
        getViewerProvider().getTextViewer().draw(round,new Position(gui.getWidth()-5*7-3,gui.getHeight()-14),"#ff0000",gui);
    }

}
