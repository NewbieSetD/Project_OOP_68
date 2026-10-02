public class BotP extends Pig{
    private int botID;
    BotP(int ID){
        this.botID = ID;
    }
    @Override
    public String toString() {
        return String.format(
        "BOT_ID::%d \nBOT_AILVE::%s \nBOT_AMMO::%d \nBOT_KILL::%d \nBOT_STATUS::%s \n",
        botID,status_alive(),getAmmo(),getKill(),status_rank());
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
    
}
