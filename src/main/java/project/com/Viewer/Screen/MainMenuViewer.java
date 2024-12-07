package project.com.Viewer.Screen;

/*public class MainMenuViewer<MainMenu> extends Viewer<> {

        public static final TextColor unselectedColor = new TextColor.RGB(234,234,234);
        public static final TextColor selectedColor = new TextColor.RGB(99,155,255);
        public static final TextColor backgroundColor = new TextColor.RGB(28, 28, 46);
        public static final TextColor frameColor = new TextColor.RGB(255, 255, 255);
        private final EntryViewer entryViewer;
        private final LogoViewer logoViewer;

        public MainMenuViewer(T model) {
            super(model);
            this.entryViewer = viewerProvider.getEntryViewer();
            this.logoViewer = viewerProvider.getLogoViewer();
        }

        @Override
        public void draw(GUI gui) throws IOException {
            gui.clear();
            drawBackgroundAndFrame(gui, frameColor, backgroundColor);
            drawEntries(gui, getModel().getEntries());
            logoViewer.draw(gui, 44, 16);
            gui.refresh();
        }

        private void drawEntries(ResizableGUI gui, List<Entry> entries) {
            for (Entry entry: entries)
                entryViewer.draw(entry, gui, getModel().getCurrentEntry() == entry ? selectedColor : unselectedColor);
        }
    }

}*/
