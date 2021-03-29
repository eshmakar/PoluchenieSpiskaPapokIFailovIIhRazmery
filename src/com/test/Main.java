package com.test;

import java.io.File;

public class Main {
    static String p = "D:/Tempp/"; //папка для сканирования
    static File f = new File(p);
    static String[] arr = f.list();//получаем список и сохраняем их в массив

    public static void main(String[] args) {

        for (int i = 0; i < arr.length; i++) {
            String path = (f + "/" + arr[i]); //проверяем каждый файл
            if (!path.contains(".")) { //если в названии нету точки
                System.out.printf("[%s]\n", arr[i]); //выводим на консоль как папку
            } else {
                if (new File(path).length() < 1024) //если размер меньше 1024
                    System.out.printf("%s - %.0f Byte\n", arr[i], (double) new File(path).length());  // (double) new File(path).length() - получаем размер файла
                else if (new File(path).length() / 1024. < 1024)
                    System.out.printf("%s - %.3f Kb\n", arr[i], new File(path).length() / 1024.);
                else if (new File(path).length() / 1024. / 1024. < 1024)
                    System.out.printf("%s - %.3f Mb\n", arr[i], new File(path).length() / 1024. / 1024.);
                else System.out.printf("%s - %.3f Gb\n", arr[i], new File(path).length() / 1024. / 1024. / 1024.);
            }
        }
    }
}