package cn.wishhust.test.huawei;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        // 公式；值；目标
        final String[] split1 = str.split(";");

        final String[] gongsi = split1[0].split(",");

        final String[] value = split1[1].split(",");

        int index = 0;
        for (int i = 0; i < gongsi.length; i++) {
            if (gongsi[i].contains(split1[2])) {
                index = i;
                break;
            }
        }
        final StringBuilder sb = new StringBuilder(gongsi[index].split("=")[1]);
        for (int i = 0; i < gongsi.length; i++) {
            if (i != index) {
                String[] split = gongsi[i].split("=");
                if (sb.toString().contains(split[0])) {
                    int start = sb.toString().indexOf(split[0]);
                    int end = start + split[0].length();
                    sb.replace(start,end,"("+split[1]+")");
                }
            }
        }

        for (int i = 0; i < value.length; i++) {
            String[] split = value[i].split("=");
            if (sb.toString().contains(split[0])) {
                int start = sb.toString().indexOf(split[0]);
                int end = start + split[0].length();
                sb.replace(start,end,split[1]);
            }
        }

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
        String expression = sb.toString();

        try {
            String result = String.valueOf(scriptEngine.eval(expression));
            System.out.println(result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

    }
}
