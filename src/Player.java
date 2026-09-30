public class Player implements TanK{
    private int ammo;
    private int speed;
    private boolean Alive;
    Player(){
        this.ammo = 4;
        this.speed = 50;
        this.Alive = true;
    }
    public void Shot(){

    }
    public void Hit(){

    }
    public void move(){

    }
    public void add_ammo(){
        ammo++;
    }
    public boolean isDead(){
        if(Alive){
            return true;
        }
        return false;
    }
    public boolean is_out_of_ammo(){
        if(ammo==0){
            return true;
        }
        return false;
    }
}