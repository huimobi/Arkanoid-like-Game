package project.com.Viewer.Screen;

import project.com.Arkanoid;
import project.com.Model.InfoMenu;
import project.com.Model.Option;
import project.com.Model.Position;
import project.com.Viewer.Info.*;
import project.com.Viewer.MainMenu.MainMenuBackgroundViewer;
import project.com.Viewer.ViewerProvider;
import project.com.gui.GUI;

import java.io.IOException;
import java.util.ArrayList;

public class InfoViewer extends Viewer<InfoMenu> {
    private final InformationsViewer informationsViewer;
    public MainMenuBackgroundViewer background;
    private final WordInfoViewer WordInfoViewer;
    private final LeftViewer leftViewer;
    private final RightViewer rightViewer;
    private final EnterViewer enterViewer;
    private final ESCViewer escViewer;

    public InfoViewer(InfoMenu model, ViewerProvider viewerProvider) {
        super(model, viewerProvider);
        this.informationsViewer = viewerProvider.getInfosViewer();
        this.background = viewerProvider.getMainMenuBackground();
        this.WordInfoViewer = viewerProvider.getWordInfoViewer();
        this.leftViewer = viewerProvider.getLeftViewer();
        this.rightViewer = viewerProvider.getRightViewer();
        this.enterViewer = viewerProvider.getEnterViewer();
        this.escViewer = viewerProvider.getEscViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        background.draw(gui);
        WordInfoViewer.draw(gui, new Position((Arkanoid.WIDTH - 56) / 2,25));
        leftViewer.draw(gui, new Position((((Arkanoid.WIDTH - 29 * 7) + 15) / 2) - 14,((Arkanoid.HEIGHT + 7) / 2) - 19));
        rightViewer.draw(gui, new Position((((Arkanoid.WIDTH - 30 * 7) + 15) / 2) - 14, ((Arkanoid.HEIGHT + 7) / 2) - 1));
        enterViewer.draw(gui, new Position((((Arkanoid.WIDTH - 26 * 7) + 15) / 2) - 14, ((Arkanoid.HEIGHT + 7) / 2) + 17));
        escViewer.draw(gui, new Position((((Arkanoid.WIDTH - 32 * 7) + 15) / 2) - 14, ((Arkanoid.HEIGHT + 7) / 2) + 35));
        drawInfo(gui, getModel().getInfo());

        gui.refresh();
    }

    private void drawInfo(GUI gui, ArrayList<Option> infos) throws IOException {
      for (Option info : infos) {
            informationsViewer.draw(info, gui);
        }
    }
}