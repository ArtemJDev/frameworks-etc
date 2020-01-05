package ru.serialization.gson;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        SetOfPrim obj = new SetOfPrim(22, "test", 10);
        System.out.println(obj);

        Gson gson = new Gson();

        String json = gson.toJson(obj);
        System.out.println(json);

        SetOfPrim obj2 = gson.fromJson(json, SetOfPrim.class);
        System.out.println(obj.equals(obj2));
        System.out.println(obj2);
    }
}
