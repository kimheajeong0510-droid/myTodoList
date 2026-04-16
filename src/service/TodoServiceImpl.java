package service;

import repository.TodoRepository;
import vo.Todo;

import java.util.List;
import java.util.Map;

public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void addTodo(String date, String time, String task) {
 //       System.out.println(date + time + task); 출력 먼저 확인
        // 빈 생성자로 Todo 만들기
        Todo todo = new Todo();
        todo.setTime(time);
        todo.setTask(task);
        todo.setCompleted(false);
        // 간단 한 방법
        // todoRepository.add(date, new Todo(time,task,false));
        // Repository 불러오기
        todoRepository.add(date,todo);
    }

    @Override
    public List<Todo> getTodosByDate(String date) {
        return todoRepository.findByDate(date);
    }

    @Override
    public Map<String, List<Todo>> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public void updateTodo(String date, int index, String time, String task) {
    todoRepository.delete(date,index);
    }

    @Override
    public void deleteTodo(String date, int index) {

    }

    @Override
    public void completeTodo(String date, int index) {

    }
}
