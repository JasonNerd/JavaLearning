package com.rainbow.tijava.C11Collection.s2features;
// 向容器中添加一组元素

// Arrays.asList()方法接受一个数组或是一个用逗号分隔的元素列表，返回一个List对象.
// Collections.addAll()方法接受一个Collection对象和一个数组
// 或是一个用逗号分割的列表，将元素添加到Collection对象中。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AddGroups {
    public static void main(String[] args) {
        // Arrays.asList: 接受一组 Snow 对象(包括子孙类)
        List<Snow> sList = Arrays.asList(new Snow(), new Powder(), new Heavy(), new Slush());

        Collection<Snow> sCollection = new ArrayList<Snow>(sList);
        System.out.println(sCollection);
        Snow[] snowArr = { new Light(), new Snow(), new Crusty() };
        // Collections.addAll()的两种用法
        Collections.addAll(sCollection, snowArr);
        System.out.println(sCollection);
        Collections.addAll(sCollection, new Powder(), new Slush(), new Light());
        System.out.println(sCollection);
        // collection.addAll(), 显著慢于 Collections.addAll()
        sCollection.addAll(Arrays.asList(snowArr)); // 接受一个Collection对象
        System.out.println(sCollection);
        // Arrays.asList() 返回的 List 对象是基于固定数组的, 故而
        // remove(), add() 等操作会触发运行时异常, 但 set()(修改) 是允许的
        // sList.add(new Crusty());
        // sList.remove(0);
        // System.out.println(sList);
    }
}
