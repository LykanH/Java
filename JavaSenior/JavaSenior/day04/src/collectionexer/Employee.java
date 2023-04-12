package collectionexer;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/18 21:27
 */
public class Employee implements Comparable {
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }


    public static void main(String[] args) {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee employee1 = (Employee) o1;
                    Employee employee2 = (Employee) o2;
                    if (employee1.birthday.getYear() != employee2.birthday.getYear()){
                        return employee1.birthday.getYear() - employee2.birthday.getYear();
                    }else {
                        if (employee1.birthday.getMonth() != employee2.birthday.getMonth()){
                            return employee1.birthday.getYear() - employee2.birthday.getYear();
                        }else {
                            return employee1.birthday.getDay() - employee2.birthday.getDay();
                        }
                    }
                }
                throw new RuntimeException("数据类型错误！！");

            }
        };

        TreeSet treeSet = new TreeSet(com);
        treeSet.add(new Employee("ypb", 20, new MyDate(2012, 2, 14)));
        treeSet.add(new Employee("qwe", 20, new MyDate(2012, 1, 14)));
        treeSet.add(new Employee("asd", 20, new MyDate(2012, 2, 15)));
        treeSet.add(new Employee("ghj", 20, new MyDate(1983, 2, 14)));
        treeSet.add(new Employee("avb", 20, new MyDate(1999, 2, 14)));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            Employee employee = (Employee) o;
            return this.name.compareTo(employee.name);
        } else {
            throw new RuntimeException("数据异常！！");
        }
    }
}
