package Chapter02;

import java.util.Observer;

public interface Subject {
    public void registerObserver(Observer o); // 옵저버 등록
    public void removeObserver(Observer o); // 옵저버 제거

    void registerObserver(Chapter02.Observer o);

    void removeObserver(Chapter02.Observer o);

    public void notifyObservers();// 상태 변경
}

