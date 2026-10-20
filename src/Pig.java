public abstract class Pig {
    // แนะนำให้ปรับเป็น protected เพื่อให้คลาสลูกเข้าถึงได้ แต่ซ่อนจากคลาสภายนอก
    protected boolean Alive = true;
    protected boolean dash = false;
    protected boolean king = false;
    protected int ammo = 4;
    protected int killed = 0;

    public abstract String toString();
    public abstract boolean equals(Object obj);
    public abstract void move(int direction);
    public void Shot() {
        if (!is_out_of_ammo() && !isDead()) {
            ammo--;
            //doShot(); 
        }
    }
    protected abstract void doShot();

    public void Hit() {
        if (!isDead()) {
            Dead();
            dropAmmo();
        }
    }

    public void to_King(){
        if(killed > 4){
            king = true;
        }
    }

    public void addKill(){
        killed++;
    }

    public void Dead(){
        Alive = false;
        stopDash();
    }

    public void respawn(){
        Alive = true;
        ammo = 4;
        dash = false;
        killed = 0; 
    }

    public int dropAmmo() {
        return 1; 
    }

    public void add_ammo(){
        if(ammo > 5){
            return;
        }
        ammo++;
    }

    public void startDash() {
        if (!isDead()) dash = true;
    }

    public void stopDash() {
        dash = false;
    }

    public int getAmmo(){ return ammo; }
    public boolean isKing(){ return king; }
    public boolean isDead(){ return !Alive; }
    public boolean is_out_of_ammo(){ return ammo <= 0; }
    public boolean isDash(){ return dash; }
    public int getKill(){ return killed; }

    public String status_rank(){
        return isKing() ? "King" : "Normal";
    }

    public String status_alive(){
        return !isDead() ? "Yes" : "No";
    }
}