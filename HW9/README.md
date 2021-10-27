## README.md
- Brief write-up: <br>
  We use Builder pattern in our Model package. The package is composed of two simple class ToDo and ToDoList.
  Builder pattern is usually used when a class that encapsulates a complex object creation process. i.e. It might have lots of fields, which may be optional or have defaults. According to the requirements, the todo data structure consist optional and defaulted fields at the same time. So we chose to use builder pattern to implement our ToDo.class.

## Sample arguments:
1.three operations<br>
- --csv-file todos.csv --add-todo --todo-text todo1 --completed --due 7/21/2050 --priority 3 --category work --complete-todo 2 --display<br>
- --csv-file todos.csv --add-todo --todo-text todo2 --completed --due 7/21/2050 --priority 2 --category work --complete-todo 2 --display --show-incomplete<br>
- --csv-file todos.csv --add-todo --todo-text todo3 --completed --due 7/21/2050 --priority 2 --category work --complete-todo 2 --display --show-category school<br>
- --csv-file todos.csv --add-todo --todo-text todo4 --completed --due 7/21/2050 --priority 1 --category work --complete-todo 2 --display --sort-by-due<br>
- --csv-file todos.csv --add-todo --todo-text todo5 --completed --due 7/21/2050 --priority 2 --category work --complete-todo 2 --display --sort-by-priority<br>

2.only add entry<br>
- --csv-file todos.csv --add-todo --todo-text only-add-todo --completed --due 7/21/2050 --priority 3 --category leisure (all fields are given)<br>
- --csv-file todos.csv --add-todo --todo-text not-completed --due 7/1/2050 --priority 1 --category family (no status was given)<br>
- --csv-file todos.csv --add-todo --todo-text only add-todo --completed --due 4/21/2050 --category leisure (no priority was given)<br>
- --csv-file todos.csv --add-todo --todo-text only add-todo --completed --due 3/21/2050 --priority 3 (no category was given)<br>

3.only complete entry
- --csv-file todos.csv --complete-todo 2 (single)<br>
- --csv-file todos.csv --complete-todo 2 --complete-todo 4 (multiple)<br>

4.only display
- --csv-file todos.csv --display<br>
- --csv-file todos.csv --display --show-category school<br>
- --csv-file todos.csv --display --show-incomplete<br>
- --csv-file todos.csv --display --show-incomplete --show-category school<br>
- --csv-file todos.csv --display --sort-by-due<br>
- --csv-file todos.csv --display --sort-by-priority<br>

