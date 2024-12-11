package project.com.Viewer.Screen;


import project.com.Viewer.ViewerProvider;
import project.com.gui.GUI;

import java.io.IOException;

public abstract class Viewer<T> {
        private final T model;
        private final ViewerProvider viewerProvider;

        public Viewer(T model, ViewerProvider viewerProvider) {
            this.model = model;
            this.viewerProvider=viewerProvider;
        }

        public T getModel() {
            return model;
        }

    public ViewerProvider getViewerProvider() {
        return viewerProvider;
    }

    public abstract void draw(GUI gui,long frameTime) throws IOException;
}

