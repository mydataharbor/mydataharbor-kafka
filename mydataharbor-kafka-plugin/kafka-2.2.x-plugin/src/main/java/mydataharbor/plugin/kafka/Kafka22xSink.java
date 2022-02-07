package mydataharbor.plugin.kafka;

import mydataharbor.kafka.common.sink.KafkaSinkConfig;
import mydataharbor.sink.kafka.KafkaSink;

/**
 * Created by xulang on 2022/1/23.
 */
public class Kafka22xSink extends KafkaSink {
  public Kafka22xSink(KafkaSinkConfig simpleKafkaConfig) {
    super(simpleKafkaConfig);
  }
}
