package JavaStudy08;

public class ExampleUserException {
  public static void main(String[] args) {
    try {
      startInstall();
      copyFiles();  // 파일 복사
    } catch (SpaceException e) {
      System.out.println("에러 메시지 : " + e.getMessage());
      e.printStackTrace();
      System.out.println("공간을 확보한 후에 다시 설치하시기 바랍니다.");
    } catch (MemoryException me) {
      System.out.println("에러 메시지 : " + me.getMessage());
      me.printStackTrace();
      System.gc();    // Garbage Collection을 수행하여 메모리를 늘려준다.
      System.out.println("다시 설치를 시도하세요");
    } finally {
      deleteTempFiles();  // 프로그램에 설치에 사용된 임시파일들을 삭제
    }
  }

  private static void startInstall() throws SpaceException, MemoryException{
    if(!enoughSpace())
      throw new SpaceException("설치할 공간이 부족합니다.");
    if(!enoughMemory())
      throw new MemoryException("메모리가 부족합니다.");
  }

  static void copyFiles() { /* 파일들을 복사 코드 입력 */ }
  static void deleteTempFiles() { /* 임시파일들을 삭제하는 코드 입력 */}

  static boolean enoughSpace() {
    // 설치시 필효한 공간이 있는지 확인하는 코드 입력
    return false;
  }

  private static boolean enoughMemory() {
    // 설치시 필요한 메모리공간이 있는지 확인하는 코드 입력
    return true;
  }
}

class SpaceException extends Exception {
  SpaceException(String msg) {
    super(msg);
  }
}

class MemoryException extends Exception {
  MemoryException(String msg) {
    super(msg);
  }
}
