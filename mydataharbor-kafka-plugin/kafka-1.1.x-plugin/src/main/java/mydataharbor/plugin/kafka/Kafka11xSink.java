package mydataharbor.plugin.kafka;

import mydataharbor.kafka.common.sink.KafkaSinkConfig;
import mydataharbor.sink.kafka.KafkaSink;

/**
 * Created by xulang on 2022/1/23.
 */
public class Kafka11xSink extends KafkaSink {
  public Kafka11xSink(KafkaSinkConfig simpleKafkaConfig) {
    super(simpleKafkaConfig);
  }
}
