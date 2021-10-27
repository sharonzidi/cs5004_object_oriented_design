package simplefileprocessor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

    public class CmdLineArgs {
        public static final int MIN_NUMBER_ARGS = 1;
        public static final int MAX_NUMBER_ARGUMENTS = 3;

        public static final int INDEX_START_OPTIONAL_ARGUMENTS = 2;

        public static final String DEFAULT_VALUE_PROCESSING_FLAG = "-c";

        public static final List<String> ALLOWED_PROCESSING_FLAGS
                = Collections.unmodifiableList(Arrays.asList(new String[]{"-c", "-f"}));

        public static final String REGEX_OUTPUT_FILE = ".*\\.csv$";

    }

