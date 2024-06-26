package com.david.test;

import javafx.concurrent.Task;

public class WorkerTask extends Task<Void> {
    private OnProgressUpdate onProgressUpdate;

    public void setOnProgressUpdate(OnProgressUpdate onProgressUpdate) {
        this.onProgressUpdate = onProgressUpdate;
    }

    @Override
    protected Void call() throws Exception {
        for (int i = 0; i <= 100; i++) {
            updateProgress(i, 100);
            Thread.sleep(50);
        }
        return null;
    }

    @Override
    protected void updateProgress(double v, double v1) {
        onProgressUpdate.update(v);
        super.updateProgress(v, v1);
    }
}
