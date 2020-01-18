import java.util.Random;


class Player{
    protected int maxHp;
    protected int hp;
    protected int mp;
    protected int place;
    protected int ratio;
    protected boolean alive;
    protected Random rnd;
    
    public void work(){
        if(alive){
            int randomVal = rnd.nextInt(100);
            if(randomVal >= ratio){//確率(100 - ratio)%のとき
                place++;
                hp--;
            }
            else{//確率ratio%のとき
                if(mp > 0){//回復に成功！
                    hp = maxHp;
                    mp--;
                }
                else{//失敗(._.)
                    hp--;
                }
            }
            if(hp <= 0){//hpが0以下のとき
                alive = false;
            }
        }    
    }
    
    public boolean isAlive(){
        return alive;
    }
    
    public void printStatus(){
        System.out.println(hp);
        System.out.println(mp);
        System.out.println(place);
    }
    
    public Player(int maxHp, int mp, int ratio){//コンストラクタ
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.mp = mp;
        this.ratio = ratio;
        alive = true;
        rnd = new Random();
        place = 0;
    }
    
}




public class GameA {
    public static void main(String[] args){
        Player p = new Player(10,10,10);
        play(p);
        
    }
        
    public static void play(Player p){
        while(p.isAlive()){//もしpが生きていたら
            p.work();
            p.printStatus();
        }
    }
}
