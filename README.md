Filtro
======
*Java collections filter library*

This library allows you to filter elements in Java collections using a set of user defined filter rules. You can use any of the 

pre-defined filter modules that comes with the library or construct a new one by extending Filter interface.

#### Example usage:
###### Map

Filtro comes pre-built with a class called `FilterMap` which extends `java.util.HashMap` internally. You get all features of 

HashMap added with the filtering functionality.

Let's construct a `FilterMap` instance and add some dummy values to it.
```java
FilterMap<Integer,String> map = new FilterMap<Integer,String>();
map.put(1,"Apple");
map.put(2,"Orange");
map.put(3,"Banana");
map.put(4,"Pineapple");
map.put(5,"Grapes");
```

Filtro comes with a bundle of filter modules. Let's choose `NumberRangeFilter` which check if the map element is in 

between a `minimum` and `maximum` number. Constructing a filter is quite simple and straightforward.
```java
Filter<Integer> filter = new NumberRangeFilter<Integer>(2,4);
```

FilterMap comes with `filterKeys` and `filterValues` methods to filter either map keys or values based on the filter or list 

of filters specified. For our example we will filter the map keys with the `NumberRangeFilter` we just constructed.
```java
FilterMap<Integer,String> result = map.filterKeys(filter);

System.out.println(result.toString());
```

Filter operation will filter key values between 2 and 4(both inclusive). The output of the code will be as below. 
```
{2=Orange,3=Banana,4=Pineapple}
```

The Full code is as below.
```java
FilterMap<Integer,String> map = new FilterMap<Integer,String>();
map.put(1,"Apple");
map.put(2,"Orange");
map.put(3,"Banana");
map.put(4,"Pineapple");
map.put(5,"Grapes");

Filter<Integer> filter = new NumberRangeFilter<Integer>(2,4);

FilterMap<Integer,String> result = map.filterKeys(filter);
```

###### List
Filtro comes pre-built with a class called `FilterList` which extends `java.util.ArrayList` internally. You get all features of 

ArrayList added with the filtering functionality.

Let's construct a `FilterList` instance and add some dummy values to it.
```java
FilterList<Integer> list = new FilterList<Integer>();
list.add(1);
list.add(2);
list.add(3);
list.add(4);
list.add(5);
```

Let's construct a `NumberRangeFilter` instance.
```java
Filter<Integer> filter = new NumberRangeFilter<Integer>(2,4);
```

FilterList comes with `filter` method to filter either list values based on the filter or list 

of filters specified. For our example we will filter the list values with the `NumberRangeFilter` we just constructed.
```java
FilterList<Integer> result = list.filter(filter);

System.out.println(result.toString());
```

Filter operation will filter list values between 2 and 4(both inclusive). The output of the code will be as below. 
```
[2, 3, 4]
```

The Full code is as below.
```java
FilterList<Integer> list = new FilterList<Integer>();
list.add(1);
list.add(2);
list.add(3);
list.add(4);
list.add(5);

Filter<Integer> filter = new NumberRangeFilter<Integer>(2,4);

FilterList<Integer> result = list.filter(filter);
```