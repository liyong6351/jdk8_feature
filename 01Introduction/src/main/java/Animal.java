import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: jdk8_feature
 * @description:
 * @author: langtao
 * @create: 2019-08-06 20:25
 **/
public class Animal implements Moveable {

    public static void main(String[] args) {
        List<String> items = new LinkedList<>();
        items.add("pre_1");
        items.add("dev_1");
        items.add("test_1");
        items.add("local_1");
        items.add("target_1");
        items.add("product_1");
        String prefix = "pre";
        List<String> filteredList = items.stream().filter(e -> (!e.startsWith(prefix))).collect(Collectors.toList());
        System.out.println(items);
        System.out.println(filteredList);
        Animal a = new Animal();
        a.move();
    }

    public void move() {
        System.out.println("animal  moving");
    }
}
