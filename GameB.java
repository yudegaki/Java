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

class IntelligentPlayer extends Player{
    @Override
    public void work(){
        if(alive){
            if(hp == 1){//回復を試みる
                if(mp > 0){
                    hp = maxHp;
                    mp--;
                }
                else{
                    hp--;
                }
            }
            else if(hp >= 2){//hpが2以上ならば
                super.work();//スーパークラスのworkを実行
            }
            if(hp <= 0){
                alive = false;
            }
        }
    }
    
    public IntelligentPlayer(int maxHp, int mp, int ratio){
        super(maxHp,mp,ratio);
    }
}



public class GameB{
    public static void main(String[] args){
        // Your code here!
        Player p = new Player(10,10,10);
        play(p);
     
        p = new IntelligentPlayer(10,10,10);
        play(p);
        
    }
        
    public static void play(Player p){
        while(p.isAlive()){//もしpが生きていたら
            p.work();
            p.printStatus();
        }
    }
}
