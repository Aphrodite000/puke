

public class PokeCard {
    int value;
    String color;
    PokeCard(int value,String color) {
        this.value=value;
        this.color=color;
    }
    //覆写
    public String toString() {
        return String.format("[%d,%s]",value,color);
    }
    //覆写
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        // 返回 obj 对象能否被 PokeCard 类型的引用指向
        // obj 对象的类型是不是 PokeCard 类型的小类型
        if(!(obj instanceof PokeCard)){
            return false;
            //=是引用之间的比较，关键字instanceof是判断对象与类或其子类的
        }
        PokeCard other =(PokeCard) obj;
        //对象是这个对象，但是引用类型不是，还的把引用类型转换过来
        return this.value==other.value&&this.color.equals(other.color);
        //这里调用的是String类型的equals的（this.color是String类型的），已经实现好了
    }
}
