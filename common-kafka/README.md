## 前提准备
* 1、java环境
* 2、zookeeper环境， 
    * https://www.apache.org/dyn/closer.lua/zookeeper/zookeeper-3.5.7/apache-zookeeper-3.5.7-bin.tar.gz
* 3、kafka 2.5.0     
    * https://mirror.bit.edu.cn/apache/kafka/2.5.0/kafka_2.12-2.5.0.tgz
* 4、参考：
    * https://www.jianshu.com/p/bdd9608df6b3
    * http://kafka.apache.org/quickstart
    * https://zookeeper.apache.org/doc/current/zookeeperAdmin.html#sc_systemReq
    * https://www.w3cschool.cn/zookeeper/zookeeper_installation.html

### 规划目录：
* /usr/local/kafka 上传kafka压缩文件，并解压到目录
* /usr/local/zookeeper 上传zookeeper压缩文件，并解压到目录
* /var/bigdata/zookeeper zookeeper数据目录


### 安装zookeeper
#### 解压
* tar -xzf zookeeper.xxxxx.tgz
* mv zoo_simple.cfg zoo.cfg
#### 编辑配置文件
* vi zoo.cfg
```
dataDir=/var/bigdata/zookeeper
server.1=node01:2888:3888
server.2=node02:2888:3888
server.3=node03:2888:3888
```
#### 配置环境变量
* vi /etc/profile
```
export ZK_HOME=/usr/local/zookeeper
export PATH=$PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HADOOP_HOME/sbin:$ZK_HOME/bin
source /etc/profile
```
#### 配置myid,node02,node03同理
> echo "1" > /var/bigdata/zookeeper/myid
#### 启动集群
> ./zkServer.sh start

### 安装kafka
#### 解压
> tar -xzf kafka_2.12-2.5.0.tgz
#### 配置环境变量
```
export KAFKA_HOME=/usr/local/kafka
export PATH=$PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HADOOP_HOME/sbin:$ZK_HOME/bin:$KAFKA_HOME/bin
source /etc/profile
```
#### 修改配置
> vim /usr/local/kafka/config/server.properties
```
broker.id=1
listeners=PLAINTEXT://node01:9092
zookeeper.connect=node01:2181,node01:2181,node01:2181
```
#### 启动：
> /usr/local/kafka/bin/kafka-server-start.sh -daemon config/server.properties
#### 其中一台创建topic
> /usr/local/kafka/bin/kafka-topics.sh --create --zookeeper node01:2181 --replication-factor 3 --partitions 1 --topic test-topic
#### 查看topic
> /usr/local/kafka/bin/kafka-topics.sh --describe --zookeeper node01:2181 --topic test-topic

