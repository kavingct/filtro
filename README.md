Filtro
======
*Java collections filter library*

This library allows you to filter elements in Java collections using a set of user defined filter rules. You can use any of the pre-defined filter modules that comes with the library or construct a new one by extending Filter interface.

#### Installation:
Filtro is available in Maven central repository. Just add the following dependency to your pom.xml and you are good to go.
```xml
<dependency>
	<groupId>com.genzis.filtro</groupId>
	<artifactId>filtro</artifactId>
	<version>1.0</version>
</dependency>
```

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

FilterList comes with `filter` method to filter list values based on the filter or list 

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


###### Set
Filtro comes pre-built with a class called `FilterSet` which extends `java.util.HashSet` internally. You get all features of 

HashSet added with the filtering functionality.

Let's construct a `FilterSet` instance and add some dummy values to it.
```java
FilterSet<Integer> list = new FilterSet<Integer>();
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

FilterSet comes with `filter` method to filter set values based on the filter or list 

of filters specified. For our example we will filter the set values with the `NumberRangeFilter` we just constructed.
```java
FilterSet<Integer> result = list.filter(filter);

System.out.println(result.toString());
```

Filter operation will filter set values between 2 and 4(both inclusive). The output of the code will be as below. 
```
[2, 3, 4]
```

The Full code is as below.
```java
FilterSet<Integer> list = new FilterSet<Integer>();
list.add(1);
list.add(2);
list.add(3);
list.add(4);
list.add(5);

Filter<Integer> filter = new NumberRangeFilter<Integer>(2,4);

FilterSet<Integer> result = list.filter(filter);
```


###### Filtering based on multiple Filters
You may find a situation where you need to filter map, list or set's values based on multiple filter rules. To facilitate this purpose the `filterKeys`,`filterValues` methods in FilterMap and `filter` method in FilterList and FilterSet also accept a `List` of filters.
```java
List<Filter<Integer>> filters = new ArrayList<Filter<Integer>>();
filters.add(new NumberMinFilter<Integer>(2));
filters.add(new NumberMaxFilter<Integer>(5));

FilterList<Integer> result = list.filter(filters);
```


###### Filtering any Map, List or Set implementations
Filtro doesn't restrict you to use our implementations such as `FilterMap`,`FilterList` and `FilterSet`. You can use any desired implementation of `Map`,'List' and `Set` interfaces and still filter it using our library. The `Filters` class contains several static methods to filter any implementation of java collections.
Let's construct a `LinkedHashMap` and filter it using the `Filters` class.
```java
Map<Integer,String> map = new LinkedHashMap<Integer,String>();
map.put(1,"Apple");
map.put(2,"Orange");
map.put(3,"Banana");
map.put(4,"Pineapple");
map.put(5,"Grapes");

List<Filter<Integer>> filters = new ArrayList<Filter<Integer>>();
filters.add(new NumberRangeFilter<Integer>(2,4));

Map<Integer,String> result = Filters.filterMapKeys(map,filters,false);
```

The first parameter is the map which you need to filter. The second parameter is the `list` of filters based on which map keys should be filtered. The third parameter is a boolean flag indicating whether the original map should be modified or just a new copy should be returned.
If `true` the elements which fails filter test will be removed in the original map itself. If `false` the original map will remain unchanged and you can obtain the filter result as return value from the method.


###### Creating custom Filter rule.
You can create a custom filter rule by extending the `Filter` interface.
```java
import com.genzis.filtro.Filter;

class TestFilter implements Filter<String> {
	private String condition;
	
	//Optional: Only needed if you need to check the collection value with something. 
	public TestFilter(String condition) {
		this.condition = condition;
	}
	
	//implements the check method of Filter interface.
	public boolean check(String value) {
		//Execute any condition and return true or false.
	}
}
```

Note
====
* If you find any bug or need any new feature, please open an issue in Github. I will try my best to reply back as soon as possible.
* If you wish to contribute to the code, fork the repo, commit any changes and send pull request.

License
=======
The MIT License (MIT)

Copyright (c) 2013 Genzis

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.