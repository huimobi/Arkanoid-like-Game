package project.com.Viewer.Screen;

import project.com.Model.Level;
import project.com.gui.GUI;

import java.io.IOException;

/*public class GameViewer extends Viewer<Level> {

    public GameViewer(Level level) {
        super(level);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElement(gui, getModel().getHero(), new HeroViewer());

        gui.drawText(new Position(0, 0), "Energy: " + getModel().getHero().getEnergy(), "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    @Override
    public void draw(GUI gui, long frameTime) throws IOException {

    }
}*/
