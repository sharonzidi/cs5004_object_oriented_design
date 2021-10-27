import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Interface of WriteProcessor class.
 */
public interface IWriteProcessor {

  /**
   * Generate outputs to the given path.
   * @param supporterInformation - an ArrayList of HashMap which contains different supporters'
   *                             personal information.
   */
  void generateOutputs(ArrayList<Map> supporterInformation) throws IOException;
}
