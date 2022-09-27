# study-mongodb
mongodb入门到实战

# NOSQL是什么

NoSQL是对不同于传统的关系数据库的数据库管理系统的统称。
两者存在许多显著的不同点，其中最重要的是NoSQL不使用SQL作为查询语言。其数据存储可以不需要固定的表格模式，也经常会避免使用SQL的JOIN操作，一般有水平可扩展性的特征。
NoSQL一词最早出现于1998年，是Carlo Strozzi开发的一个轻量、开源、不提供SQL功能的关系数据库。
2009年，Last.fm的Johan Oskarsson发起了一次关于分布式开源数据库的讨论，来自Rackspace的Eric Evans再次提出了NoSQL的概念，这时的NoSQL主要指非关系型、分布式、不提供ACID的数据库设计模式。
2009年在亚特兰大举行的"no:sql(east)"讨论会是一个里程碑，其口号是"select fun, profit from real_world where relational=false;"。因此，对NoSQL最普遍的解释是“非关联型的”，强调Key-Value Stores和文档数据库的优点，而不是单纯的反对RDBMS。

NoSQL:Not only SQL的简称，不仅仅是SQL
基于2014年的收入，NoSQL市场领先企业是MarkLogic，MongoDB和Datastax。基于2015年的人气排名，最受欢迎的NoSQL数据库是MongoDB，Apache Cassandra和Redis.

# Mongodb简介

## Mongodb是什么
　MongoDB并非芒果的意思，而是源于 Humongous（巨大）一词。中文叫盲狗db

MongoDB是面向文档的数据库，不是关系型数据库。它将原来**‘行’（row）的概念换成了更加灵活的‘文档’（document）模型**。面向文档的方式可以将文档和数组内嵌进来，所以用一条记录就可以表示很复杂的层次关系。 MongoDB没有模式，文档的键不会事先定义也不会固定不变。

Mongodb主要由文档（Document）、集合（Collection）、数据库（Database）三部分组成。

一个MongoDB实例，由多个数据库（Database）组成；一个数据库，由多个集合（Collection）组成；一个集合，又由多个文档组成。注意Mongodb单个文档大小上限为16MB，确保不会使用过多的内存RAM或在传输过程中占用过多的带宽。为了存储更大的文档，Mongodb提供了GridFS。

程序员注重对象，您的数据库也是。
MongoDB 是一个文档数据库，即在类似 JSON 的文档内存储数据。我们认为面对数据，这种方法非常自然，比传统的排/列模型更加直观和强大。
丰富的 JSON 文档

自然、高效的数据处理方法。

支持将数组和嵌套对象存储为值。

支持灵活、动态结构。

强大的查询语言

查询语言丰富和直观，支持通过任何字段进行筛选和排序，而不受其在文档内的嵌套方式影响。

支持聚合和其他现代使用案例，如基于地理的搜索、图搜索和文本搜索。

查询本身是 JSON 格式，因此很容易进行组合。无需串联字符串即可动态生成 SQL 查询。

## Mogodb特性
　MongoDB的3大技术特色如下所示：

除了上图所示的还支持：

二级索引、动态查询、全文搜索 、聚合框架、MapReduce、GridFS、地理位置索引、内存引擎 、地理分布等一系列的强大功能。

但是其也有些许的缺点，例如：

　多表关联： 仅仅支持Left Outer Join

　SQL 语句支持： 查询为主，部分支持

　多表原子事务： 不支持

　多文档原子事务：不支持

　16MB 文档大小限制，不支持中文排序 ，服务端 Javascript 性能欠佳
 
 ## 关系数据库与Mongodb区别
 
存储方式对比

在传统的关系型数据库中，存储方式是以表的形式存放，而在MongoDB中，以文档的形式存在。

 数据库中的对应关系，及存储形式的说明

MongoDB与SQL的结构对比详解





