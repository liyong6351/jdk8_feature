package stream;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: jdk8_feature
 * @description:
 * @author: langtao
 * @create: 2019-08-07 10:26
 **/
public class Demo1 {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList(
                "bcd", "cde", "def", "abc");
        List<String> result = list.stream()
                //.parallel()
                .filter(e -> e.length() >= 3)
                .map(e -> e.charAt(0))
                //.peek(System.out :: println)
                //.sorted()
                //.peek(e -> System.out.println("++++" + e))
                .map(e -> String.valueOf(e))
                .collect(Collectors.toList());
        System.out.println("----------------------------");
        System.out.println(result);
    }

    public void targetMethod() {
        List<String> list = Lists.newArrayList(
                "bcd", "cde", "def", "abc");
        List<String> result = Lists.newArrayListWithCapacity(list.size());
        for (String str : list) {
            if (str.length() >= 3) {
                char e = str.charAt(0);
                String tempStr = String.valueOf(e);
                result.add(tempStr);
            }
        }
        System.out.println("----------------------------");
        System.out.println(result);
    }
}
