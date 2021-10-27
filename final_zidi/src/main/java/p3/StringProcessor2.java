package p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StringProcessor2 {

  public StringProcessor2() {
  }

  public static <E> List<ReplaceInfo> replaceAndRepeatLetters(char sourceChar, char destChar,
                                           int numRepetitions, List<String> stringList){
    //YOUR CODE HERE
    List<ReplaceInfo> result = new ArrayList<ReplaceInfo>();

    for(String src: stringList) {
      String des = "";
      int count = 0;
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < src.length(); i++) {
        char ch = src.charAt(i);
        if (ch == sourceChar) {
          count++;
          for (int j = 0; j < numRepetitions; j++)
            stringBuilder.append(destChar);
        } else {
          stringBuilder.append(ch);
        }
      }
      des = stringBuilder.toString();
      ReplaceInfo tmp = new ReplaceInfo(src, des, count);
      result.add(tmp);
    }
    return result;
  }
}