<img width="1040" alt="Screenshot 2023-03-01 at 1 00 32 AM" src="https://user-images.githubusercontent.com/43849911/221959014-5afb9d82-f856-4144-a1e9-9e13b0961596.png">

<img width="1027" alt="Screenshot 2023-03-01 at 1 21 30 AM" src="https://user-images.githubusercontent.com/43849911/221963445-937feee7-c735-4b25-9ad5-659a41b82bda.png">

<img width="1136" alt="Screenshot 2023-03-01 at 1 21 56 AM" src="https://user-images.githubusercontent.com/43849911/221963542-dded1f5a-3baf-414e-bd2b-62ba4f90ccf1.png">

<img width="984" alt="Screenshot 2023-03-01 at 1 23 38 AM" src="https://user-images.githubusercontent.com/43849911/221963943-6fa7c16e-b7cd-4d9b-bc34-506707923dd3.png">

<img width="836" alt="Screenshot 2023-03-01 at 1 23 58 AM" src="https://user-images.githubusercontent.com/43849911/221964016-2d04b4b7-f79d-4a43-99da-f9ef63780dc9.png">

<img width="808" alt="Screenshot 2023-03-01 at 1 24 09 AM" src="https://user-images.githubusercontent.com/43849911/221964051-eda8c2ef-00be-4969-b540-a0e8a2cd6071.png">

```
topics , brokers and partitions
```

<img width="826" alt="Screenshot 2023-03-01 at 1 24 39 AM" src="https://user-images.githubusercontent.com/43849911/221964168-44bdd497-17d0-402f-99ed-14972993b215.png">

<img width="1291" alt="Screenshot 2023-03-01 at 1 38 45 AM" src="https://user-images.githubusercontent.com/43849911/221967023-eaa55731-fb29-429d-9f68-ba8a50580a51.png">

```
tar -xzf kafka_2.13-3.4.0.tgz
kafka_2.13-3.4.0

bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties

bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092
Topic: quickstart-events        TopicId: NPmZHyhbR9y00wMglMH2sg PartitionCount: 1       ReplicationFactor: 1	Configs:
Topic: quickstart-events Partition: 0    Leader: 0   Replicas: 0 Isr: 0

bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092
This is my first event
This is my second event

bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
This is my first event
This is my second event
```

https://www.conduktor.io/kafka/kafka-brokers

```

How do the Kafka brokers and clients keep track of all the Kafka brokers if there is more than one? The Kafka team decided to use Zookeeper for this purpose.

Zookeeper is used for metadata management in the Kafka world. For example:
Zookeeper keeps track of which brokers are part of the Kafka cluster
Zookeeper is used by Kafka brokers to determine which broker is the leader of a given partition and topic and perform leader elections
Zookeeper stores configurations for topics and permissions
Zookeeper sends notifications to Kafka in case of changes (e.g. new topic, broker dies, broker comes up, delete topics, etc.…)


A Zookeeper cluster is called an ensemble. It is recommended to operate the ensemble with an odd number of servers, e.g., 3, 5, 7, as a strict majority of ensemble members (a quorum) must be working in order for Zookeeper to respond to requests. Zookeeper has a leader to handle writes, the rest of the servers are followers to handle reads.


All of the APIs and commands that were previously leveraging Zookeeper are migrated to use Kafka instead, so that when clusters are migrated to be without Zookeeper, the change is invisible to clients.

Zookeeper is also less secure than Kafka, and therefore Zookeeper ports should only be opened to allow traffic from Kafka brokers, and not Kafka clients

Zookeeper is used to track cluster state, membership, and leadership

Zookeeper Being Eliminated from Kafka v4.x

In Kafka, replication means that data is written down not just to one broker, but many.


Apache Kafka is used primarily to build real-time data streaming pipelines.



In the cluster below consisting of three brokers, the replication factor is 2. When a message is written down into Partition 0 of Topic-A in Broker 101, it is also written down into Broker 102 because it has Partition 0 as a replica.

Kafka brokers store data in a directory on the server disk they run on. Each topic-partition receives its own sub-directory with the associated name of the topic. The advanced internals of how Kafka stores data is discussed in Kafka Topics Internals: Segments and Indexes.

A single Kafka server is called a Kafka Broker. That Kafka broker is a program that runs on the Java Virtual Machine (Java version 11+) and usually a server that is meant to be a Kafka broker will solely run the necessary program and nothing else.

An ensemble of Kafka brokers working together is called a Kafka cluster. Some clusters may contain just one broker or others may contain three or potentially hundreds of brokers. Companies like Netflix and Uber run hundreds or thousands of Kafka brokers to handle their data.

A broker in a cluster is identified by a unique numeric ID. 

To achieve high throughput and scalability on topics, Kafka topics are partitioned. If there are multiple Kafka brokers in a cluster, then partitions for a given topic will be distributed among the brokers evenly, to achieve load balancing and scalability.


Similar to how databases have tables to organize and segment datasets, Kafka uses the concept of topics to organize related messages.

A topic is identified by its name. For example, we may have a topic called logs that may contain log messages from our application, and another topic called purchases that may contain purchase data from our application as it happens.

Kafka topics can contain any kind of message in any format, and the sequence of all these messages is called a data stream.

Data in Kafka topics is deleted after one week by default (also called the default message retention period), and this value is configurable. This mechanism of deleting old data ensures a Kafka cluster does not run out of disk space by recycling topics over time.

Topics are broken down into a number of partitions. A single topic may have more than one partition, it is common to see topics with 100 partitions.

The number of partitions of a topic is specified at the time of topic creation. Partitions are numbered starting from 0 to N-1, where N is the number of partitions. 

The offset is an integer value that Kafka adds to each message as it is written into a partition. Each message in a given partition has a unique offset.

Apache Kafka offsets represent the position of a message within a Kafka Partition. ffset numbering for every partition starts at 0 and is incremented for each message sent to a specific Kafka partition. This means that Kafka offsets only have a meaning for a specific partition, e.g., offset 3 in partition 0 doesn’t represent the same data as offset 3 in partition 1.

Kafka Offset Ordering
If a topic has more than one partition, Kafka guarantees the order of messages within a partition, but there is no ordering of messages across partitions.

consumers can consume data from Kafka topics partitions individually, but for horizontal scalability purposes it is recommended to consume Kafka topics as a group.

A topic usually consists of many partitions. These partitions are a unit of parallelism for Kafka consumers.

Kafka topics are immutable: once data is written to a partition, it cannot be changed

A traffic company wants to track its fleet of trucks. Each truck is fitted with a GPS locator that reports its position to Kafka. We can create a topic named - trucks_gps to which the trucks publish their positions. Each truck may send a message to Kafka every 20 seconds, each message will contain the truck ID and the truck position (latitude and longitude). The topic may be split into a suitable number of partitions, say 10. There may be different consumers of the topic. For example, an application that displays truck locations on a dashboard or another application that sends notifications if an event of interest occurs.



Partitioning is what enables messages to be split in parallel across several brokers in the cluster. Using this method of parallelism, Kafka scales to support multiple consumers and producers simultaneously. This method of partitioning allows linear scaling for both consumers as well as producers

```

<img width="979" alt="Screenshot 2023-03-01 at 2 11 39 AM" src="https://user-images.githubusercontent.com/43849911/221974721-6ff7cff3-8a1f-4704-b400-7f58c12b8965.png">




