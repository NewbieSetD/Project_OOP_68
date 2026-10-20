public class BotP extends Pig  {
    private int botID;
    private int spwanX;
    private int spwanY;
    BotP(int ID,int x,int y){
        this.botID = ID;
        this.spwanX = x;
        this.spwanY = y;
    }
    @Override
    public String toString() {
        return String.format(
        "BOT_ID::%d \nBOT_AILVE::%s \nBOT_AMMO::%d \nBOT_KILL::%d \nBOT_STATUS::%s \n",
        botID,status_alive(),getAmmo(),getKill(),status_rank());
    }

    @Override
    public void Hit() {
        super.Hit();
    }
    @Override
    protected void doShot() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doShot'");
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'equals'");
    }
    @Override
    public void move(int direction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
    
}
