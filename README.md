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
