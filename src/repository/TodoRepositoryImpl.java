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
        // 날짜에 해당하는 할 일 리스트 얻어옴
        List<Todo> list = todoMap.get(date);
        // 해당 날짜에 리스트가 비어 있는 확인 비어있으면 return
        if (list == null){
            return;
        }
        // 삭제 할 index가 범위 안에 있는지 확인
        if (index < 0 || index >= list.size()){
            return;
        }
        // 리스트에서 받는 index 번호를 삭제
        list.remove(index);
        // 삭제 후에 리스트가 비어 있으면 Map도 뺌
        if (list.isEmpty()){
            todoMap.remove(date);
        }
    }

    @Override
    public void complete(String date, int index) {
        // 해당 날짜의 리스트 갖고 오기
        List<Todo> list = todoMap.get(date);
        // 리스트가 비어 있는지 index가 존재하는지 확인
        if (list == null) return;
        if (index < 0 || index >= list.size());
        // 완료로 변경
        list.get(index).setCompleted(true);
        // list.get(index).setCompleted(! list.get(index).isCompleted());
    }
}
