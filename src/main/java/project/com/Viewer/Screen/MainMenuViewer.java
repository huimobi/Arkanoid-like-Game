package project.com.Viewer.Screen;

import com.googlecode.lanterna.TextColor;
import project.com.MainMenu;
import project.com.Viewer.MainMenu.LogoViewer;
import project.com.Viewer.MainMenu.MainMenuBackgroundViewer;
import project.com.Viewer.ViewerProvider;
import project.com.gui.GUI;

import java.io.IOException;

public class MainMenuViewer extends Viewer<MainMenu> {

        public static final TextColor unselectedColor = new TextColor.RGB(234,234,234);
        public static final TextColor selectedColor = new TextColor.RGB(99,155,255);
        public static final TextColor backgroundColor = new TextColor.RGB(28, 28, 46);
        public static final TextColor frameColor = new TextColor.RGB(255, 255, 255);
        private final MainMenuBackgroundViewer background;
        //private final EntryViewer entryViewer;
        private final LogoViewer LogoViewer;

        public MainMenuViewer(MainMenu model, ViewerProvider viewerProvider) {
            super(model,viewerProvider);
            //this.entryViewer = viewerProvider.getEntryViewer();
            this.LogoViewer = viewerProvider.getLogoViewer();
            this.background = viewerProvider.getMainMenuBackground();
        }

        @Override
        public void draw(GUI gui) throws IOException {
            gui.clear();
            //drawBackgroundAndFrame(gui, frameColor, backgroundColor);
            //drawEntries(gui, getModel().getEntries());
            //logoViewer.draw(gui, 44, 16);
            gui.refresh();
        }

        /*private void drawEntries(GUI gui, List<Entry> entries) {
            for (Entry entry: entries)
                entryViewer.draw(entry, gui, getModel().getCurrentEntry() == entry ? selectedColor : unselectedColor);
        }*/

}
