# TaskProgressBar

TaskProgressBar is a Java library for managing progress on the taskbar panel in Windows systems using JavaFX. It allows developers to easily control and update the progress state of their JavaFX applications directly from the taskbar.

## Features

- Supports managing progress on the taskbar panel in Windows systems.
- Provides JavaFX integration for seamless usage.
- Allows setting taskbar progress percentage and state.
- Easy to integrate into existing JavaFX applications.
- Planned support for Linux and macOS systems in future releases.

## Installation

You can include TaskProgressBar in your Java project using either Gradle or Maven. 

### Gradle

Add the following dependency to your `build.gradle` file:

```groovy
dependencies {
    implementation 'com.github.AsfhtgkDavid:TaskProgressBar:1.0.0'
}
```

### Maven

Add the following dependency to your `pom.xml` file:

```xml
<dependency>
    <groupId>com.github.AsfhtgkDavid</groupId>
    <artifactId>TaskProgressBar</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

### Basic Usage

```java
import com.david.progresstaskbar.TaskBar;
import com.david.progresstaskbar.TaskBar.State;

public class Main {
    public static void main(String[] args) {
        TaskBar taskBar = new TaskBar("MyApp");
        
        // Set taskbar progress to 50%
        taskBar.SetTaskbarProgress(50f);
        
        // Set taskbar progress state to Indeterminate
        taskBar.SetTaskbarProgressState(State.Indeterminate);
    }
}
```

## Contributing

Contributions to TaskProgressBar are welcome! Feel free to submit issues, feature requests, or pull requests on [GitHub](https://github.com/AsfhtgkDavid/TaskProgressBar/).

## License

TaskProgressBar is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for more details.
