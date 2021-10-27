package Controller;

public enum Commands {

  CSV_FILE {
    @Override
    public String toString() {return "--csv-file";}
  },
  ADD_TODO {
    @Override
    public String toString() {return "--add-todo";}
  },
  TODO_TEXT {
    @Override
    public String toString() {return "--todo-text";}
  },
  COMPLETED {
    @Override
    public String toString() {return "--completed";}
  },
  DUE {
    @Override
    public String toString() {return "--due";}
  },
  PRIORITY {
    @Override
    public String toString() {return "--priority";}
  },
  CATEGORY {
    @Override
    public String toString() {return "--category";}
  },
  COMPLETE_TODO {
    @Override
    public String toString() {return "--complete-todo";}
  },
  DISPLAY {
    @Override
    public String toString() {return "--display";}
  },
  SHOW_INCOMPLETE {
    @Override
    public String toString() {return "--show-incomplete";}
  },
  SHOW_CATEGORY {
    @Override
    public String toString() {return "--show-category";}
  },
  SORT_BY_DATE {
    @Override
    public String toString() {return "--sort-by-date";}
  },
  SORT_BY_PRIORITY {
    @Override
    public String toString() {return "--sort-by-priority";}
  },
}
