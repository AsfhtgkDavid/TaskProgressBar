package com.david.progresstaskbar;

import javafx.stage.Stage;

import java.io.IOException;

public class TaskBar {
    private long HWND;

    public TaskBar(Stage stage) {
        HWND = getHWND(stage.getTitle());
    }

    public TaskBar(String name) {
        HWND = getHWND(name);
    }

    public enum State {
        NoProgress,
        Indeterminate,
        Normal,
        Error,
        Paused
    }
    static {
        try {
            LibraryLoader.loadLibrary("taskBar");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public native void SetTaskbarProgress(float percent);

    public native void SetTaskbarProgressState(State state);

    private native long getHWND(String name);
}
