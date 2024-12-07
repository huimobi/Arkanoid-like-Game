package project.com.Viewer.Screen;

import project.com.gui.GUI;

import java.io.IOException;

    public abstract class Viewer<T> {
        private final T model;

        public Viewer(T model) {
            this.model = model;
        }

        public T getModel() {
            return model;
        }

        public abstract void draw(GUI gui) throws IOException;
    }

