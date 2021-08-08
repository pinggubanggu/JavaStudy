package miniProject;

import java.io.IOException;

public class ExerciseApp {

  public static void main(String[] args) throws IOException {
    Exercise ex = new ExerciseImpl();
    ex.tableUpdate();
    ex.init();
  }
}
