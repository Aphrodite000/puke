import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
public class Main {
    public static void  swap(ArrayList<PokeCard> list,int i,int j) {
        //把一副牌传入，交换两张牌的位置
        PokeCard tmpI=list.get(i);
        PokeCard tmpJ=list.get(j);
        //交换不用中间变量，直接用改值就行
        list.set(i,tmpJ);
        list.set(j,tmpI);
    }
    public static void main(String[] args) {
        ArrayList<PokeCard>  cards=new ArrayList<>(52);//创建一副牌，是一个顺序表
        String[] colors={"红心","方块","红桃","黑梅"};
        for(int i=0;i<4;i++) {
            for(int j=1;j<=13;j++){
                PokeCard card=new PokeCard(j,colors[i]);
                cards.add(card);
            }
        }
       // System.out.println(cards);
        //洗牌
        Random random=new Random(20190820);
        for(int i=51;i>0;i--) {
          int j= random.nextInt(i);//从0到i中随机
            swap(cards,i,j);
        }
        //每人五张牌
        ArrayList<PokeCard> A=new ArrayList<>();
        ArrayList<PokeCard> B=new ArrayList<>();
        ArrayList<PokeCard> C=new ArrayList<>();
        for(int i=0;i<15;i++){
            PokeCard card = cards.remove(i); // 尾删
            switch (i % 3) {
                case 0:
                    A.add(card); break;
                case 1:
                    B.add(card); break;
                case 2:
                    C.add(card); break;
            }
        }
        System.out.println(cards.size());
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        //A抓到手里的牌，看有没有（红心A）
        PokeCard heartA = new PokeCard(6, "红心");
        for (PokeCard card : A) {
            // 如何判断 card 是不是红心 A
            // 自定义类如何判断两个对象相等？
            if (card.equals(heartA)) {
                System.out.println("包含");
            }
        }
        if (A.contains(heartA)) {
            System.out.println("包含");
        } else {
            System.out.println("不包含");
        }
        // 迭代器
        System.out.println(A);
        Iterator<PokeCard> it = A.iterator();
        while (it.hasNext()) {
            PokeCard o = it.next();
            if (o.equals(heartA)) {
                it.remove();
            }
        }
        System.out.println(A);
        Iterator<PokeCard> it1 = A.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        ListIterator<PokeCard> it2 = A.listIterator();
        System.out.println(it2.next());
        System.out.println(it2.next());
        System.out.println(it2.previous());
    }
}

