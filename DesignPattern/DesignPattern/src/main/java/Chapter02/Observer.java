package Chapter02;

public interface Observer {
    public void update(float temp, float humidity, float pressure); // 기상 정보가 변경되었을때 옵저버에게 전달되는 상태 값
}
