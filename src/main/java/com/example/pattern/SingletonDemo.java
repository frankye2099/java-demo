package com.example.pattern;

class SingletonDemo {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);

        s1.setData("abc");
        System.out.println(s2.getData());
    }
}
