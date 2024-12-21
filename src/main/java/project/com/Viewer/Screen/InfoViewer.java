package project.com.Viewer.Screen;

import project.com.Arkanoid;
import project.com.Model.Menus.InfoMenu;
import project.com.Model.Menus.Option;
import project.com.Model.Position;
import project.com.Viewer.Info.*;
import project.com.Viewer.MainMenu.MainMenuBackgroundViewer;
import project.com.Viewer.ViewerProvider;
import project.com.gui.GUI;

import java.io.IOException;
import java.util.ArrayList;

import static project.com.Viewer.Screen.MainMenuViewer.selectedColor;

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
        WordInfoViewer.draw(gui, new Position((Arkanoid.WIDTH - 56) / 2,22));
        leftViewer.draw(gui, new Position((((Arkanoid.WIDTH - 29 * 7) + 15) / 2) - 14,((Arkanoid.HEIGHT + 7) / 2) - 23));
        rightViewer.draw(gui, new Position((((Arkanoid.WIDTH - 30 * 7) + 15) / 2) - 14, ((Arkanoid.HEIGHT + 7) / 2) - 5));
        enterViewer.draw(gui, new Position((((Arkanoid.WIDTH - 26 * 7) + 15) / 2) - 14, ((Arkanoid.HEIGHT + 7) / 2) + 13));
        escViewer.draw(gui, new Position((((Arkanoid.WIDTH - 32 * 7) + 15) / 2) - 14, ((Arkanoid.HEIGHT + 7) / 2) + 31));
        drawInfo(gui, getModel().getInfo());

        gui.refresh();
    }

    private void drawInfo(GUI gui, ArrayList<Option> infos) throws IOException {
        for (Option info : infos) {
            informationsViewer.draw(info, gui);
            if (info.equals(getModel().getCurrentInfo())) {
                informationsViewer.showSelect(info, selectedColor, gui);
            }
        }
    }
}