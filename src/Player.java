public class Player extends Pig {
    private String username;
    private boolean HeadServer;
    private int xLine;
    private int yLine;

    Player(String username, int x, int y) {
        this.username = username;
        this.xLine = x;
        this.yLine = y;
        this.HeadServer = false;
    }

    @Override
    public String toString() {
        return String.format(
            "User::%s \nUser_ALIVE::%s \nUser_AMMO::%d\nUser_KILL::%d \nUser_STATUS::%s \nUser_Head::%s\nPosition::(%d, %d)\n",
            username, status_alive(), getAmmo(), getKill(), status_rank(), HeadServer ? "Yes" : "No", xLine, yLine
        );
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

    @Override
    protected void doShot() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doShot'");
    }

    public void toggleHeadServer() {
        this.HeadServer = !this.HeadServer;
    }

    public boolean isHeadServer() {
        return HeadServer;
    }

    public String isHeadS() {
        if (HeadServer) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public String getUsername() {
        return username;
    }

    public int getPoseX() {
        return xLine;
    }

    public int getPoseY() {
        return yLine;
    }

    public void setPosetion(int newX, int newY) {
        xLine = newX;
        yLine = newY;
    }

}