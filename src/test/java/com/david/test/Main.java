package com.david.test;

import com.david.progresstaskbar.TaskBar;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        ProgressBar progressBar = new ProgressBar();
//        TaskProgressView<WorkerTask> progressView = new TaskProgressView<>();

        StackPane root = new StackPane();
        root.getChildren().addAll(progressBar);
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
        WorkerTask task = new WorkerTask();
        primaryStage.setTitle("Taskbar Progress Example");
        TaskBar taskBar = new TaskBar(primaryStage);
        taskBar.setTaskbarProgressState(TaskBar.State.Error);
        taskBar.setTaskbarProgress(20);

        task.setOnProgressUpdate((progress) -> {
            Platform.runLater(()->taskBar.setTaskbarProgress((float) progress));
        });

//        progressView.getTasks().add(task);
        new Thread(task).start();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
