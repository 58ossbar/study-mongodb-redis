# study-nosql
Mongodb、Redis数据库入门到实战: 结合实践案例，以任务为驱动，对Mongodb、Redis数据库技术进行梳理，让开发者快速掌握Mongodb和Redis数据库。

# MongoDB是什么
　MongoDB并非芒果的意思，而是源于 Humongous（巨大）一词。中文叫盲狗db

MongoDB是面向文档的数据库，不是关系型数据库。它将原来**‘行’（row）的概念换成了更加灵活的‘文档’（document）模型**。面向文档的方式可以将文档和数组内嵌进来，所以用一条记录就可以表示很复杂的层次关系。 MongoDB没有模式，文档的键不会事先定义也不会固定不变。

Mongodb主要由文档（Document）、集合（Collection）、数据库（Database）三部分组成。

一个MongoDB实例，由多个数据库（Database）组成；一个数据库，由多个集合（Collection）组成；一个集合，又由多个文档组成。注意Mongodb单个文档大小上限为16MB，确保不会使用过多的内存RAM或在传输过程中占用过多的带宽。为了存储更大的文档，Mongodb提供了GridFS。

![image](https://user-images.githubusercontent.com/110378589/194085125-1c6a74ca-00c1-4866-8da2-64f1f85a2fa1.png)

## 程序员注重对象，您的数据库也是。

MongoDB 是一个文档数据库，即在类似 JSON 的文档内存储数据。我们认为面对数据，这种方法非常自然，比传统的排/列模型更加直观和强大。

## 丰富的 JSON 文档

 ●  自然、高效的数据处理方法。

 ●  支持将数组和嵌套对象存储为值。

 ●  支持灵活、动态结构。

## 强大的查询语言

 ●  查询语言丰富和直观，支持通过任何字段进行筛选和排序，而不受其在文档内的嵌套方式影响。

 ●  支持聚合和其他现代使用案例，如基于地理的搜索、图搜索和文本搜索。

 ●  查询本身是 JSON 格式，因此很容易进行组合。无需串联字符串即可动态生成 SQL 查询。

## MongoDB特性

　MongoDB的3大技术特色如下所示：

除了上图所示的还支持：

二级索引、动态查询、全文搜索 、聚合框架、MapReduce、GridFS、地理位置索引、内存引擎 、地理分布等一系列的强大功能。

但是其也有些许的缺点，例如：

　 ●  多表关联： 仅仅支持Left Outer Join

　 ●  SQL 语句支持： 查询为主，部分支持

　 ●  多表原子事务： 不支持

　 ●  多文档原子事务：不支持

　 ●  16MB 文档大小限制，不支持中文排序 ，服务端 Javascript 性能欠佳
 
## MongoDB适用场景

MongoDB的应用已经渗透到各个领域，比如游戏、物流、电商、内容管理、社交、物联网、视频直播等，以下是几个实际的应用案例：

    ●    游戏场景：使用MongoDB存储游戏用户信息，用户的装备、积分等直接以内嵌文档的形式存储，方便查询、更新。

    ●    物流场景：使用MongoDB存储订单信息，订单状态在运送过程中会不断更新，以MongoDB内嵌数组的形式来存储，一次查询就能将订单所有的变更读取出来。

    ●    社交场景：使用MongoDB存储用户信息，以及用户发表的朋友圈信息，通过地理位置索引实现附近的人、地点等功能。

    ●    物联网场景：使用MongoDB存储所有接入的智能设备信息，以及设备汇报的日志信息，并对这些信息进行多维度的分析。

    ●    视频直播：使用MongoDB存储用户信息、礼物信息等。

![image](https://user-images.githubusercontent.com/110378589/194083181-4772c80d-7117-4e45-b698-4c5f738e0d01.png)

# MongoDB的安装和配置

## 安装前的准备

### 1.芒果数据库官网地址：https://www.mongodb.com/
备用下载链接：http://dl.mongodb.org/dl/win32/x86_64
### 2.选择合适的Mongodb社区版或企业版
下载可以选择 zip 格式或者 msi 格式，msi 格式就是下一步、下一步安装。我们讲解 zip格式。
### 3.解压缩这个文件夹，建议不要有中文路径

## 安装说明

### 1. 文件配置

进入解压后的文件夹，新建data和log文件夹，并在log文件夹下，新建mongod.log空文件

新建mongod.conf文件与bin文件夹同级

mongod.conf写入以下内容
![image](https://user-images.githubusercontent.com/110378589/194069719-e2f369a5-f2c7-4c27-b922-9ba7e2cdfd37.png)

注：dbpath和logpath根据自己的具体路径进行修改

### 2. 安装
开始---运行--cmd （ctrl+shift+Enter）调出windows终端,在mongodb解压目录的bin目录下执行如下命令：例如

mongod --config D:\mongodb-win32-x86_64-windows-5.0.11\mongod.conf--install --serviceName  mongodb

执行后的结果可以在控制面板---管理工具--服务列表中查看到服务名为mongodb的进程。

注：在cmd操作下执行一定要以管理员身份运行，否则可能造成安装失败

正常情况下执行后窗口没有任何反应，其实是正常在生成data下默认的几个数据库文件，可以查看是否已经在data目录下生成初始化文件。

### 3. 查看服务及启动服务 
启动/停止mongodb：
net start/stop mongodb

## 客户端工具推荐

MongoDB客户端工具推荐：

### 1、NoSQL Manager for MongoDB Freeware

https://www.mongodbmanager.com/download
![image](https://user-images.githubusercontent.com/110378589/194070651-0eb146ab-9932-44e6-808b-40517f095bd3.png)


### 2、Navicat Premium全能数据库工具（强烈推荐）

Navicat Premium 是一套数据库开发工具，让你从单一应用程序中同时连接 MySQL、MariaDB、MongoDB、SQL Server、Oracle、PostgreSQL 和 SQLite 数据库。它与 Amazon RDS、Amazon Aurora、Amazon Redshift、Microsoft Azure、Oracle Cloud、MongoDB Atlas、阿里云、腾讯云和华为云等云数据库兼容。你可以快速轻松地创建、管理和维护数据库。

默认情况下Navicat 不显示mongodb默认三个数据库，需要显示隐藏的项目
![image](https://user-images.githubusercontent.com/110378589/194070888-f5197a6f-0841-41ec-8a7e-0fad9fa40e0e.png)

![image](https://user-images.githubusercontent.com/110378589/194070792-26c9c4bd-3400-4eca-b5db-34704c972f3f.png)


### 3、Robo 3T

https://robomongo.org/download

## Mongodb的基本操作

### Mongodb数据类型

首先我们要先了解一下MongoDB中有什么样的数据类型:

Object  ID ：Documents 自生成的 _id

这是MongoDB生成的类似关系型DB表主键的唯一key，具体由24个字节组成：

0-8字节是时间戳,

9-14字节的机器标识符，表示MongoDB实例所在机器的不同；

15-18字节的进程id，表示相同机器的不同MongoDB进程。

19-24字节是计数器

注意如果插入文档时指定_id的值则MongoDB就不会赋值Object ID，但要注意_id的唯一性

获取_id可以执行ObjectId();

例如：

"_id" : ObjectId("5b151f8536409809ab2e6b26")

#"5b151f85" 代指的是时间戳time,这条数据的产生时间
#"364098" 代指某台机器的机器码machine,存储这条数据时的机器编号
#"09ab" 代指进程ID,PID多进程存储数据的时候,非常有用的
#"2e6b26" 代指计数器INC,这里要注意的是,计数器的数字可能会出现重复,不是唯一的
#以上四种标识符拼凑成世界上唯一的ObjectID
#只要是支持MongoDB的语言,都会有一个或多个方法,对ObjectID进行转换
#可以得到以上四种信息

#注意:这个类型是不可以被JSON序列化的

  ● String： 字符串，必须是utf-8

  ● Boolean：布尔值

true 或者false 这里首字母是小写的
  
  ● Integer：整数

Int32 Int64 你们就知道有个Int就行了,一般我们用Int32

  ● Double：浮点数

 没有float类型,所有小数都是Double

  ● Arrays：数组或者列表

 多个值存储到一个键:这个数据类型就是字典

  ● Null：空数据类型 , 一个特殊的概念,None Null

  ● Timestamp：时间戳

  ● Date：存储当前日期或时间unix时间格式

我们一般不用这个Date类型,时间戳可以秒杀一切时间类型

### 数据类型转换
1、int转换为string类型

```
String();

db.collectionName.find().forEach(function(x) {
x.FieldName = x.FieldName.toString();
db.collectionName.save(x);
});
db.emp.find({sal:{$lt:String(2000)}});
```

2、string转换为Date类型


```
ISODate()、

db.collectionName.find().forEach(function(x) {
x.FieldName = new ISODate(x.FieldName );
db.collectionName.save(x);
});
```

 3、string转换为int类型


```
常用有：Number(),NumberInt,NumberLong,NumberDEcimal

//string转为int类型
db.collections.find().forEach( function (x) {
  x.ise= NumberInt (x.ise);
  db.collections.save(x);
});
```


4、Mongodb库中已存在的数据的类型转换

```
db.emp.updateMany({
    sal: {
        $exists: true
    }},
    [{$addFields:{
        sal: {
            $toDouble: "$sal"
        }}}]
);
```
### 　数据库操作

MongoDB 中默认的数据库为 test，如果没有创建新的数据库，集合将存放在 test 数据库中。

#### 【查看数据库】

使用show dbs来查看数据库

show dbs
或
show databases;

#### 【创建/切换】

 使用use命令来切换/创建数据库，会发现创建的数据库并不在数据库的列表中， 要显示它，需要向数据库插入一些数据

use db_name

#### 【显示当前数据库】

使用db命令来显示/查看当前数据库，效果等同于 db.getName()

db

#### 【删除数据库】

这将删除当前所选数据库。 如果没有选择任何数据库，那么它将删除默认的’test‘数据库

db.dropDatabase()

### 　集合操作

#### 创建集合
db.createCollection(name, options)

参数说明：

name: 要创建的集合名称
options: 可选参数, 指定有关内存大小及索引的选项
1 首先进入数据库   use   数据库名称
2 创建集合  db.creareCollection('集合名称')

创建集合有一些可选参数

size、capped都是在固定集合上使用的，我们一般将固定集合使用在日志上面，之前的日志文件难以维护，还要定期去处理。
有了固定集合当日志达到最大的时候他会覆盖最早的日志，这样减少了日志维护的资源；
db.createCollection("role",{capped:true,autoIndexId:true,size:6100000});
db.createCollection("student",{capped:true,autoIndexId:true,size:6100000});
db.createCollection("user");

这样就创建一个固定大小的集合，默认_id创建一个索引，在MongoDB里面每一行数据的_id都是唯一的。

max是该集合最大的文档数，也就是可以插入数据的上限；

#### 删除集合
db.user.drop() 删除user集合


#### 查看集合

db.getCollectionNames()：获取当前 db 的所有集合，以数组形式显示

show collections：获取当前 db 的所有集合，以列表（换行）形式显示

show collections

#### 集合的重命名
db.role.renameCollection('user')

###　文档操作
　MongoDB的数据定义格式和JSON的数据定义格式是一样的，但是在MongoDB中我们把他称之为BSON（Binary JSON）是一种类json的一种二进制形式的存储格式。他的数据格式是非常丰富的，比如我们在MySQL中要联系两站表的关系我们会创建一个表，里面存放他们的关系。但是在MongoDB里面我们可以放在同一个文档里面，我们定义一个数组类型的属性，这个数组就可以存放他们之间的关系，只需要两个而不是三个。

#### 插入文档

要将数据插入到 MongoDB 集合中，需要使用 MongoDB 的 insert()或save()方法，还有insertOne()或insertMany()方法

　insert()命令的基本语法如下


```
db.COLLECTION_NAME.insert(document)
```


save()：如果 _id 主键存在则更新数据，如果不存在就插入数据。该方法新版本中已废弃，可以使用 db.collection.insertOne() 或 db.collection.replaceOne() 来代替。

insert(): 若插入的数据主键已经存在，则会抛 org.springframework.dao.DuplicateKeyException 异常，提示主键重复，不保存当前数据。

在插入的文档中，如果不指定_id参数，那么 MongoDB 会为此文档分配一个唯一的ObjectId。_id为集合中的每个文档唯一的12个字节的十六进制数

_id，又称为ObjectId是一个12字节的BSON类型字符串。按照字节顺序依次代表：


```
db.course.insert({
    "name" : "数学",
    "type" : "major"
})
```


向课程表里插入一条数据

一次性插入多条数据db.collection.insertMany() 


```
/*
插入多条记录
*/
db.student.insert([
    {
        "stu_name" : "小明",
        "stu_number" : "2013001",
        "stu_sex" : "男",
        "course" : [
            ObjectId("5bb82bb3627eb5e25bead053"),
            ObjectId("5bb82c5f627eb5e25bead054"),
            ObjectId("5bb82c5f627eb5e25bead055"),
            ObjectId("5bb82c5f627eb5e25bead057"),
            ObjectId("5bb82c5f627eb5e25bead058")
        ],
    },
    {
        "stu_name" : "小红",
        "stu_number" : "2013002",
        "stu_sex" : "女",
        "course" : [
            ObjectId("5bb82bb3627eb5e25bead053"),
            ObjectId("5bb82c5f627eb5e25bead054"),
            ObjectId("5bb82c5f627eb5e25bead055"),
            ObjectId("5bb82c5f627eb5e25bead056"),
            ObjectId("5bb82c5f627eb5e25bead058")
        ],
    }
])
```


就像JSON一样。一次封装多个数据我们就用数组包裹起来就可以了，我们直接在学生表里面关联课程的信息，course就是我们学生所选的课程。

同样我们也可以定义一个变量


```
document1=( {
        "stu_name" : "小明",
        "stu_number" : "2013001",
        "stu_sex" : "男",
        "course" : [
            ObjectId("5bb82bb3627eb5e25bead053"),
            ObjectId("5bb82c5f627eb5e25bead054"),
            ObjectId("5bb82c5f627eb5e25bead055"),
            ObjectId("5bb82c5f627eb5e25bead057"),
            ObjectId("5bb82c5f627eb5e25bead058")
        ],
    },
    {
        "stu_name" : "小红",
        "stu_number" : "2013002",
        "stu_sex" : "女",
        "course" : [
            ObjectId("5bb82bb3627eb5e25bead053"),
            ObjectId("5bb82c5f627eb5e25bead054"),
            ObjectId("5bb82c5f627eb5e25bead055"),
            ObjectId("5bb82c5f627eb5e25bead056"),
            ObjectId("5bb82c5f627eb5e25bead058")
        ]
    });

```

再执行db.student.insert(document1);

还有一种插入的方法：


```
db.student.save(
    {
        "stu_name" : "小峰",
        "stu_number" : "2013009",
        "stu_sex" : "男",
        "course" : [
            ObjectId("5bb82bb3627eb5e25bead053"),
            ObjectId("5bb82c5f627eb5e25bead054"),
            ObjectId("5bb82c5f627eb5e25bead055"),
            ObjectId("5bb82c5f627eb5e25bead057"),
            ObjectId("5bb82c5f627eb5e25bead058")
        ],
    }
)
```


save也可以插入数据，save操作和insert操作的区别在于，save在遇到_id相同的插入数据时候，会覆盖原来的，而insert会提示错误。

shell的for循环批量插入文档:一次插入多条数据

1、先创建数组

2、将数据放在数组中

3、一次 insert 到集合中

```
/*
插入单个文档练习
*/
db.user.insert(
    {
      "name":"liwei",
      "tel":18843436650
    }
  );
  db.user.insert(
  {
    "name":"liwei",
    "tel":18843436650,
    "yz":"100"
  }
);
/*
插入多个文档练习
*/
db.user.insertMany(
  [
    {
      "name":"longdage",
      "sex":1,
      "jushu":"good"
    },
    {
      "name":"gaoluofeng",
      "zhiwu":"1ge",
      "jushu":"yiliu"
    }
  ]
);
/*
批量插入多个文档练习
*/
var arr = [];
for(var i=1 ; i<=20000 ; i++){
    arr.push({name:"小峰"+i});
}
db.user.insert(arr);
```

#### 更新文档

db.student.update({
   查询的条件，
   更新的语句，
   附加的参数
})

附加的参数

构造更新操作前的准备工作，插入测试数据


```
db.student.insertMany([
    {
        "stu_name" : "小张",
        "stu_number" : "2013003",
        "age":18
    },
  {
        "stu_name" : "小张",
        "stu_number" : "2013002",
        "age":28
    },
    {
       "stu_name" : "小张三",
        "stu_number" : "2013004",
        "age":38
    }]
);
```


区分：update默认情况下是只修改一个文档，等同updateOne,如果需要修改多个可以使用multi:true属性


```
db.collection.update(query, update)；
db.student.update(
    {
        "stu_name" : "小张"
    },
    {
        $set : {"stu_name" : "小张二"}
    }
)
db.collection.updateOne(query, update)；
db.student.update(
    {
        "stu_name" : "小张"
    },
    {
        $set : {"stu_name" : "小张一"}
    }
)
```

修改多个文档

```
db.student.update(
    {
        "stu_name": "小张"
    },
    {
        $set: {
            "stu_name": "小张二"
        }
    },
    {
        multi: true
    }
)
```

db.collection.updateMany(query, update)；

$set : 用来指定一个键的值

$unset : 删除指定一个属性

$inc : 增加和减少(increase)

$push : 向数组尾部追加元素

$addToSet : 添加时避免重复,  例如:

db.user.update({"_id": ObjectId("....")}, {$addToSet: {"emails": "sky3hao@163.com"}})

$addToSet 和 $each 组合起来,可以添加多个不同的值.

$pop : 从数组某一端删除元素

$pull : 基于条件来删除数组元素


```
test.update({'name':'foobar'},{$set:{'age':36}}) <==> update test set age=36 where name='foobar'

db.test.update({'name':'foobar'},{$inc:{'age':3}}) <==> update test set age=age+3 where name='foobar'
```


and条件，挨着写默认就是and


```
db.student.update(
    {
        "stu_name" : "小张",
        "stu_number" : "2013003",
    },
    {
        $set : {"stu_name" : "小张二"}
    }
)
```


or条件，要出现$or的关键字


```
db.student.update(
    {
         $or : [
            {"stu_name" : "小张二"},
            {"stu_number" : "2013003"}
        ],
    },
    {
        $set : {"stu_name" : "小张"}
    }
)
$inc
db.student.update(
    {
        "stu_number" : "2013001"
    },
    {
        $inc : {"mark" : 1}//自增1,为负数的时候就是减
    }
);
```


大于一个数据或小于一个数

```
db.student.update(
    {
        "stu_number" : {$gte:"2013001",$lte:"2013002"}
    },
    {
        $inc : {"mark" : 1}//自增1,为负数的时候就是减
    }
);
```


布尔运算符

1 $ne : 不等于 
2 $not : 不匹配结果 
3 $nor : 所有的条件都不匹配 
4 $exists : 判断元素是否存在

$exists

 db.student.find(
    {
        "stu_number" : {$exists:true}
    }
 );

返回这个字段存在的所有记录，当为false的时候结果就是相反；

#### 删除文档

 db.student.remove({
   条件 
}，属性)


```
db.student.remove(
 {
  "_id":ObjectId("5bb83384627eb5e25bead061")
 }
)
```


另外删除单个和多个文档：

/*
删除单个文档
*/

db.student.deleteOne();

/*
删除多个文档
*/

db.student.deleteMany();

/*
可以删除单个也可以多个如果设置true表示删除一个，否则多个*/

db.student.remove();

/*
删除集合中所有文档:清空
*/

db.student.remove({});

/*
或使用性能最高的
*/

db.student.drop();

#### 查询文档


掌握选择器（selector）

 MongoDB的查询选择器就像SQL代码中的where语句。因此您可以用它在集合中查找，统计，更新或是删除文档。选择器就是一个JSON对象，最简单的形式就是{}，用来匹配所有的文档(null也可以）。如果我们需要找到所有雌性的独角兽(unicorn)，我们可以用选择器{gender:'f'}来匹配。

要从MongoDB集合查询数据，需要使用MongoDB的find()方法，默认返回结果中的前20条文档，输入"it"显示接下来的20条文档。

　find()命令的基本语法如下：

db.COLLECTION_NAME.find(document)

find()方法将以非结构化的方式显示所有文档

数据准备

```
db.student.insertMany([
{
      "stu_name": "小李子",
    "stu_number": "2013003",
    "age": 19.5,
    "sex": "男"
},
{
    "stu_name": "小李子",
    "stu_number": "2013002",
    "age": 9.5,
    "sex": "男"
},
{
    "stu_name": "小李子",
    "stu_number": "2013004",
    "age": 4.5,
    "sex": "男"
},

{
    "stu_name": "小张",
    "stu_number": "2013003",
    "age": 18,
    "sex": "女"
},

{
    "stu_name": "小张",
    "stu_number": "2013002",
    "age": 28,
    "sex": "女"
},

{
    "stu_name": "小张三",
    "stu_number": "2013004",
    "age": 38,
    "sex": "女"
},

{
    "stu_name": "小李",
    "stu_number": "2012001",
    "age": 19.5,
    "sex": "男"
},

{
    "stu_name": "小李",
    "stu_number": "2012002",
    "age": 29.5,
    "sex": "女"
},

{
    "stu_name": "小李",
    "stu_number": "2012003",
    "age": 39.5,
    "sex": "女"
}
]);
```

比较运算符

查询的条件有：

等于equal；不等于not equal，小于less than，小于或等于equal or less than，大于greater than，大于或等于equal or greater than。

$not


```
db.student.find(
    {
        'stu_number' : {$not : {$ne : "2013002"}}
    }
).pretty()
```

这种情况下也会返回没有stu_number的字段，和$gt这些比较运算符是不同的，他们只会返回有的字段
范围运算符

$in,不在集合里面我们就用$nin


```
db.student.find(
    {
        'stu_number' : { $in : ["2013001","2013002"]}
    }
).pretty()
```

和Mysql的where in是一样的效果，他会查出2013001和002的数据

模糊查询:正则表达式

在mongoDB里面我们的模糊查询是按照正则表达式来进行匹配的


```
 db.student.find(
 {
     "stu_number":{$regex:/^2013/}
 }
 )
```


我们要查询一个数组里面一个字段的值，我们用点进行连接

```

{
    "userInfo" : {
        "name" : "张三",
        "age" : 28
    }
}
```

我们要查询name等于张三的信息

db.student.find({"userInfo.name":"张三"})

JavaScript查询


```
 db.student.find(
 {
     "$where" : "function () {return this.stu_number == '2013001'}"
 }
)
```

排序

1:升序

-1:降序

语法：

db.stu.find().sort({字段:1})

举例：


```
db.student.find().sort({"stu_number":-1}).pretty()
```


/*
#多属性排序sort升序值1，降序为-1


```
db.student.aggregate([{$sort:{age:-1}},{$sort:{stu_name:-1}}]);
db.student.find().sort({age:-1},{stu_name:-1}).pretty();
```

*/

/*显示10条数据*/


```
db.student.find().sort({age:-1},{stu_name:-1}).limit(10).pretty();

db.student.find().sort({age:-1},{stu_name:-1}).limit(10).skip(2).pretty();
```


限制


```
db.student.find().sort({"stu_number":-1}).limit(5).pretty()
```

 限制显示5条数据
跳过

```
db.student.find().sort({"stu_number":-1}).limit(5).skip(2).pretty()
```


#跳过前两个并且显示5条数据

我们所看到的限制、跳过和Mysql的limit一样，限制就是第一个参数，跳过就是第二个参数偏移量。

查询返回特定的字段


```
db.student.find({},{'stu_number':0,}).sort({"stu_number":-1}).limit(5).skip(2).pretty()
```


当我们stu_number为0的时候，返回除了stu_number以外的数据，如果为1只返回stu_number一个字段的数据。

统计个数
db.stu.find(条件).count()
db.stu.count({条件})
消除重复
db.stu.distinct(去重字段, {条件})
聚合 aggregate

表达式

$sum
$avg
$min
$max
$push: 数组
$first
$last
$$ROOT: 将文档内容加入到结果集的数组中
/*聚合管道操作*/
/*性别分组并统计男女数*/

```
db.student.aggregate({
    $group: {
        _id:"$sex",
				num:{$sum:1}
    }
});
```

/*求文档数*/


```
db.student.find().count();
```


/*求属性值 最大*/


```
db.student.aggregate({
    $group: {
        _id:"$id",
	max_value:{$max:"$age"}
    }
});
```

/*求属性值 最小*/

```
db.student.aggregate({
    $group: {
        _id:"$id",
	min_value:{$min:"$age"}
    }
});
```

/*求属性值 平均值 */


```
db.student.aggregate({
    $group: {
        _id:"$id",
	avg_value:{$avg:"$age"}
    }
});
```

## Mongodb系统管理

## Mongodb持久化实战（Java）

# 教材及素材获取
https://www.ossbar.com/#/productDetail?proData=%7B%22productId%22%3A315,%22skuId%22%3A972,%22shopId%22%3A138%7D

# redis简介
 ## Redis（Remote Dictionary Server:远程字典服务）
 
* 是完全开源并免费的，遵守BSD协议，是一个高性能的key-value数据库中

* Redis 与其他key-value 缓存产品有以下三个特点
* Redis支持数据的持久化，可以将内存中的数据保存在磁盘中，重启的时候可以再次加载进行使用。
* Redis不仅仅支持简单的key-value类型的数据，同时还提供list，set，zset，hash等数据结构的存储。
* Redis支持数据的备份，即master-slave模式的数据备份
  
# Redis 优势
*  性能极高 – Redis能读的速度是110000次/s,写的速度是81000次/s 。
* 丰富的数据类型 – Redis支持二进制案例的 Strings, Lists, Hashes, Sets 及 Ordered Sets 数据类型操作。 
* 原子 – Redis的所有操作都是原子性的，意思就是要么成功执行要么失败完全不执行。单个操作是原子性的。多个操作也支持事务，即原子性，通过MULTI和EXEC指令包起来。 
* 丰富的特性 – Redis还支持 publish/subscribe, 通知, key 过期等等特性。
* Redis是内存数据库，数据保存在内存中，访问速度快。MySQL是关系型数据库，功能强大，存储在磁盘中，数据访问速度慢。像memcached，MongoDB，Redis等，都属于No sql系列。
# Redis安装和配置

## 下载安装

1. 官网：https://redis.io
    
2. 中文网：http://www.redis.net.cn/
    
3. 解压直接可以使用：
    
* redis.windows.conf：配置文件
        
* redis-cli.exe：redis的客户端
        
* redis-server.exe：redis服务器端
        
### Windows下安装Redis步骤

1、下载和解压Redis-x64-3.2.100

 Github下载地址：https://github.com/MicrosoftArchive/redis/releases

2、打开cmd指令窗口，输入你刚才解压的文件路径，然后输入以下命令

redis-server redis.windows.conf

3、安装Windows服务

redis-server --service-install redis.windows.conf

4、启动redis服务

#Redis常用的指令

#卸载服务：

redis-server --service-uninstall

#开启服务：

redis-server --service-start

或net start  redis

#停止服务：

redis-server --service-stop

或net stop redis

## 客户端工具推荐

1、Redis Desktop Manager

是一款跨平台开源 Redis ® 管理工具，RDM 是易于使用的 GUI 工具，可用于 Windows，Linux，MacOS，支持命令控制台操作，以及常用，查询key，rename，delete等操作。

下载地址：http://down.123520.net/dir/195471-41859118-4ed9f5

2、AnotherRedisDesktopManager

下载地址：https://github.com/qishibo/AnotherRedisDesktopManager

或国内：https://gitee.com/qishibo/AnotherRedisDesktopManager/releases/v1.5.0

# Redis数据类型及应用场景
## Redis 数据类型

Redis支持五种数据类型：string（字符串），hash（哈希），list（列表），set（集合）及zset(sorted set：有序集合)。

### String（字符串）

* 字符串类型是 Redis 中最基本的数据类型，一个 key 对应一个 value。可以存储二进制数据、图片和 Json 的对象。
* string 类型是二进制安全的。意思是 redis 的 string 可以包含任何数据。比如jpg图片或者序列化的对象。
* string 类型的值最大能存储 512MB。
* 常用命令：get、set、incr、decr、mget等。


### Hash（哈希）

* Redis hash 是一个键值(key=>value)对集合。
* Redis hash 是一个 string 类型的 field 和 value 的映射表，hash 特别适合用于存储对象。
* 常用命令：hget,hset,hgetall 等。
* 比如我们要存储一个用户信息对象数据，包含以下信息：
* 用户ID为查找的key，存储的value用户对象包含姓名，年龄，生日等信息，如果用普通的key/value结构来存储，主要有以下2种存储方式：
* 方法一：将用户ID作为查找key,把其他信息封装成一个对象以序列化的方式存储，这种方式的缺点是，增加了序列化/反序列化的开销，并且在需要修改其中一项信息时，需要把整个对象取回，并且修改操作需要对并发进行保护，引入CAS等复杂问题。
* 方法二：是这个用户信息对象有多少成员就存成多少个key-value对儿，用用户ID+对应属性的名称作为唯一标识来取得对应属性的值，虽然省去了序列化开销和并发问题，但是用户ID为重复存储，如果存在大量这样的数据，内存浪费还是非常可观的。那么Redis提供的Hash很好的解决了这个问题，Redis的Hash实际是内部存储的Value为一个HashMap，并提供了直接存取这个Map成员的接口，如下图：
* 也就是说，Key仍然是用户ID, value是一个Map，这个Map的key是成员的属性名，value是属性值，这样对数据的修改和存取都可以直接通过其内部Map的Key(Redis里称内部Map的key为field), 也就是通过 key(用户ID) + field(属性标签) 就可以操作对应属性数据了，既不需要重复存储数据，也不会带来序列化和并发修改控制的问题，很好的解决了问题。
### List（列表）

Redis 列表是简单的字符串列表，按照插入顺序排序。你可以添加一个元素到列表的头部（左边）或者尾部（右边）。

### Set（集合）

* Redis 的 Set 是 string 类型的无序集合。
* 集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是 O(1)。
* sadd 命令
* 添加一个 string 元素到 key 对应的 set 集合中，成功返回 1，如果元素已经在集合中返回 0。
* 注意：以上实例中 rabbitmq 添加了两次，但根据集合内元素的唯一性，第二次插入的元素将被忽略。
* 集合中最大的成员数为 2^32- 1(4294967295, 每个集合可存储40多亿个成员)。

### zset(sorted set：有序集合)

* Redis zset 和 set 一样也是string类型元素的集合,且不允许重复的成员。
* 不同的是每个元素都会关联一个double类型的分数。redis正是通过分数来为集合中的成员进行从小到大的排序。
* zset的成员是唯一的,但分数(score)却可以重复。

## Redis基本操作

## 库与key的操作命令
* key操作命令
* 获得符合规则的键名列表
* KEYS pattern
* pattern 支持 glob 风格通配符：
* set 设置key的值语法
* set key value

```
127.0.0.1:6379> set name zhangsan
 OK 
127.0.0.1:6379> set age 25
OK
```

### get 获取key的值
get key
```
 127.0.0.1:6379> get name "zhangsan"
```

del 删除key
del key

```
127.0.0.1:6379> del name (integer) 1
```


### 判断key是否存在
exists 判断key是否存在
存在返回1，不存在返回0 

```
127.0.0.1:6379> exists name (integer) 1
 127.0.0.1:6379> exists title
 (integer) 0
```

### type 获取key类型
type key
### 获取key存储的值的类型 

```
127.0.0.1:6379> type name string 
127.0.0.1:6379> type age string
```

expire 设置key有效期
expire key
### 设置key的生命周期 
 expire key 表示以秒为单位设置声明周期

```
127.0.0.1:6379[1]> expire login 60 
(integer) 1 
127.0.0.1:6379[1]> ttl login
 (integer) 47
```

tll 查看key有效期
ttl key
### 查询key的生命周期 
大于0 ：生命周期单位为秒， # 等于-1：永久有效 # 等于-2：该key不存在 # pttl key表示秒为单位 


```
 127.0.0.1:6379> ttl name
 (integer) -1 
127.0.0.1:6379> ttl title
 (integer) -2
```

rename 重命名key
rename key newkey
### 重命名key，如果newkey已经存在，修改后则替换新key的值


```
127.0.0.1:6379> set title "redis test" 
OK 
127.0.0.1:6379> exists title
(integer) 1 
127.0.0.1:6379> rename title biaoti 
OK 
127.0.0.1:6379> get biaoti
 "redis test"
```

renamenx 重命名不存在的key
renamenx key newkey
### 重命名key，如果newkey已经存在则不修改。 # nx表示not exists

```
127.0.0.1:6379> keys * 
1) "biaoti" 
2) "age" 
3) "name" 
127.0.0.1:6379> renamenx biaoti name
 (integer) 0
```

persist 设置key永久有效
persist key
### 设置key永久有效

```
127.0.0.1:6379> set login on
 OK 127.0.0.1:6379> expire login 60 
(integer) 1 
127.0.0.1:6379> ttl login
 (integer) 55 
127.0.0.1:6379> persist login 
(integer) 1 
127.0.0.1:6379> ttl login
 (integer) -1
```

move 把key移动到其他库
move key db
### 把key移动到另一个数据库，db为整数 # 示例
库操作命令
dbsize 查看当前有多少个key
dbsize
### 查看当前有多少个key

```
127.0.0.1:6379> dbsize 12
select 选择库
select db
```

### 选择使用哪个数据库
db为整数 # 默认有16个数据库0~15，如果想修改数据库数量，修改redis.conf配置文件的databases值 

```
127.0.0.1:6379> select 1 
OK 
127.0.0.1:6379[2]> select 15 
OK
```

flushdb 删除选中数据库中的key
flushdb
### 删除当前选择数据库中的所有key

```
 127.0.0.1:6379[1]> keys * 
1) "biaoti" 
127.0.0.1:6379[1]> flushdb 
OK 
127.0.0.1:6379[1]> keys *
 (empty list or set)
```

flushall 删除所有库的key
flushall
### 删除所有数据库中的key 

```
127.0.0.1:6379[1]> flushall 
OK 127.0.0.1:6379[1]> select 0 
OK 
127.0.0.1:6379> keys * 
(empty list or set)
```

