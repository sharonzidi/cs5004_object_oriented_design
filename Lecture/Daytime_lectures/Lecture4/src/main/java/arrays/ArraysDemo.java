package arrays;

public class ArraysDemo {

  private static int[] setIntArray(int[] array, int value1, int value2){
    array[0] = value1;
    array[1] = value2;
    return array;
  }

  private static Integer[] setIntegerArray(Integer[] array, int value1, Integer value2){
    array[0] = value1; //pay attention to auto-boxing here
    array[1] = value2;
    return array;
  }

  public static void main(String[] args){
    int[] intArray = new int[5];
    Integer[] integerArray = new Integer[5];

    System.out.println(setIntArray(intArray, 1, 2)[0]);
    System.out.println(setIntArray(intArray, 1, 2)[1]);
    System.out.println(setIntArray(intArray, 1, 2)[2]);

    System.out.println(setIntegerArray(integerArray, 1, 2)[0]);
    System.out.println(setIntegerArray(integerArray, 1, 2)[1]);
    System.out.println(setIntegerArray(integerArray, 1, 2)[2]);
  }
}
