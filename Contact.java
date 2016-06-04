package samples300.object.contactsSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * Created by Rayest on 2016/6/4 0004.
 */
//应用Comparable接口实现自定义排序
public class Contact implements Comparable<Contact>{
    private int id;
    private String name;
    private String password;

    public Contact(int id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    //Comparable接口用于强行对实现它的每个类的对象进行整体排序。
    //在实现该接口的类中，必须实现该接口中定义的compareTo()方法：用于用户指定的排序规则。
    //本例中，用户将id作为排序规则。
    //实现该方法后，如果将对象保存到列表list（容器）中，那么通过执行Collections.sort()方法进行自动排序
    //如果对象保存到数组中，执行Arrays.sort()方法进行排序。
    @Override
    public int compareTo(Contact contact) {
        if (id > contact.id){
            return 1;
        }
        else if (id < contact.id){
            return -1;
        }
        else{
            return 0;
        }
    }

    //返回contact的字符串信息。
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID：" + id + "\t" + "姓名：" + name + "\t" + "密码：" + password);
        return stringBuilder.toString();
    }
}

class AppContact{
    public static void main(String[] args) {
        List<Contact> list = new ArrayList<>();

        Contact contact1 = new Contact(3, "Ray", "000000");
        Contact contact2 = new Contact(1, "Pay", "666666");
        Contact contact3 = new Contact(2, "Paris", "222222");

        list.add(contact1);
        list.add(contact2);
        list.add(contact3);

        //toString()方法要在Contact类中进行重载，通过StringBuilder连接并返回contact的信息。
        //打印信息时，可以contact或contact.toString().
        print("排序前：");
        for (Contact contact: list){
            print(contact);
        }

        print("排序后：");
        Collections.sort(list);
        for (Contact contact: list){
            print(contact.toString());
        }
    }
}
