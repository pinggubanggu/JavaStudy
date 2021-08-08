package miniProject;

public class YogaClasses {
  Yoga firstClass;
  Yoga secondClass;

  public Yoga getFirstClass() {
    return firstClass;
  }

  public void setFirstClass(Yoga firstClass) {
    this.firstClass = firstClass;
  }

  public Yoga getSecondClass() {
    return secondClass;
  }

  public void setSecondClass(Yoga secondClass) {
    this.secondClass = secondClass;
  }

  @Override
  public String toString() {
    return firstClass + "\n" + secondClass;
  }
}
