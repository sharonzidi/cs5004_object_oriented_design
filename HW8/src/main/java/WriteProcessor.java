import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * WriteProcessor class represents writing a letter or email to .txt format as the output, and
 * generate all outputs to a given directory.
 */
public class WriteProcessor implements IWriteProcessor{
  private static final String KEYWORD = "template";
  private static final int SPACE = 2;
  private CommandLineParser parser;
  private HashSet<String> types;
  private String outDir;

  /**
   * Constructor for WriteProcessor class.
   * @param parser - CommandLineParser.
   */
  public WriteProcessor(CommandLineParser parser) {
    this.parser = parser;
    this.types = parser.getCommands();
    this.outDir = parser.getParameters().get(CommandLineParser.OUTPUT_DIR);
  }

  /**
   * Generate outputs to the given path.
   * @param supporterInformation - an ArrayList of HashMap which contains different supporters'
   *                             personal information.
   */
  public void generateOutputs(ArrayList<Map> supporterInformation)
      throws  IOException {
    try {
      String templateName = "";
      ArrayList<String> templateNames;
      templateNames = getTemplateName();
      for (String type: this.types) {
        type = type.replace("--", "");
        for (String name : templateNames) {
          if (name.contains(type)) {
            templateName = name;
          }
        }
        for (int i = 0; i < supporterInformation.size(); i++) {
          List<String> template = this.readTemplate(templateName);
          this.writeOutput(type, template, i, supporterInformation.get(i));
        }
      }
    } catch (IOException ioe) {
      throw ioe;
    }
  }

  /**
   * Helper method which helps to write a single output using given parameters.
   * @param type - a String of output type such as "email".
   * @param template - a List of String represents a template.
   * @param index - the index of supporter information.
   * @param supporterInformation - an ArrayList of HashMap which contains different supporters'
   *                             personal information.
   */
  private void writeOutput(String type, List<String> template, int index, Map<String, String>
      supporterInformation) throws IOException {
    try {
      validateFilePath(this.outDir);
      Path outputFile = Paths.get(this.outDir + "/" + index + type + ".txt");
      int i = 0;

      while (i < template.size()) {
        while (template.get(i).indexOf("[[") != -1) {
          int start = template.get(i).indexOf("[[");
          int end = template.get(i).indexOf("]]");
          String toBeFill = template.get(i).substring(start, end + SPACE);
          String temp = template.get(i).replace(toBeFill, (String) supporterInformation.get(toBeFill));
          template.set(i, temp);
        }
        i++;
      }
      Files.write(outputFile, template);
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      throw ioe;
    }
  }

  /**
   * Helper method which helps to get the output template.
   * @param templateName - a String of template name, e.g. "email-template.txt".
   * @return the requested template as a list of String.
   */
  private List<String> readTemplate(String templateName) throws IOException{
    List<String> template = null;
    try {
      Path in = Paths.get(templateName);
      template = Files.readAllLines(in);
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      throw ioe;
    }
    return template;
  }

  /**
   * Helper method to check if there exist a directory.
   * @param path - the output path of the output.
   */
  private void validateFilePath(String path) {
    File directory = new File(path);
    if (! directory.exists()){
      directory.mkdir();
    }
  }

  /**
   * Helper method which check if the template format is correct.
   * @param template - a String of template name, e.g. "email-template.txt".
   * @return true if it's correct, false otherwise.
   */


  /**
   * Helper method which helps to get all template names from command line.
   * @return All templates the user given as an ArrayList of String.
   */
  private ArrayList<String> getTemplateName() {
    Set<String> templates;
    templates = this.parser.getParameters().keySet();
    ArrayList<String> templates1 = new ArrayList<>();
    for (String temp: templates) {
      if (temp.contains(KEYWORD)) {
        templates1.add(this.parser.getParameters().get(temp));
      }
    }
    return templates1;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    WriteProcessor that = (WriteProcessor) o;
    return Objects.equals(this.parser, that.parser) && Objects
        .equals(this.types, that.types) && Objects.equals(this.outDir, that.outDir);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.parser, this.types, this.outDir);
  }

  @Override
  public String toString() {
    return "WriteProcessor{" +
        "parser=" + this.parser +
        ", types=" + this.types +
        ", outDir='" + this.outDir + '\'' +
        '}';
  }
}