package enum_1;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/6 23:14
 *
 * java 1.5后可以直接使用enum关键字来创建枚举类
 */
@SuppressWarnings("all")
public class EnumTest_pro {
    public static void main(String[] args) {
        SeasonTest1 summer = SeasonTest1.SUMMER;
        System.out.println(summer);                 //输出为：SUMMER..，
                                                    // 在没有写toString的情况下默认调用父类的toString
        System.out.println(SeasonTest1.class.getSuperclass());

        System.out.println("values*****************************");
        //Enum（即enum父类中的方法）
        //values()
        SeasonTest1[] values = SeasonTest1.values();//该方法返回值为枚举类的对象数组。该方法可以很方便的遍历所有的枚举值
        for(SeasonTest1 se : values){
            System.out.println(se);
        }
        System.out.println("valueOf******************************");
        //valueOf(String ObjectName),返回枚举类中对象名ObjectName的对象,如果没有则抛出异常
        SeasonTest1 winter = SeasonTest1.valueOf("WINTER");
        System.out.println(winter);
    }

}
enum SeasonTest1 {  //该类的父类不是Object ,而是java.lang.Enum
    SPRING ("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUGEST("秋天","秋高气爽"),
    WINTER("冬天","傲梅盛开");
    private final String NAME;//final可以在初始化时赋值，可以在代码块中赋值,可以在构造器中赋值，这里选择在构造器中
    private final String INTRODUCE;

    private SeasonTest1(String NAME, String INTRODUCE){
        this.NAME = NAME;
        this.INTRODUCE = INTRODUCE;
    }
    @SuppressWarnings("unused")
    public String getNAME() {
        return NAME;
    }
    @SuppressWarnings("unused")
    public String getINTRODUCE() {
        return INTRODUCE;
    }

//    @Override
//    public String toString() {
//        return "SeasonTest1{" +
//                "NAME='" + NAME + '\'' +
//                ", INTRODUCE='" + INTRODUCE + '\'' +
//                '}';
//    }
}


