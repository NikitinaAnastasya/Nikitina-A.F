public class ConnectLog {
    private static ConnectLog connectLog;
    private static Log log = new Log();

    public static ConnectLog getConnectLog(){
        if (connectLog == null){
            connectLog = new ConnectLog();

        }return connectLog;
    }

    public ConnectLog() {
    }
    public void show(){
        log.getList();
    }
    public void set(String s){
        log.setList(s);
    }
}
