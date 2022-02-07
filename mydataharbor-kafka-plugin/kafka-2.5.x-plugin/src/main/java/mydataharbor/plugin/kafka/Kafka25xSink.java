package mydataharbor.plugin.kafka;

import mydataharbor.kafka.common.sink.KafkaSinkConfig;
import mydataharbor.sink.kafka.KafkaSink;

/**
 * Created by xulang on 2022/1/23.
 */
public class Kafka25xSink extends KafkaSink {
  public Kafka25xSink(KafkaSinkConfig simpleKafkaConfig) {
    super(simpleKafkaConfig);
  }
}
