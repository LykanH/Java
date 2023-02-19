package enum_1;

/**
 * @author muchen
 * @create 2022 - 12 - 2022/12/6 20:24
 * 1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，可以使用枚举类
 *
 *
 * test : 自定义枚举类...
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(SeasonTest.SPRING);
    }

}
//使用类似于单例模式自定义枚举类
class SeasonTest{
    private final String NAME;//final可以在初始化时赋值，可以在代码块中赋值,可以在构造器中赋值，这里选择在构造器中
    private final String INTRODUCE;
    public SeasonTest(String NAME,String INTRODUCE){
        this.NAME = NAME;
        this.INTRODUCE = INTRODUCE;
    }

    public static SeasonTest SPRING = new SeasonTest("春天","春暖花开");
    public static SeasonTest SUMMER = new SeasonTest("夏天","夏日炎炎");
    public static SeasonTest AUGEST = new SeasonTest("秋天","秋高气爽");
    public static SeasonTest WINTER = new SeasonTest("冬天","傲梅盛开");

    public String getNAME() {
        return NAME;
    }

    public String getINTRODUCE() {
        return INTRODUCE;
    }

    @Override
    public String toString() {
        return "SeasonTest{" +
                "NAME='" + NAME + '\'' +
                ", INTRODUCE='" + INTRODUCE + '\'' +
                '}';
    }
}