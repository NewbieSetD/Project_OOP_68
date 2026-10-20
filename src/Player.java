import java.awt.Rectangle;
public class Player extends Pig {
    private String username;
    private boolean HeadServer;
    private int xLine;
    private int yLine;
    private int statusTrun = 0;
    private Rectangle hitbox;
    private  int[]turn = {0, 90, 180, 270};

    Player(String username, int x, int y) {
        this.username = username;
        this.xLine = x;
        this.yLine = y;
        this.HeadServer = false;
        this.hitbox = new Rectangle(xLine, yLine, 24, 24);
        statusTrun = turn[(int)(Math.random() * turn.length)];
        
    }

    @Override
    public String toString() {
        return String.format(
                "User::%s \nUser_ALIVE::%s \nUser_AMMO::%d\nUser_KILL::%d \nUser_STATUS::%s \nUser_Head::%s\nPosition::(%d, %d)\nPositionMOVE::%s\n",
                username, status_alive(), getAmmo(), getKill(), status_rank(), HeadServer ? "Yes" : "No", xLine, yLine,
                getMOVE());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void Hit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Hit'");
    }

    @Override
    public void move(int direction) {
        switch (statusTrun) {
            case 90:
                yLine += 8 * direction;
                break;
            case 270:
                yLine -= 8 * direction;
                break;
            case 180:
                xLine -= 8 * direction;
                break;
            case 0:
                xLine += 8 * direction;
                break;
            default:
                xLine = xLine;
                yLine = yLine;
                break;
        }
        if (hitbox != null) {
            hitbox.setLocation(xLine, yLine);
        }
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

    public void setStatusMove(int c) {
        if (c != 90 && c != -90) {
            System.out.println("Not Data");
            return;
        }
        statusTrun = (statusTrun + c + 360) % 360;

    }

    public String getMOVE() {
        String move = "";
        switch (statusTrun) {
            case 90:
                move = "DOWN";
                break;
            case 270:
                move = "UP";
                break;
            case 180:
                move = "LEFT";
                break;
            case 0:
                move = "RIGHT";
                break;
            default:
                move = "unknow";
                break;
        }
        return move;
    }

    public int getStatusTrun() {
        return statusTrun;
    }
    public Rectangle getHitbox() {
        return hitbox;
    }

}