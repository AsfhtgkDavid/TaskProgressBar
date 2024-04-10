package com.david.progresstaskbar;

import javafx.stage.Stage;

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
        System.loadLibrary("taskBar");
    }

    public native void SetTaskbarProgress(float percent);

    public native void SetTaskbarProgressState(State state);

    private native long getHWND(String name);
}
