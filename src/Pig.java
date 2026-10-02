public abstract class Pig {
    public boolean Alive = true;
    public boolean dash = false;
    public boolean king = false;
    public int ammo = 4;
    public int killed = 0;
    public abstract String toString();
    public abstract void Shot();
    public abstract void Hit();
    public abstract void move();
    public void to_King(){
        if(killed>4){
            //System.out.println("King spawn!");
            king = true;
        }
    }
    public void addKill(){
        killed++;
    }
    public void Dead(){
        Alive = false;
    }
    public void alive(){
        Alive = true;
    }
    public void add_ammo(){
        if(ammo>5){
            return ;
        }
        ammo++;
    }
    public int getAmmo(){
        return ammo;
    }
    public boolean isKing(){
        return king;
    }
    public boolean isDead(){
        return !Alive;
    }
    public boolean is_out_of_ammo(){
        if(ammo<=0){
            return true;
        }
        return false;
    }
    public boolean isDash(){
        return dash;
    }
    public int getKill(){
        return killed;
    }
    public String status_rank(){
        if(isKing()){
            return "King";
        }
        else{
            return "Normal";
        }
    }
    public String status_alive(){
        if(!isDead()){
            return "Yes";
        }
        return "No";
    }

}