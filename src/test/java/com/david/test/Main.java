package com.david.test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.controlsfx.control.TaskProgressView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        ProgressBar progressBar = new ProgressBar();
        TaskProgressView<WorkerTask> progressView = new TaskProgressView<>();

        // Создание задачи
        StackPane root = new StackPane();
        root.getChildren().addAll(progressView, progressBar);
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
        WorkerTask task = new WorkerTask();
        primaryStage.setTitle("Taskbar Progress Example");
        TaskBar taskBar = new TaskBar(primaryStage);
        taskBar.SetTaskbarProgressState(TaskBar.State.Error;
        taskBar.SetTaskbarProgress(20);

        // Назначение обработчика прогресса
        task.setOnProgressUpdate((progress) -> {
            Platform.runLater(()->taskBar.SetTaskbarProgress((float) progress));
        });

//         Добавление задачи на прогресс панель
        progressView.getTasks().add(task);

        // Создание интерфейса


        // Запуск задачи
        new Thread(task).start();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
