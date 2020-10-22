package Metaphase03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularType {

    public static void main(String arhs[]){

        String regularExpression = "([\\s\\w+:]*?/?(/.+/)?)((\\w+)\\.(\\w+))$";
        Pattern pattern = Pattern.compile(regularExpression);
        String path = "D:\\directoryname\\testing\\abc.txt";

        path = path.replace('\\', '/');
        Matcher matcher = pattern.matcher(path);
        System.out.println("1、matcher.matches()："+matcher.matches());

        boolean isMatched = Pattern.matches(regularExpression,path);
        System.out.println("2、isMatched："+isMatched);

    }

}