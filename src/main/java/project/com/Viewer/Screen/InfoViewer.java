package project.com.Viewer.Screen;

import project.com.Arkanoid;
import project.com.Model.Info;
import project.com.Model.Position;
import project.com.Viewer.MainMenu.InfosViewer;
import project.com.Viewer.MainMenu.MainMenuBackgroundViewer;
import project.com.Viewer.MainMenu.WordInfoViewer;
import project.com.Viewer.ViewerProvider;
import project.com.gui.GUI;

import java.io.IOException;
import java.util.ArrayList;

public class InfoViewer extends Viewer<Info> {
    private final InfosViewer infosViewer;
    public MainMenuBackgroundViewer background;
    private final WordInfoViewer WordInfoViewer;


    public InfoViewer(Info model, ViewerProvider viewerProvider) {
        super(model, viewerProvider);
        this.infosViewer = viewerProvider.getInfosViewer();
        this.background = viewerProvider.getMainMenuBackground();
        this.WordInfoViewer = viewerProvider.getWordInfoViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        background.draw(gui);
        WordInfoViewer.draw(gui, new Position((Arkanoid.WIDTH - 56) / 2,35));
        drawInfo(gui, getModel().getInfo());
        gui.refresh();
    }

    private void drawInfo(GUI gui, ArrayList<Info> infos) throws IOException {
        for (Info info : infos) {
            infosViewer.draw(info, gui);
        }
    }
}