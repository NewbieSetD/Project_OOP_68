public class Player extends Pig{
    private String username;
    private boolean HeadServer;
    private int xLine;
    private int yLine;
    Player(String username){
        this.username = username;
    }
    @Override
    public String toString() {
                return String.format(
                    "User::%s \nUser_AILVE::%s \nUser_AMMO::%d\nUser_KILL::%d \nUser_STATUS::%s \nUser_Head::%s\n"
                    ,username,status_alive(),getAmmo(),getKill(),status_rank(),isHeadS());
    }
    @Override
    public void Shot() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Shot'");
    }
    @Override
    public void Hit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Hit'");
    }
    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
    public void setHeadServer(){
        HeadServer = !HeadServer;
    }
    public String isHeadS(){
        if(HeadServer){
            return "Yes";
        }
        else{
            return "No";
        }
    }
    public boolean isHeadServer(){
        return HeadServer;
    }
    
}