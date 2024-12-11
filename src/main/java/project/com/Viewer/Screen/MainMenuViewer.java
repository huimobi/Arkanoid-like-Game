package project.com.Viewer.Screen;

import com.googlecode.lanterna.TextColor;
import project.com.MainMenu;
import project.com.Model.Option;
import project.com.Model.Position;
import project.com.Viewer.MainMenu.LogoViewer;
import project.com.Viewer.MainMenu.MainMenuBackgroundViewer;
import project.com.Viewer.MainMenu.OptionViewer;
import project.com.Viewer.ViewerProvider;
import project.com.gui.GUI;

import java.io.IOException;
import java.util.ArrayList;

public class MainMenuViewer extends Viewer<MainMenu> {
        public static final String selectedColor = "#ff7129";
        private final MainMenuBackgroundViewer background;
        private final OptionViewer optionViewer;
        private final LogoViewer LogoViewer;

        public MainMenuViewer(MainMenu model, ViewerProvider viewerProvider) {
            super(model,viewerProvider);
            this.optionViewer = viewerProvider.getOptionsViewer();
            this.LogoViewer = viewerProvider.getLogoViewer();
            this.background = viewerProvider.getMainMenuBackground();
        }

        @Override
        public void draw(GUI gui,long frameTime) throws IOException {
            gui.clear();
            background.draw(gui);
            LogoViewer.draw(gui,new Position(70,36));
            drawOptions(gui, getModel().getOptions());
            gui.refresh();
        }

        private void drawOptions(GUI gui, ArrayList<Option> options) throws IOException {
            for (Option option: options){
                optionViewer.draw(option, gui);
                if(option.equals(getModel().getCurrentOption())){
                    optionViewer.showSelect(option,selectedColor,gui);
                }
            }
        }

}
