package repository;
import vo.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoRepositoryImpl implements TodoRepository{
    private final Map<String, List<Todo>> todoMap = new HashMap<>();

    @Override
    public void add(String date, Todo todo) {
//        System.out.println("[repo]" + todo); test 하기
        // map에 key가 없다면 빈 리스트 생성
        if (!todoMap.containsKey(date)){
            todoMap.put(date,new ArrayList<>());
        }
        // 가져온 todo를 리스트에 추가하기
        // List<Todo> todoList = todoMap.get(date);
        todoMap.get(date).add(todo);
        // 저장 확인
        List<Todo> dis = todoMap.get(date);
        for (Todo t : dis){
            System.out.println(t);
        }
    }

    @Override
    public List<Todo> findByDate(String date) {
        if (!todoMap.containsKey(date)){
            // map을 key로 열어봤을 때 리스트가 없는 경우
            // 빈 리스트 생성 후 리턴
            return new ArrayList<>();
        }
        return todoMap.get(date);
    }

    @Override
    public Map<String, List<Todo>> findAll() {
        return todoMap;
    }

    @Override
    public void update(String date, int index, Todo todo) {

    }

    @Override
    public void delete(String date, int index) {

    }

    @Override
    public void complete(String date, int index) {

    }
}
