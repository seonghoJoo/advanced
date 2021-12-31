package hello.advanced.proxy.app.v1;

public class OrderRepositoryV1Impl implements OrderRepositoryV1{

    @Override
    public void save(String itemId) {
        if(itemId.equals("ex")){
            throw new IllegalStateException("예외발생");
        }
        sleep(1000);
    }

    private void sleep(int i) {
        try{
            Thread.sleep(i);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
