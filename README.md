# study-mongodb

Mongodb数据库入门到实战: 结合实践案例，以任务为驱动，对Mongodb技术进行梳理，让开发者快速掌握Mongodb数据库。

# MongoDB是什么
　MongoDB并非芒果的意思，而是源于 Humongous（巨大）一词。中文叫盲狗db

MongoDB是面向文档的数据库，不是关系型数据库。它将原来**‘行’（row）的概念换成了更加灵活的‘文档’（document）模型**。面向文档的方式可以将文档和数组内嵌进来，所以用一条记录就可以表示很复杂的层次关系。 MongoDB没有模式，文档的键不会事先定义也不会固定不变。

Mongodb主要由文档（Document）、集合（Collection）、数据库（Database）三部分组成。

一个MongoDB实例，由多个数据库（Database）组成；一个数据库，由多个集合（Collection）组成；一个集合，又由多个文档组成。注意Mongodb单个文档大小上限为16MB，确保不会使用过多的内存RAM或在传输过程中占用过多的带宽。为了存储更大的文档，Mongodb提供了GridFS。

![image](https://user-images.githubusercontent.com/110378589/194085125-1c6a74ca-00c1-4866-8da2-64f1f85a2fa1.png)

## 程序员注重对象，您的数据库也是。

MongoDB 是一个文档数据库，即在类似 JSON 的文档内存储数据。我们认为面对数据，这种方法非常自然，比传统的排/列模型更加直观和强大。

## 丰富的 JSON 文档

自然、高效的数据处理方法。

支持将数组和嵌套对象存储为值。

支持灵活、动态结构。

## 强大的查询语言

查询语言丰富和直观，支持通过任何字段进行筛选和排序，而不受其在文档内的嵌套方式影响。

支持聚合和其他现代使用案例，如基于地理的搜索、图搜索和文本搜索。

查询本身是 JSON 格式，因此很容易进行组合。无需串联字符串即可动态生成 SQL 查询。

## MongoDB特性

　MongoDB的3大技术特色如下所示：

除了上图所示的还支持：

二级索引、动态查询、全文搜索 、聚合框架、MapReduce、GridFS、地理位置索引、内存引擎 、地理分布等一系列的强大功能。

但是其也有些许的缺点，例如：

　多表关联： 仅仅支持Left Outer Join

　SQL 语句支持： 查询为主，部分支持

　多表原子事务： 不支持

　多文档原子事务：不支持

　16MB 文档大小限制，不支持中文排序 ，服务端 Javascript 性能欠佳
 
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

特点注意：不同的操作系统

从bin文件夹下进入命令行执行,如果是windows7操作系统，不需要 加./

./mongod --config D:\mongodb-win32-x86_64-windows-5.0.11\mongod.conf--install --serviceName  mongodb

注：在cmd操作下执行一定要以管理员身份运行，否则可能造成安装失败

windows10以上操作系统，在开始---右键-----windows终端（管理员）运行，或开始---运行--cmd （ctrl+shift+Enter）调出

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

# 教材及素材获取
https://www.ossbar.com/#/productDetail?proData=%7B%22productId%22%3A315,%22skuId%22%3A972,%22shopId%22%3A138%7D
